document.addEventListener("DOMContentLoaded", async () => {
  // Check if user is logged in
  const user = JSON.parse(localStorage.getItem("user"));
  if (!user || user.role !== "client") {
    window.location.href = "/pages/clientlogin.html";
    return;
  }

  // Set client name
  const clientNameElement = document.getElementById("client-name");
  if (clientNameElement) {
    clientNameElement.textContent = user.name || "Client";
  }

  // Show loading state
  showLoading("services-list", "Loading available services...");
  showLoading("bookings-list", "Loading your bookings...");

  // Fetch services data
  try {
    const response = await fetch("http://localhost:8080/serviceProvider/all");
    if (response.ok) {
      const services = await response.json();
      displayServices(services);
    } else {
      throw new Error(`HTTP ${response.status}`);
    }
  } catch (error) {
    console.error("Error fetching services:", error);
    showError("services-list", "Unable to load services. Please check if the backend is running.");
  }

  // Fetch client's bookings
  try {
    const response = await fetch("http://localhost:8080/bookings/all");
    if (response.ok) {
      const bookings = await response.json();
      displayBookings(bookings, user.id);
    } else {
      throw new Error(`HTTP ${response.status}`);
    }
  } catch (error) {
    console.error("Error fetching bookings:", error);
    showError("bookings-list", "Unable to load bookings. Please check if the backend is running.");
  }

  // Add logout functionality
  const logoutBtn = document.getElementById("logout-btn");
  if (logoutBtn) {
    logoutBtn.addEventListener("click", () => {
      localStorage.removeItem("user");
      localStorage.removeItem("token");
      window.location.href = "/index.html";
    });
  }
});

function showLoading(elementId, message) {
  const element = document.getElementById(elementId);
  if (element) {
    element.innerHTML = `
      <div style="text-align: center; padding: 40px; color: #8b0043;">
        <div class="loading" style="margin: 0 auto 15px;"></div>
        <p>${message}</p>
      </div>
    `;
  }
}

function showError(elementId, message) {
  const element = document.getElementById(elementId);
  if (element) {
    element.innerHTML = `
      <div class="error-message">
        <strong>Error:</strong> ${message}
      </div>
    `;
  }
}

function displayServices(services) {
  const servicesList = document.getElementById("services-list");
  if (!servicesList) return;

  servicesList.innerHTML = "";

  if (!services || services.length === 0) {
    servicesList.innerHTML = `
      <div class="empty-state">
        <p>No services available at the moment. Please check back later!</p>
      </div>
    `;
    return;
  }

  services.forEach((service) => {
    const serviceItem = document.createElement("div");
    serviceItem.classList.add("service-item");

    serviceItem.innerHTML = `
      <div class="service-content">
        <h3>${service.spName || 'Service Provider'}</h3>
        <p><strong>Service:</strong> ${service.serviceName || 'General Service'}</p>
        <p><strong>Contact:</strong> ${service.spEmail || 'N/A'}</p>
        <p><strong>Phone:</strong> ${service.spPhoneNumber || 'N/A'}</p>
      </div>
      <div class="service-actions">
        <button class="btn primary" onclick="handleBooking('${service.spId || service.id}', '${service.spName}')">
          Book Service
        </button>
      </div>
    `;

    servicesList.appendChild(serviceItem);
  });
}

function handleBooking(serviceId, serviceName) {
  const user = JSON.parse(localStorage.getItem("user"));
  if (!user) {
    alert("Please log in to book a service.");
    return;
  }

  const confirmBooking = confirm(`Do you want to book "${serviceName}"?\n\nNote: This will create a booking request that needs to be confirmed by the service provider.`);
  
  if (confirmBooking) {
    // Create booking
    const bookingData = {
      clientId: user.id || 1, // Fallback ID for demo
      spId: parseInt(serviceId),
      bookingDate: new Date().toISOString(),
      status: "Pending"
    };

    fetch("http://localhost:8080/bookings/createBooking", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(bookingData),
    })
    .then(response => {
      if (response.ok) {
        alert(`Booking request sent for "${serviceName}"! You will be notified once confirmed.`);
        // Refresh bookings
        location.reload();
      } else {
        throw new Error("Booking failed");
      }
    })
    .catch(error => {
      console.error("Booking error:", error);
      alert("Unable to create booking. Please ensure the backend is running and try again.");
    });
  }
}

function displayBookings(bookings, clientId) {
  const bookingsList = document.getElementById("bookings-list");
  if (!bookingsList) return;

  bookingsList.innerHTML = "";

  if (!bookings || bookings.length === 0) {
    bookingsList.innerHTML = `
      <div class="empty-state">
        <p>You have no bookings yet.</p>
        <p>Browse available services above and book one to get started!</p>
      </div>
    `;
    return;
  }

  // Filter bookings for current client (if clientId is available)
  const clientBookings = clientId ? 
    bookings.filter(booking => booking.client?.clientId === clientId || booking.clientId === clientId) : 
    bookings;

  if (clientBookings.length === 0) {
    bookingsList.innerHTML = `
      <div class="empty-state">
        <p>You have no bookings yet.</p>
        <p>Browse available services above and book one to get started!</p>
      </div>
    `;
    return;
  }

  clientBookings.forEach((booking) => {
    const bookingItem = document.createElement("div");
    bookingItem.classList.add("booking-item");

    const bookingDate = new Date(booking.bookingDate).toLocaleDateString();
    const serviceName = booking.serviceProvider?.service?.serviceName || 'Service';
    const providerName = booking.serviceProvider?.spName || 'Service Provider';

    bookingItem.innerHTML = `
      <div class="booking-content">
        <h4>Booking #${booking.bookingId}</h4>
        <p><strong>Service:</strong> ${serviceName}</p>
        <p><strong>Provider:</strong> ${providerName}</p>
        <p><strong>Date:</strong> ${bookingDate}</p>
        <p><strong>Status:</strong> <span class="status-${booking.status.toLowerCase()}">${booking.status}</span></p>
      </div>
    `;

    bookingsList.appendChild(bookingItem);
  });
}
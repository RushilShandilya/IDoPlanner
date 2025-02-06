document.addEventListener("DOMContentLoaded", async () => {
  // Fetch user data from localStorage
  const user = JSON.parse(localStorage.getItem("user"));
  if (!user || user.role !== "client") {
    window.location.href = "login.html"; // Redirect to login if not logged in as client
  }

  // Set client name
  document.getElementById("client-name").textContent = user.name;

  // Fetch services data (mocked API call to services.json)
  try {
    const response = await fetch("../../api-mock/services.json");
    const services = await response.json();
    displayServices(services);
  } catch (error) {
    console.error("Error fetching services:", error);
  }

  // Fetch client's bookings (mocked API call to bookings.json)
  try {
    const response = await fetch("../../api-mock/bookings.json");
    const bookings = await response.json();
    displayBookings(bookings, user.id);
  } catch (error) {
    console.error("Error fetching bookings:", error);
  }

  //   // Logout button functionality
  //   document.getElementById("logout-btn").addEventListener("click", () => {
  //     localStorage.removeItem("user"); // Clear user data from localStorage
  //     window.location.href = "login.html"; // Redirect to login page
  //   });
});

// Display services in the client dashboard
function displayServices(services) {
  const servicesList = document.getElementById("services-list");
  servicesList.innerHTML = ""; // Clear any existing content

  services.forEach((service) => {
    const serviceItem = document.createElement("div");
    serviceItem.classList.add("service-item");

    const serviceTitle = document.createElement("h3");
    serviceTitle.textContent = service.name;

    const serviceDescription = document.createElement("p");
    serviceDescription.textContent = service.description;

    const bookButton = document.createElement("button");
    bookButton.textContent = "Book Service";
    bookButton.classList.add("btn");
    bookButton.addEventListener("click", () => handleBooking(service.id));

    serviceItem.appendChild(serviceTitle);
    serviceItem.appendChild(serviceDescription);
    serviceItem.appendChild(bookButton);
    servicesList.appendChild(serviceItem);
  });
}

// Handle booking a service
function handleBooking(serviceId) {
  alert(`Booking service ID: ${serviceId}`);
  // Here, you can later integrate actual booking functionality
}

// Display client's past bookings
function displayBookings(bookings, clientId) {
  const bookingsList = document.getElementById("bookings-list");
  bookingsList.innerHTML = ""; // Clear any existing content

  const clientBookings = bookings.filter(
    (booking) => booking.clientId === clientId
  );

  if (clientBookings.length === 0) {
    // bookingsList.innerHTML = "<p>You have no bookings yet.</p>";
    const emptyState = document.createElement("p");
    emptyState.textContent =
      "You have no bookings yet. Browse available services and book one!";
    emptyState.classList.add("empty-state");
    bookingsList.appendChild(emptyState);
  } else {
    clientBookings.forEach((booking) => {
      const bookingItem = document.createElement("div");
      bookingItem.classList.add("booking-item");

      const bookingDate = document.createElement("p");
      bookingDate.textContent = `Date: ${booking.date}`;

      const bookingStatus = document.createElement("p");
      bookingStatus.textContent = `Status: ${booking.status}`;

      bookingItem.appendChild(bookingDate);
      bookingItem.appendChild(bookingStatus);
      bookingsList.appendChild(bookingItem);
    });
  }
}

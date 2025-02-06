document.addEventListener("DOMContentLoaded", async () => {
  // Fetch user data from localStorage
  const user = JSON.parse(localStorage.getItem("user"));
  if (!user || user.role !== "service-provider") {
    window.location.href = "login.html"; // Redirect if not logged in as service provider
  }

  // Set provider name
  document.getElementById("provider-name").textContent = user.name;

  // Fetch services data (mocked API call)
  try {
    const response = await fetch("../../api-mock/services.json");
    const services = await response.json();
    displayServices(
      services.filter((service) => service.providerId === user.id)
    );
  } catch (error) {
    console.error("Error fetching services:", error);
  }

  // Fetch bookings data (mocked API call)
  try {
    const response = await fetch("../../api-mock/bookings.json");
    const bookings = await response.json();
    displayBookings(bookings, user.id);
  } catch (error) {
    console.error("Error fetching bookings:", error);
  }

  // Handle adding a new service
  document.getElementById("add-service-btn").addEventListener("click", () => {
    const serviceName = prompt("Enter service name:");
    if (serviceName) {
      addService(serviceName);
    }
  });
});

// Display services
function displayServices(services) {
  const servicesList = document.getElementById("services-list");
  servicesList.innerHTML = "";

  services.forEach((service) => {
    const serviceItem = document.createElement("div");
    serviceItem.classList.add("service-item");

    const serviceTitle = document.createElement("h3");
    serviceTitle.textContent = service.name;

    const editButton = document.createElement("button");
    editButton.textContent = "Edit";
    editButton.classList.add("edit-btn");
    editButton.addEventListener("click", () => editService(service.id));

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.classList.add("delete-btn");
    deleteButton.addEventListener("click", () => deleteService(service.id));

    serviceItem.appendChild(serviceTitle);
    serviceItem.appendChild(editButton);
    serviceItem.appendChild(deleteButton);
    servicesList.appendChild(serviceItem);
  });
}

// Display bookings for provider
function displayBookings(bookings, providerId) {
  const bookingsList = document.getElementById("bookings-list");
  bookingsList.innerHTML = "";

  const providerBookings = bookings.filter(
    (booking) => booking.providerId === providerId
  );

  if (providerBookings.length === 0) {
    bookingsList.innerHTML = "<p>No bookings yet.</p>";
  } else {
    providerBookings.forEach((booking) => {
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

// Handle adding a service
function addService(name) {
  alert(`Service "${name}" added!`);
  // Later, integrate API for actual database update
}

// Handle editing a service
function editService(serviceId) {
  const newName = prompt("Enter new service name:");
  if (newName) {
    alert(`Service ${serviceId} updated to "${newName}"`);
    // Implement actual API call
  }
}

// Handle deleting a service
function deleteService(serviceId) {
  const confirmDelete = confirm(
    "Are you sure you want to delete this service?"
  );
  if (confirmDelete) {
    alert(`Service ${serviceId} deleted`);
    // Implement actual API call
  }
}

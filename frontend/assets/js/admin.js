// document.addEventListener("DOMContentLoaded", async () => {
//   // Check if the logged-in user is an Admin
//   const user = JSON.parse(localStorage.getItem("user"));
//   if (!user || user.role !== "admin") {
//     window.location.href = "login.html"; // Redirect to login if not logged in as admin
//   }

//   // Fetch mocked data for Clients, Services, and Bookings (replace later with actual API calls)
//   try {
//     const clientsResponse = await fetch("../../api-mock/clients.json");
//     const clients = await clientsResponse.json();
//     displayClients(clients);

//     const servicesResponse = await fetch("../../api-mock/services.json");
//     const services = await servicesResponse.json();
//     displayServices(services);

//     const bookingsResponse = await fetch("../../api-mock/bookings.json");
//     const bookings = await bookingsResponse.json();
//     displayBookings(bookings);
//   } catch (error) {
//     console.error("Error fetching data:", error);
//   }
// });

// // Display Clients in the Admin Dashboard
// function displayClients(clients) {
//   const clientList = document.getElementById("client-list");
//   clientList.innerHTML = ""; // Clear existing content

//   clients.forEach((client) => {
//     const clientItem = document.createElement("div");
//     clientItem.classList.add("client-item");
//     clientItem.textContent = `Client Name: ${client.name}, Email: ${client.email}`;
//     clientList.appendChild(clientItem);
//   });
// }

// // Display Services in the Admin Dashboard
// function displayServices(services) {
//   const serviceList = document.getElementById("service-list");
//   serviceList.innerHTML = ""; // Clear existing content

//   services.forEach((service) => {
//     const serviceItem = document.createElement("div");
//     serviceItem.classList.add("service-item");
//     serviceItem.textContent = `Service: ${service.name}, Description: ${service.description}`;
//     serviceList.appendChild(serviceItem);
//   });
// }

// // Display Bookings in the Admin Dashboard
// function displayBookings(bookings) {
//   const bookingList = document.getElementById("booking-list");
//   bookingList.innerHTML = ""; // Clear existing content

//   bookings.forEach((booking) => {
//     const bookingItem = document.createElement("div");
//     bookingItem.classList.add("booking-item");
//     bookingItem.textContent = `Booking ID: ${booking.id}, Client: ${booking.clientName}, Service: ${booking.serviceName}, Status: ${booking.status}`;
//     bookingList.appendChild(bookingItem);
//   });
// }

document.addEventListener("DOMContentLoaded", async () => {
  // Check if the logged-in user is an Admin
  const user = JSON.parse(localStorage.getItem("user"));
  if (!user || user.role !== "admin") {
    window.location.href = "login.html"; // Redirect to login if not logged in as admin
  }

  // Fetch mocked data for Clients, Services, and Bookings (replace later with actual API calls)
  try {
    const clientsResponse = await fetch("../../api-mock/clients.json");
    const clients = await clientsResponse.json();
    displayClients(clients);

    const servicesResponse = await fetch("../../api-mock/services.json");
    const services = await servicesResponse.json();
    displayServices(services);

    const bookingsResponse = await fetch("../../api-mock/bookings.json");
    const bookings = await bookingsResponse.json();
    displayBookings(bookings);
  } catch (error) {
    console.error("Error fetching data:", error);
  }
});

// Display Clients in the Admin Dashboard
function displayClients(clients) {
  const clientList = document.getElementById("client-list");
  clientList.innerHTML = ""; // Clear existing content

  clients.forEach((client) => {
    const clientItem = document.createElement("div");
    clientItem.classList.add("client-item");
    clientItem.innerHTML = `
        <span>Client Name: <input type="text" value="${client.name}" disabled /></span>
        <span>Email: <input type="text" value="${client.email}" disabled /></span>
        <button class="edit-btn">Edit</button>
        <button class="delete-btn">Delete</button>
      `;

    const editButton = clientItem.querySelector(".edit-btn");
    const deleteButton = clientItem.querySelector(".delete-btn");
    const inputs = clientItem.querySelectorAll("input");

    // Edit button functionality
    editButton.addEventListener("click", () => {
      const isEditing = inputs[0].disabled === false;
      if (isEditing) {
        editButton.textContent = "Edit";
        inputs.forEach((input) => (input.disabled = true));
        // TODO: Send updated data to backend
      } else {
        editButton.textContent = "Save";
        inputs.forEach((input) => (input.disabled = false));
      }
    });

    // Delete button functionality
    deleteButton.addEventListener("click", () => {
      clientItem.remove();
      // TODO: Send delete request to backend
    });

    clientList.appendChild(clientItem);
  });
}

// Display Services in the Admin Dashboard
function displayServices(services) {
  const serviceList = document.getElementById("service-list");
  serviceList.innerHTML = ""; // Clear existing content

  services.forEach((service) => {
    const serviceItem = document.createElement("div");
    serviceItem.classList.add("service-item");
    serviceItem.innerHTML = `
        <span>Service Name: <input type="text" value="${service.name}" disabled /></span>
        <span>Description: <input type="text" value="${service.description}" disabled /></span>
        <button class="edit-btn">Edit</button>
        <button class="delete-btn">Delete</button>
      `;

    const editButton = serviceItem.querySelector(".edit-btn");
    const deleteButton = serviceItem.querySelector(".delete-btn");
    const inputs = serviceItem.querySelectorAll("input");

    // Edit button functionality
    editButton.addEventListener("click", () => {
      const isEditing = inputs[0].disabled === false;
      if (isEditing) {
        editButton.textContent = "Edit";
        inputs.forEach((input) => (input.disabled = true));
        // TODO: Send updated data to backend
      } else {
        editButton.textContent = "Save";
        inputs.forEach((input) => (input.disabled = false));
      }
    });

    // Delete button functionality
    deleteButton.addEventListener("click", () => {
      serviceItem.remove();
      // TODO: Send delete request to backend
    });

    serviceList.appendChild(serviceItem);
  });
}

// Display Bookings in the Admin Dashboard
function displayBookings(bookings) {
  const bookingList = document.getElementById("booking-list");
  bookingList.innerHTML = ""; // Clear existing content

  bookings.forEach((booking) => {
    const bookingItem = document.createElement("div");
    bookingItem.classList.add("booking-item");
    bookingItem.innerHTML = `
        <span>Booking ID: ${booking.id}</span>
        <span>Client: <input type="text" value="${
          booking.clientName
        }" disabled /></span>
        <span>Service: <input type="text" value="${
          booking.serviceName
        }" disabled /></span>
        <span>Status: 
          <select disabled>
            <option value="Confirmed" ${
              booking.status === "Confirmed" ? "selected" : ""
            }>Confirmed</option>
            <option value="Pending" ${
              booking.status === "Pending" ? "selected" : ""
            }>Pending</option>
            <option value="Cancelled" ${
              booking.status === "Cancelled" ? "selected" : ""
            }>Cancelled</option>
          </select>
        </span>
        <button class="edit-btn">Edit</button>
        <button class="delete-btn">Delete</button>
      `;

    const editButton = bookingItem.querySelector(".edit-btn");
    const deleteButton = bookingItem.querySelector(".delete-btn");
    const inputs = bookingItem.querySelectorAll("input, select");

    // Edit button functionality
    editButton.addEventListener("click", () => {
      const isEditing = inputs[0].disabled === false;
      if (isEditing) {
        editButton.textContent = "Edit";
        inputs.forEach((input) => (input.disabled = true));
        // TODO: Send updated data to backend
      } else {
        editButton.textContent = "Save";
        inputs.forEach((input) => (input.disabled = false));
      }
    });

    // Delete button functionality
    deleteButton.addEventListener("click", () => {
      bookingItem.remove();
      // TODO: Send delete request to backend
    });

    bookingList.appendChild(bookingItem);
  });
}

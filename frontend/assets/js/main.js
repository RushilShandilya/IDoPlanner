// document.addEventListener("DOMContentLoaded", function () {
//   // Load header and footer components and ensure both are loaded before proceeding
//   Promise.all([
//     loadComponent("header", "/frontend/components/header.html"),
//     loadComponent("footer", "/frontend/components/footer.html"),
//   ])
//     .then(() => {
//       // After both components are loaded, check login status
//       const user = JSON.parse(localStorage.getItem("user"));

//       const loginLink = document.getElementById("login-link");
//       const registerLink = document.getElementById("register-link");
//       const logoutLink = document.getElementById("logout-link");

//       if (user) {
//         // User is logged in, show logout link and hide login/register links
//         if (loginLink) loginLink.style.display = "none";
//         if (registerLink) registerLink.style.display = "none";
//         if (logoutLink) logoutLink.style.display = "block"; // Show logout link
//       } else {
//         // User is not logged in, show login/register links
//         if (loginLink) loginLink.style.display = "block";
//         if (registerLink) registerLink.style.display = "block";
//         if (logoutLink) logoutLink.style.display = "none"; // Hide logout link
//       }
//     })
//     .catch((error) => {
//       console.error(
//         "Error loading components or checking login status:",
//         error
//       );
//     });
// });

// // Function to load components (header, footer) dynamically with Promise
// async function loadComponent(id, url) {
//   try {
//     const response = await fetch(url);
//     const data = await response.text();
//     const element = document.getElementById(id);
//     if (element) {
//       element.innerHTML = data;
//     } else {
//       console.error(`Element with id '${id}' not found`);
//     }
//   } catch (error) {
//     console.error(`Error loading ${id}:`, error);
//     throw error; // Propagate error to Promise.all
//   }
// }

document.addEventListener("DOMContentLoaded", function () {
  // Load header and footer components and ensure both are loaded before proceeding
  Promise.all([
    loadComponent("header", "/frontend/components/header.html"),
    loadComponent("footer", "/frontend/components/footer.html"),
  ])
    .then(() => {
      // After both components are loaded, check login status
      const user = JSON.parse(localStorage.getItem("user"));

      const loginLink = document.getElementById("login-link");
      const registerLink = document.getElementById("register-link");
      const logoutLink = document.getElementById("logout-link");

      if (user) {
        // User is logged in, show logout link and hide login/register links
        if (loginLink) loginLink.style.display = "none";
        if (registerLink) registerLink.style.display = "none";
        if (logoutLink) logoutLink.style.display = "block"; // Show logout link
        // Add logout functionality
        logoutLink.addEventListener("click", logout);
      } else {
        // User is not logged in, show login/register links and hide logout link
        if (loginLink) loginLink.style.display = "block";
        if (registerLink) registerLink.style.display = "block";
        if (logoutLink) logoutLink.style.display = "none"; // Hide logout link
      }
    })
    .catch((error) => {
      console.error(
        "Error loading components or checking login status:",
        error
      );
    });
});

// Function to load components (header, footer) dynamically with Promise
async function loadComponent(id, url) {
  try {
    const response = await fetch(url);
    const data = await response.text();
    const element = document.getElementById(id);
    if (element) {
      element.innerHTML = data;
    } else {
      console.error(`Element with id '${id}' not found`);
    }
  } catch (error) {
    console.error(`Error loading ${id}:`, error);
    throw error; // Propagate error to Promise.all
  }
}

// Handle logout (clear user data from localStorage and redirect to login page)
function logout() {
  localStorage.removeItem("user"); // Remove user from localStorage
  window.location.href = "/frontend/pages/login.html"; // Redirect to login page
}

document.addEventListener("DOMContentLoaded", function () {
  // Load header and footer components
  Promise.all([
    loadComponent("header", "/components/header.html"),
    loadComponent("footer", "/components/footer.html"),
  ])
    .then(() => {
      // After both components are loaded, check login status
      const user = JSON.parse(localStorage.getItem("user"));

      const loginLink = document.getElementById("login-link");
      const logoutLink = document.getElementById("logout-link");

      if (user) {
        // User is logged in, show logout link
        if (loginLink) loginLink.style.display = "none";
        if (logoutLink) {
          logoutLink.style.display = "block";
          logoutLink.addEventListener("click", logout);
        }
      } else {
        // User is not logged in, show login links
        if (loginLink) loginLink.style.display = "block";
        if (logoutLink) logoutLink.style.display = "none";
      }
    })
    .catch((error) => {
      console.error("Error loading components:", error);
    });
});

// Function to load components dynamically
async function loadComponent(id, url) {
  try {
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    const data = await response.text();
    const element = document.getElementById(id);
    if (element) {
      element.innerHTML = data;
    } else {
      console.error(`Element with id '${id}' not found`);
    }
  } catch (error) {
    console.error(`Error loading ${id}:`, error);
    // Fallback for missing components
    const element = document.getElementById(id);
    if (element && id === 'header') {
      element.innerHTML = `
        <header style="background: rgba(255, 255, 255, 0.2); backdrop-filter: blur(10px); padding: 15px 30px; display: flex; align-items: center; justify-content: space-between;">
          <h2 style="color: #8b0043; margin: 0;">IDo Planner</h2>
          <nav>
            <a href="/index.html" style="margin: 0 15px; color: #8b0043; text-decoration: none;">Home</a>
            <a href="/pages/clientlogin.html" style="margin: 0 15px; color: #8b0043; text-decoration: none;">Client Login</a>
            <a href="/pages/serviceProviderLogin.html" style="margin: 0 15px; color: #8b0043; text-decoration: none;">Service Provider</a>
            <a href="/pages/adminLogin.html" style="margin: 0 15px; color: #8b0043; text-decoration: none;">Admin</a>
          </nav>
        </header>
      `;
    }
    if (element && id === 'footer') {
      element.innerHTML = `
        <footer style="background-color: rgba(0, 0, 0, 0.1); color: #8b0043; text-align: center; padding: 15px;">
          <p>&copy; 2025 IDo Planner. All Rights Reserved.</p>
        </footer>
      `;
    }
  }
}

// Handle logout
function logout() {
  localStorage.removeItem("user");
  localStorage.removeItem("token");
  window.location.href = "/index.html";
}

// Global error handler for fetch requests
window.handleApiError = function(error, fallbackMessage = "An error occurred") {
  console.error("API Error:", error);
  if (error.message.includes('Failed to fetch')) {
    alert("Unable to connect to server. Please check if the backend is running.");
  } else {
    alert(fallbackMessage);
  }
};
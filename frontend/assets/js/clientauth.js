document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("login-form");
    const registerForm = document.getElementById("register-form");
  
    if (loginForm) {
      loginForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
  
        try {
          const response = await fetch("http://localhost:8080/clients/login", {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({ email, password }),
          });
  
          const data = await response.json();
  
          if (response.ok) {
            //localStorage.setItem("token", data.token); // Store JWT token
            localStorage.setItem("user", JSON.stringify(data.user)); // Store user details
            window.location.href = "client/dashboard.html"; // Redirect to client dashboard
          } else {
            alert(data.message || "Login failed. Please check your credentials.");
          }
        } catch (error) {
          console.error("Error during login:", error);
          alert("An error occurred. Please try again later.");
        }
      });
    }
  
    if (registerForm) {
      registerForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const name = document.getElementById("name").value;
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        const phoneNumber = document.getElementById("phonenumber").value;
  
        try {
          const response = await fetch("http://localhost:8080/clients/register", {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({ name, email, password, phoneNumber }),
          });
  
          const data = await response.json();
  
          if (response.ok) {
            alert("Registration successful. Please log in.");
            window.location.href = "clientlogin.html";
          } else {
            alert(data.message || "Registration failed. Please try again.");
          }
        } catch (error) {
          console.error("Error during registration:", error);
          alert("An error occurred. Please try again later.");
        }
      });
    }
  });
  
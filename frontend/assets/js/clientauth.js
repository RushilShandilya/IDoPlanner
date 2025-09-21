document.addEventListener("DOMContentLoaded", () => {
  const loginForm = document.getElementById("client-login-form");
  const registerForm = document.getElementById("client-register-form");

  if (loginForm) {
    loginForm.addEventListener("submit", async (e) => {
      e.preventDefault();
      
      const submitBtn = e.target.querySelector('button[type="submit"]');
      const originalText = submitBtn.textContent;
      submitBtn.innerHTML = '<span class="loading"></span> Logging in...';
      submitBtn.disabled = true;

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

        if (response.ok) {
          const data = await response.json();
          if (data && data.email) {
            localStorage.setItem("user", JSON.stringify({ ...data, role: "client" }));
            showMessage("Login successful! Redirecting...", "success");
            setTimeout(() => {
              window.location.href = "/pages/client/dashboard.html";
            }, 1000);
          } else {
            showMessage("Invalid credentials. Please try again.", "error");
          }
        } else {
          const errorData = await response.json().catch(() => ({}));
          showMessage(errorData.message || "Login failed. Please check your credentials.", "error");
        }
      } catch (error) {
        console.error("Error during login:", error);
        if (error.message.includes('Failed to fetch')) {
          showMessage("Unable to connect to server. Please ensure the backend is running on port 8080.", "error");
        } else {
          showMessage("An error occurred. Please try again later.", "error");
        }
      } finally {
        submitBtn.textContent = originalText;
        submitBtn.disabled = false;
      }
    });
  }

  if (registerForm) {
    registerForm.addEventListener("submit", async (e) => {
      e.preventDefault();
      
      const submitBtn = e.target.querySelector('button[type="submit"]');
      const originalText = submitBtn.textContent;
      submitBtn.innerHTML = '<span class="loading"></span> Registering...';
      submitBtn.disabled = true;

      const name = document.getElementById("name").value;
      const email = document.getElementById("email").value;
      const password = document.getElementById("password").value;
      const phoneNumber = parseInt(document.getElementById("phonenumber").value);

      // Basic validation
      if (!name || !email || !password || !phoneNumber) {
        showMessage("Please fill in all fields.", "error");
        submitBtn.textContent = originalText;
        submitBtn.disabled = false;
        return;
      }

      if (password.length < 6) {
        showMessage("Password must be at least 6 characters long.", "error");
        submitBtn.textContent = originalText;
        submitBtn.disabled = false;
        return;
      }

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
          showMessage("Registration successful! Redirecting to login...", "success");
          setTimeout(() => {
            window.location.href = "/pages/clientlogin.html";
          }, 2000);
        } else {
          showMessage(data.message || "Registration failed. Please try again.", "error");
        }
      } catch (error) {
        console.error("Error during registration:", error);
        if (error.message.includes('Failed to fetch')) {
          showMessage("Unable to connect to server. Please ensure the backend is running on port 8080.", "error");
        } else {
          showMessage("An error occurred. Please try again later.", "error");
        }
      } finally {
        submitBtn.textContent = originalText;
        submitBtn.disabled = false;
      }
    });
  }
});

function showMessage(message, type) {
  // Remove existing messages
  const existingMessages = document.querySelectorAll('.error-message, .success-message');
  existingMessages.forEach(msg => msg.remove());

  // Create new message
  const messageDiv = document.createElement('div');
  messageDiv.className = type === 'error' ? 'error-message' : 'success-message';
  messageDiv.textContent = message;

  // Insert after form or at the top of main
  const form = document.querySelector('form');
  if (form) {
    form.parentNode.insertBefore(messageDiv, form.nextSibling);
  } else {
    document.querySelector('main').prepend(messageDiv);
  }

  // Auto-remove after 5 seconds
  setTimeout(() => {
    messageDiv.remove();
  }, 5000);
}
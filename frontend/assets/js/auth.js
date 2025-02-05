// Handle Login
document
  .getElementById("login-form")
  .addEventListener("submit", async function (event) {
    event.preventDefault();

    const email = document.getElementById("login-email").value;
    const password = document.getElementById("login-password").value;

    // Simulated Backend API Request (Replace with actual API call)
    const fakeDatabase = {
      "planner@example.com": { password: "1234", role: "planner" },
      "guest@example.com": { password: "1234", role: "guest" },
      "vendor@example.com": { password: "1234", role: "serviceProvider" },
    };

    if (fakeDatabase[email] && fakeDatabase[email].password === password) {
      alert("Login successful!");

      const role = fakeDatabase[email].role;

      // Redirect based on role
      if (role === "planner") {
        window.location.href = "planner.html";
      } else if (role === "guest") {
        window.location.href = "guest.html";
      } else if (role === "serviceProvider") {
        window.location.href = "serviceProvider.html";
      }
    } else {
      alert("Invalid email or password. Please try again.");
    }
  });

// Handle Registration
document
  .getElementById("register-form")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    const name = document.getElementById("register-name").value;
    const email = document.getElementById("register-email").value;
    const password = document.getElementById("register-password").value;
    const role = document.getElementById("register-role").value;

    if (name && email && password) {
      alert("Registration successful! Please log in.");
      window.location.href = "login.html";
    } else {
      alert("All fields are required!");
    }
  });

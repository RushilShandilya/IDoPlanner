// // Handle login form submission
// document
//   .getElementById("login-form")
//   ?.addEventListener("submit", async function (e) {
//     e.preventDefault();
//     const email = document.getElementById("email").value;
//     const password = document.getElementById("password").value;

//     try {
//       const usersApiUrl = "../api-mock/users.json";
//       // Fetch mock users data
//       const response = await fetch(usersApiUrl);
//       const users = await response.json();

//       // Find user based on email and password
//       const user = users.find(
//         (u) => u.email === email && u.password === password
//       );

//       if (user) {
//         // Simulate successful login by storing user info
//         localStorage.setItem("user", JSON.stringify(user));

//         // Redirect based on user role
//         if (user.role === "client") {
//           window.location.href = "client/dashboard.html";
//         } else {
//           window.location.href = "index.html";
//         }
//       } else {
//         alert("Invalid credentials, please try again.");
//       }
//     } catch (error) {
//       console.error("Error during login:", error);
//       alert("An error occurred during login. Please try again.");
//     }
//   });

// // Handle registration form submission
// document
//   .getElementById("register-form")
//   ?.addEventListener("submit", async function (e) {
//     e.preventDefault();
//     const name = document.getElementById("name").value;
//     const email = document.getElementById("email").value;
//     const password = document.getElementById("password").value;
//     const role = document.getElementById("role").value;

//     try {
//       // Create new user object
//       const newUser = {
//         id: Date.now(),
//         name,
//         email,
//         password,
//         role,
//       };

//       console.log("Registering new user:", newUser);

//       // Simulate successful registration by storing user info
//       localStorage.setItem("user", JSON.stringify(newUser));

//       // Redirect to login page
//       window.location.href = "login.html";
//     } catch (error) {
//       console.error("Error during registration:", error);
//       alert("An error occurred during registration. Please try again.");
//     }
//   });

// // Handle logout (clear user data from localStorage and redirect to login page)
// function logout() {
//   localStorage.removeItem("user"); // Remove user from localStorage
//   window.location.href = "login.html"; // Redirect to login page
// }

// // Add logout functionality to the header
// document.addEventListener("DOMContentLoaded", function () {
//   const logoutLink = document.getElementById("logout-link");
//   const user = JSON.parse(localStorage.getItem("user"));

//   if (user) {
//     // Show the logout button and set up the logout function
//     logoutLink.style.display = "block";
//   } else {
//     // Hide logout link if user is not logged in
//     logoutLink.style.display = "none";
//   }
// });

// Handle login form submission
document
  .getElementById("login-form")
  ?.addEventListener("submit", async function (e) {
    e.preventDefault();
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
      const usersApiUrl = "../api-mock/users.json";
      // Fetch mock users data
      const response = await fetch(usersApiUrl);
      const users = await response.json();

      // Find user based on email and password
      const user = users.find(
        (u) => u.email === email && u.password === password
      );

      if (user) {
        // // Simulate successful login by storing user info
        // localStorage.setItem("user", JSON.stringify(user));

        // // Redirect based on user role
        // if (user.role === "client") {
        //   window.location.href = "client/dashboard.html";
        // } else {
        //   window.location.href = "index.html";
        // }
        // Simulate successful login by storing user info
        localStorage.setItem("user", JSON.stringify(user));

        // Redirect based on user role using if-else if
        if (user.role === "client") {
          window.location.href = "client/dashboard.html"; // Client dashboard
        } else if (user.role === "admin") {
          window.location.href = "admin/dashboard.html"; // Admin dashboard
        } else if (user.role === "service-provider") {
          window.location.href = "service-provider/dashboard.html"; // Service Provider dashboard
        } else {
          alert("Unrecognized role");
        }
      } else {
        alert("Invalid credentials, please try again.");
      }
    } catch (error) {
      console.error("Error during login:", error);
      alert("An error occurred during login. Please try again.");
    }
  });

// Handle registration form submission
document
  .getElementById("register-form")
  ?.addEventListener("submit", async function (e) {
    e.preventDefault();
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;

    try {
      // Create new user object
      const newUser = {
        id: Date.now(),
        name,
        email,
        password,
        role,
      };

      console.log("Registering new user:", newUser);

      // Simulate successful registration by storing user info
      localStorage.setItem("user", JSON.stringify(newUser));

      // Redirect to login page
      window.location.href = "login.html";
    } catch (error) {
      console.error("Error during registration:", error);
      alert("An error occurred during registration. Please try again.");
    }
  });

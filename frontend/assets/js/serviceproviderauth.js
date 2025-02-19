document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("service-provider-login-form");
    const registerForm = document.getElementById("service-provider-register-form");

    if (loginForm) {
        loginForm.addEventListener("submit", async (e) => {
            e.preventDefault();
            const spEmail = document.getElementById("email").value;
            const spPassword = document.getElementById("password").value;

            try {
                const response = await fetch("http://localhost:8080/serviceProvider/login", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ spEmail,spPassword }),
                });

                const data = await response.json();

                if (response.ok) {
                    //localStorage.setItem("token", data.token); // Store JWT token
                    localStorage.setItem("user", JSON.stringify(data.user)); // Store user details
                    window.location.href = "service-provider/dashboard.html"; // Redirect to service-provider dashboard
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
            const spName = document.getElementById("name").value;
            const spEmail = document.getElementById("email").value;
            const spPassword = document.getElementById("password").value;
            const spPhoneNumber = document.getElementById("phonenumber").value;
            const spServiceName = document.getElementById("service").value;

            try {
                const response = await fetch("http://localhost:8080/serviceProvider/register", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ spName,spEmail,spPassword,spPhoneNumber,spServiceName }),
                });

                const data = await response.json();

                if (response.ok) {
                    alert("Registration successful. Please log in.");
                    window.location.href = "serviceProviderLogin.html";
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

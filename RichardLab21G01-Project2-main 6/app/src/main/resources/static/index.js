// app.js

// Handle form submissions (Login and Registration)
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent page reload
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Basic client-side validation (add more security checks as needed)
    if (username && password) {
        console.log(`Logging in as: ${username}`);
        // You can now send this data to your backend for authentication
    }
});

document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent page reload
    const fullName = document.getElementById('fullName').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const username = document.getElementById('regUsername').value;
    const password = document.getElementById('regPassword').value;

    if (fullName && email && phone && username && password) {
        console.log(`Registering user: ${username}`);
        // You can send this data to your backend to create the user profile
    }
});

// Simulate navigating between sections
const sections = document.querySelectorAll("section");
const navLinks = document.querySelectorAll("nav ul li a");

navLinks.forEach(link => {
    link.addEventListener('click', function(event) {
        event.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        sections.forEach(section => section.style.display = 'none');
        target.style.display = 'block';
    });
});

// Initially hide all sections except login
sections.forEach(section => section.style.display = 'none');
document.getElementById('login').style.display = 'block';

// User Registration Form Validation document.getElementById("registrationForm")?.addEventListener("submit", function(event) {
event.preventDefault();
let username = document.getElementById("username").value.trim(); let password = document.getElementById("password").value.trim();
let confirmPassword = document.getElementById("confirmPassword").value.trim(); let usernameError = document.getElementById("usernameError");
let passwordError = document.getElementById("passwordError");
let confirmPasswordError = document.getElementById("confirmPasswordError") usernameError.innerText = "";
passwordError.innerText = ""; confirmPasswordError.innerText = ""; let isValid = true;
if (username.length < 5) {
usernameError.innerText = "Username must be at least 5 characters long."; isValid = false;
}
if (password.length < 8) {
passwordError.innerText = "Password must be at least 8 characters long."; isValid = false;
}
if (password !== confirmPassword) { confirmPasswordError.innerText = "Passwords do not match."; isValid = false;
}
if (isValid) {
alert("Registration Successful!"); this.reset();
}
});
// Forgot Password Form Validation document.getElementById("forgotPasswordForm")?.addEventListener("submit", function(event) {
event.preventDefault()
let email = document.getElementById("email").value.trim(); let emailError = document.getElementById("emailError"); emailError.innerText = "";
let emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
let existingEmails = ["user@example.com", "admin@bookhaven.com"]; // Simulated database if (!emailPattern.test(email)) {
emailError.innerText = "Please enter a valid email address.";
} else if (!existingEmails.includes(email)) {
emailError.innerText = "This email is not associated with any account.";
} else {
alert("A password reset link has been sent to your email."); this.reset();
}
});
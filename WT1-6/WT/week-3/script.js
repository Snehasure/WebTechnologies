// =====================================
// USER REGISTRATION
// =====================================

document.getElementById("registrationForm")?.addEventListener("submit", function(event){

    event.preventDefault();

    let username = document.getElementById("username").value.trim();
    let email = document.getElementById("registerEmail").value.trim();
    let password = document.getElementById("password").value.trim();
    let confirmPassword = document.getElementById("confirmPassword").value.trim();

    let usernameError = document.getElementById("usernameError");
    let registerEmailError = document.getElementById("registerEmailError");
    let passwordError = document.getElementById("passwordError");
    let confirmPasswordError = document.getElementById("confirmPasswordError");

    usernameError.innerText = "";
    registerEmailError.innerText = "";
    passwordError.innerText = "";
    confirmPasswordError.innerText = "";

    let isValid = true;

    let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;

    // Username Validation
    if(username.length < 5){
        usernameError.innerText = "Username must be at least 5 characters";
        isValid = false;
    }

    // Email Validation
    if(!emailPattern.test(email)){
        registerEmailError.innerText = "Enter valid email";
        isValid = false;
    }

    // Password Validation
    if(password.length < 8){
        passwordError.innerText = "Password must be at least 8 characters";
        isValid = false;
    }

    // Confirm Password Validation
    if(password !== confirmPassword){
        confirmPasswordError.innerText = "Passwords do not match";
        isValid = false;
    }

    if(isValid){

        // Store data in localStorage
        let userData = {
            username: username,
            password: password
        };

        localStorage.setItem(email, JSON.stringify(userData));

        alert("Registration Successful!");

        this.reset();
    }

});


// =====================================
// FORGOT PASSWORD
// =====================================

document.getElementById("forgotPasswordForm")?.addEventListener("submit", function(event){

    event.preventDefault();

    let email = document.getElementById("email").value.trim();

    let emailError = document.getElementById("emailError");
    let verificationMessage = document.getElementById("verificationMessage");

    emailError.innerText = "";
    verificationMessage.innerHTML = "";

    let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;

    // Email Validation
    if(!emailPattern.test(email)){
        emailError.innerText = "Enter valid email address";
        return;
    }

    // Check if email exists
    let storedUser = localStorage.getItem(email);

    if(storedUser == null){
        emailError.innerText = "This email is not associated with any account";
        return;
    }

    // Simulated Verification Link
    verificationMessage.innerHTML = `
        <p class="success">
            A password reset verification link has been sent to your registered email address.
        </p>
    `;

    this.reset();

});


// =====================================
// DYNAMIC CONTENT LOADING
// =====================================

function loadBook(book){

    let contentFrame = document.getElementById("contentFrame");

    if(book === "book1"){

        contentFrame.innerHTML = `
            <h2>Java Programming</h2>
            <p><strong>Author:</strong> James Gosling</p>
            <p><strong>Price:</strong> ₹550</p>
            <p>Learn Java programming from basics to advanced concepts.</p>
        `;
    }

    else if(book === "book2"){

        contentFrame.innerHTML = `
            <h2>Python Programming</h2>
            <p><strong>Author:</strong> Guido van Rossum</p>
            <p><strong>Price:</strong> ₹650</p>
            <p>Comprehensive guide to Python programming.</p>
        `;
    }

    else if(book === "book3"){

        contentFrame.innerHTML = `
            <h2>Web Development</h2>
            <p><strong>Author:</strong> Brendan Eich</p>
            <p><strong>Price:</strong> ₹750</p>
            <p>Master HTML, CSS, JavaScript and modern web technologies.</p>
        `;
    }

}

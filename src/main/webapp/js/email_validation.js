"use strict";

(function () {

    function validateUsername() {
        let username = document.getElementById('username').value;

        switch (true) {
            case username === "":
                console.log("username is blank")
                alert("You must enter your username")
                return false;
            default:
                return true;
        }
    }

    function validatePassword() {
        let password = document.getElementById('password').value;
        let confirmPassword = document.getElementById('confirm-password').value;

        switch (true) {
            case password !== confirmPassword:
                alert("Passwords don't match!")
                return false;
            case password === "":
                alert("Password cannot be empty.")
                return false;
            case confirmPassword !== password:
                alert("Passwords don't match!")
                return false;
            case confirmPassword === "":
                alert("Password cannot be empty.")
                return false;
            default:
                return true;
        }
    }

    function validateEmail() {
        let oldEmail = document.getElementById('old-email').value;
        let newEmail = document.getElementById('new-email').value;

        switch (true) {
            case oldEmail === "":
                alert("You must enter your email.")
                return false;
            case newEmail === "":
                alert("New email cannot be empty")
                return false;
            default:
                return true;
        }
    }

    document.getElementById('change-email-form').addEventListener('submit', function (e) {
        console.log("button is pressed")
        e.preventDefault();
        validateUsername();
        validateEmail();
        validatePassword();

    });
})();

"use strict";

(function () {
    function validateUsername() {
        let oldUsername = document.getElementById('old-username').value;
        let newUsername = document.getElementById('new-username').value;

        switch (true) {
            case oldUsername === "":
                console.log("username is blank")
                alert("You must enter your username")
                return false;
            case newUsername = "":
                alert("You must enter a new username")
                return false;
            case oldUsername === newUsername:
                alert("Usernames cannot be the same")
                return false;
            default:
                return true;
        }
    }

    function validatePassword() {
        let password = document.getElementById('password').value;

        switch (true) {
            case password === "":
                alert("Password cannot be empty!")
                return false;
            default:
                return true;
        }
    }

    let form = document.getElementById('change-household-form')
    form.addEventListener('submit', function (e) {
        console.log("button pressed")
        e.preventDefault();
        console.log("page not refreshed")
        validateUsername();
        console.log("username validate")
        validatePassword();
        console.log("password validate")

        form.submit();
        console.log("form submit")


    });
})();

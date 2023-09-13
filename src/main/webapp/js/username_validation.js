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
            case newUsername ==="":
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
    function stickyForm() {
        let oldUsername = document.getElementById('old-username');
        let newUsername = document.getElementById('new-username');
        sessionStorage.setItem('oldUser', oldUsername.value);
        sessionStorage.setItem('newUser', newUsername.value);
    }
    let form = document.getElementById('change-household-form')
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        validateUsername();
        validatePassword();
        stickyForm();
        form.submit();
    });
    let oldField = document.getElementById('old-username');
    let newField = document.getElementById('new-username');
    oldField.value = sessionStorage.getItem('oldUser');
    newField.value = sessionStorage.getItem('newUser');
})();

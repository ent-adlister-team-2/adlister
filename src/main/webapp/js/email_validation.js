"use strict";
(function () {
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
    function validateEmail() {
        console.log("inside validate email")
        let oldEmail = document.getElementById('old-email').value;
        let newEmail = document.getElementById('new-email').value;
        console.log(oldEmail)
        console.log(newEmail)

        switch (true) {
            case oldEmail === "":
                alert("You must enter your email.!")
                return false;
            case newEmail === "":
                alert("New email cannot be empty!")
                return false;
            case oldEmail === newEmail:
                alert("Emails cannot be the same!")
                return false;
            default:
                return true;
        }
    }
    function stickyForm() {
        let oldEmail = document.getElementById('oldEmail');
        let newEmail = document.getElementById('newEmail');
        sessionStorage.setItem('oldEmail', oldEmail.value);
        sessionStorage.setItem('newEmail', newEmail.value);
    }
    let form = document.getElementById('changeEmailForm')
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        validatePassword();
        validateEmail();
        stickyForm();
        form.submit();
    });
    let oldField = document.getElementById('oldEmail');
    let newField = document.getElementById('newEmail');
    oldField.value = sessionStorage.getItem('oldEmail');
    newField.value = sessionStorage.getItem('newEmail');
})();

"use strict";

(function () {
    function validatePassword() {
        let oldPassword = document.getElementById('old-password').value;
        let newPassword = document.getElementById('new-password').value;
        switch (true) {
            case oldPassword === newPassword:
                alert("Passwords cannot be the same!")
                return false;
            case oldPassword === "":
                alert("Password cannot be empty.")
                return false;
            case newPassword === "":
                alert("Password cannot be empty.")
                return false;
            default:
                return true;
        }
    }
    let form = document.getElementById('change-household-form');
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        console.log(validatePassword());;
        form.submit();
    });
})();

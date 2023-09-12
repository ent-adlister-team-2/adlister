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
    let form = document.getElementById('change-household-form')
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        validatePassword();
        form.submit();
    });
})();

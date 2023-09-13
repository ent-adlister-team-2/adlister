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
    function stickyForm() {
        let name = document.getElementById('name');
        sessionStorage.setItem('name', name.value);
    }
    let form = document.getElementById('change-name-form')
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        validatePassword();
        stickyForm();
        form.submit();
    });
    let nameField = document.getElementById('name');
    nameField.value = sessionStorage.getItem('name');
})();

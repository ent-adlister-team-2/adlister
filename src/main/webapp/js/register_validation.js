"use strict";
(function () {
    function validate() {
      let username = document.getElementById('username').value;
      let email = document.getElementById('email').value;
      let password = document.getElementById('password').value;
      let confirmPassword = document.getElementById('confirm-password');
      switch (true) {
          case username.length <= 4:
              alert("Username must be more than four characters!")
              return false;
          case username.length >= 20:
              alert("Username cannot be more than twenty characters!")
              return false;
          case email.length <= 4:
              alert("Email cannot be empty!")
              return false;
          case password.length <= 4:
              alert("Password must be more than four characters!")
              return false;
          case password.length >=20:
              alert("Password cannot be more than twenty characters!")
              return false;
          case password !== confirmPassword:
              alert("Passwords must match!")
              return false;
          default:
              return true;
      }
    }
    function stickyForm() {
        let username = document.getElementById('username');
        let email = document.getElementById('email');
        sessionStorage.setItem('username', username.value);
        sessionStorage.setItem('email', email.value);
    }
    let form = document.getElementById('register-form');
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        validate();
        if(!validate()) {
            e.preventDefault();
        }
        stickyForm();
        form.submit();
    });
    let userField = document.getElementById('username');
    userField.value = sessionStorage.getItem('username');
    let emailField = document.getElementById('email');
    emailField.value = sessionStorage.getItem('email');
})();

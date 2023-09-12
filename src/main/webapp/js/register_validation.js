(function () {
    "use strict"
    function validate() {
      let username = document.getElementById('username').value;
      let email = document.getElementById('email').value;
      let password = document.getElementById('password').value;
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
      }
    }
});

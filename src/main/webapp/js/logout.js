// LOGOUT NOTIFICATION //

const logoutNotify = document.getElementsByClassName("logout-notify")[0]; //[0] is for the only one element with this class

function handleLogout() {
    alert("You've been logged out!");
}

logoutNotify.addEventListener("click", handleLogout);

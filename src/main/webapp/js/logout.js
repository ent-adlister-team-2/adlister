// LOGOUT NOTIFICATION //

const logoutNotify = document.getElementsByClassName("logout-notify")[0]; // Assuming there's only one element with this class

function handleLogout() {
    alert("You've been logged out!");
    console.log("FIRED");
}

logoutNotify.addEventListener("click", handleLogout);

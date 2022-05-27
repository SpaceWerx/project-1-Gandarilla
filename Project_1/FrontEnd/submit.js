document.getElementById("logout-button").addEventListener("click", logout);

function logout() {

    localStorage.removeItem("current-user");

    window.location.href = "FrontEnd\login.html";
}

function logout(){

    localStorage.removeItem("current-user");

    window.location.href = "../login/login.html";
}

document.getElementById("submit-form").addEventListener("submit", attemptSubmit);
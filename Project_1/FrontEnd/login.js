const url = "http://localhost:3000/";
document.getElementById("loginButton").addEventListener("click", login);
//login function authenticates with backend to verify user exists in database and password matches
async function login(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        user:usern,
        password:userp
    }
    
    console.log(user);
    let response = await fetch(url + "login", {
        method:"POST",
        body: JSON.stringify(user),
        credentials:"include"
    });
    console.log(response.status);
    if(response.status === 201){
        window.location.href="employee.html";
        window.location.href;
    }
    if(response.status === 202){
        window.location.href="reimbursementportal.html";
        window.location.href;
    }
    
}
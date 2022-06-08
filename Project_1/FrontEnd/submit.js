document.getElementById("logout-button").addEventListener("click", logout);
function logout() {

    localStorage.removeItem("current-user");

    window.location.href = "FrontEnd\login.html";
}

document.getElementById("submit-button").addEventListener("click", submitReimbursement);

async function submitReimbursement(){

    const reimtype = document.getElementById("typeInput").value;
    const reimdescription = document.getElementById("description").value;
    const reimamount = document.getElementById("amount").value;
    let string, Status = "Pending";
    
    
    let reimbursement = {
        "id" : 0,
        "author":0,
        "resolver" : 0,
        "type" : reimtype,
        "description" : reimdescription,
        "amount": reimamount,
        "status": Status
    };
    
    console.log(reimbursement);
    let response = await fetch("http://localhost:3000/submit", {
        method: "POST",
        body: JSON.stringify(reimbursement),
        credentials:"include"
    });
    console.log(response.status);
    
    }
    
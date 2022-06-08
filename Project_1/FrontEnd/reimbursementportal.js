document.getElementById("logout-button").addEventListener("click", logout);

function logout() {

    localStorage.removeItem("current-user");

    window.location.href = "FrontEnd\login.html";
}

document.getElementById("getreimbursements").addEventListener("click", getallreimbursements);

async function getallreimbursements(){
    let response = await fetch("http://localhost:3000/reimbursement", { 
        method:"GET",
        credentials:"omit"
        
    });
    console.log(response);
    if(response.status ===200){
        let data = await response.json();
        console.log(data);
        for(let reimbursement of data){
            let row = document.createElement("tr");
            let cell = document.createElement("td");
            
            cell.innerHTML = reimbursement.ID;
            row.appendChild(cell); 
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.Author;
            row.appendChild(cell2);
            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursement.Resolver;
            row.appendChild(cell3);
            let cell4 = document.createElement("td");
            cell4.innerHTML = reimbursement.Type;
            row.appendChild(cell4);
            let cell5 = document.createElement("td");
            cell5.innerHTML = reimbursement.Description;
            row.appendChild(cell5);
            let cell6 = document.createElement("td");
            cell6.innerHTML = reimbursement.Status;
            row.appendChild(cell6);
            let cell7 = document.createElement("td");
            cell7.innerHTML = reimbursement.Amount;
            row.appendChild(cell7);
            document.getElementById("reimbursementbody").appendChild(row);
        }
    }
}
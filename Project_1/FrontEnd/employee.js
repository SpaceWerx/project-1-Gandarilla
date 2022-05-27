document.getElementById("logout-button").addEventListener("click", logout);

function logout() {

    localStorage.removeItem("current-user");

    window.location.href = "FrontEnd\login.html";
}

const authHeader = localStorage.getItem("current-user");

if(authHeader) {

    if(authHeader) {

        sendAjaxRequest("GET", 'http://localhost:3000/reimbursements?author=${authHeader}', null, tableRenderSuccess, tableRenderFailed, authHeader)
    } else {
        window.location.href =  "FrontEnd\login.html";
    
    }

function tableRenderSuccess(xhr) {

    const reimbursements = JSON.parse(xhr.responseText);

    document.getElementById("display-table").hidden = false;

    const tableBody = document.getElementById("display-table-body");

    for (let reimbursement of reimbursements) {
        
        let newRow = document.createElement("tr");

        let idColumn = document.createElement("td");

        idColumn.innerText = reimbursement.id;

        newRow.appendChild(idColumn);

        let typeColumn = document.createElement("td");

        typeColumn.innerText = reimbursement.type;

        newRow.appendChild(typeColumn);

        let descriptionColumn = document.createElement("td");
        descriptionColumn.innerText = reimbursement.description;

        newRow.appendChild(descriptionColumn);

        let amountColumn = document.createElement("td");

        amountColumn.innerText = reimbursement.amount;

        newRow.appendChild(amountColumn);

        let statusColumn = document.createElement("td");
        
        statusColumn.innerText = reimbursement.status;

        newRow.appendChild(newRow);
    
    }
}

function tableRenderFailed(xhr) {

    const messageDiv = document.getElementById("message");

    messageDiv.hidden = false;

    messageDiv.innerText = xhr.responseText;
}


}
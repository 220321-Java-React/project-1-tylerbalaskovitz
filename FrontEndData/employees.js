const url = "http://localhost:3000"; //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in fetch requests and make calls to our server by appending endpoints

//add an event listener to give our buttons functionality (using DOM selection)
//"When the getReimbursements gets clicked, execute the getReimbursements function"
document.getElementById("getPendingRequests").addEventListener("click", getReimbursements);

//"When the getHistory gets clicked, execute the getHistory"
document.getElementById("getPastTickets").addEventListener("click", getHistory);

document.getElementById("submitRequest").addEventListener("click", submitRequests)


//getReimbursements is an async function which has a fetch request to get the Reimbursements from our server
//remember, async makes a function return a Promise (which fetch requests return)
async function getReimbursements() {

    //we will send a fetch request to get out employee data
    //by default, fetch requests send GET requests (see how to send others like POST below)
    let response = await fetch(url + "/getReimbursements", {credentials: "include"});

    //log the response in the console just to see the response object (good for debugging)
    console.log(response);

    //control flow on the status code (which tells us whether the request was successful)
    //we can access the status code (as well as other stuff) through our response variable
    if(response.status === 200) { //"if the response has a status code of 200..."

        //parse the JSON we get back into a JS object
        //.json() is the JS method that takes json and turns it into a JS object
        let data = await response.json();

        //log the actual employee data that's been parsed from JSON (good for debugging)
        console.log(data);

        //For every Employee object we get back from our fetch request, put it in the table
        for(let reimbursement of data){

            //create a table row, hence tr is table row
            let row = document.createElement("tr");

            //create a data cell for each Reimbursement field hence td is table data
            let cell = document.createElement("td");

            //fill the cell with the appropriate Reimbursement data
            cell.innerHTML = reimbursement.reimb_id;
            //add the td element (data cell) to the tr element (table row)
            row.appendChild(cell);

            //we do this^^^^ for every column in employees

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.reimb_description;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursement.reimb_amount;
            row.appendChild(cell3);
            
            let cell4 = document.createElement("td");
            cell4.innerHTML = reimbursement.reimb_status_id;
            row.appendChild(cell4);

            

            //append the tr (which we called "row") to the table body (tbody)
            //a new row will be appended FOR every employee that got returned in the fetch()
            document.getElementById("pendingRequestsBody").appendChild(row);

        }
        //so here, for every employee object, we create a new row, fill it with data, add it to table

    } else {
        //alert causes a popup!!
        alert("uh oh your session is inactive. Maybe not logged in? :/");
    }



}

//this function is used for the approveDenyButton above
async function submitRequests(){

    //when the submit button is clicked the data put into the fields is taken via the getElementById function with the specific ID's listed below.
    let reimbursementDescription = document.getElementById("requestDescription").value;
    let reimbursementAmount = document.getElementById("requestAmount").value;

    //This is a JavaScript Object created so that we can have the employees send
    //data via JSON
    let newTicket = {
        description: reimbursementDescription,
        amount: reimbursementAmount
    }
    //the object above should be the same as the login DTO in our Java because this is
    //what we want to transfer. IE: if there are private strings then
    //their names should be the same for it to be sent nicely. 


    //The console.log has been created so that way debugging can be done effectively
    console.log(newTicket);

    //Now we're creating a fetch request and need a specific URL for this to work
    let response  = await fetch(url+"/submit", {

        method: "POST",
        body: JSON.stringify(newTicket),
        credentials: "include"

    })


        //this logs to the console the status code which is useful for debugging
    console.log(response.status);


    //finally control flow needs to be added to the end of the function if the
    //'post' was or wasn't successful

    //the status code we're looking for below is to see whether or not the 
    //request has been accepted.

    // in addition strict equality (===) is used to check the TYPE and the VALUE together
    if(response.status === 202){

        let data = await response.json();

        alert("Your Ticket was successfully submitted.")


    } else {
        alert("Your Ticket Failed to Submit.")
    }



}



//this function will send the user-inputted login credentials to our server
async function getHistory(){

//we will send a fetch request to get out employee data
    //by default, fetch requests send GET requests (see how to send others like POST below)
    let response = await fetch(url + "/getReimbursements", {credentials: "include"});

    //log the response in the console just to see the response object (good for debugging)
    console.log(response);

    //control flow on the status code (which tells us whether the request was successful)
    //we can access the status code (as well as other stuff) through our response variable
    if(response.status === 200) { //"if the response has a status code of 200..."

        //parse the JSON we get back into a JS object
        //.json() is the JS method that takes json and turns it into a JS object
        let data = await response.json();

        //log the actual employee data that's been parsed from JSON (good for debugging)
        console.log(data);

        //For every Employee object we get back from our fetch request, put it in the table
        for(let reimbursement of data){

            //create a table row, hence tr is table row
            let row = document.createElement("tr");

            //create a data cell for each Reimbursement field hence td is table data
            let cell = document.createElement("td");

            //fill the cell with the appropriate Reimbursement data
            cell.innerHTML = reimbursement.reimb_id;
            //add the td element (data cell) to the tr element (table row)
            row.appendChild(cell);

            //we do this^^^^ for every column in employees

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.reimb_description;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursement.reimb_amount;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = reimbursement.reimb_receipt;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = reimbursement.reimb_author;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimbursement.reimb_resolver;
            row.appendChild(cell6);

            let cell7 = document.createElement("td");
            cell7.innerHTML = reimbursement.reimb_status_id;
            row.appendChild(cell7);

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimbursement.reimb_type_id;
            row.appendChild(cell8);

            //append the tr (which we called "row") to the table body (tbody)
            //a new row will be appended FOR every employee that got returned in the fetch()
            document.getElementById("pastTicketsTable").appendChild(row);

        }
        //so here, for every employee object, we create a new row, fill it with data, add it to table

    } else {
        //alert causes a popup!!
        alert("uh oh your session is inactive. Maybe not logged in? :/");
    }


}
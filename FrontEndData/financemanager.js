const url = "http://localhost:3000"; //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in fetch requests and make calls to our server by appending endpoints

//add an event listener to give our buttons functionality (using DOM selection)
//"When the getEmployeeButton gets clicked, execute the getReimbursements function"
document.getElementById("getAllReimbursements").addEventListener("click", getAllReimbursements);

//"When the loginButton gets clicked, the get History Button is executed. "
document.getElementById("getAllHistoryButton").addEventListener("click", getAllHistory);

//this last 
document.getElementById("approveDenyReview").addEventListener("click", approveDenyButton);


//getReimbursement is an async function which has a fetch request to get employees from our server
//remember, async makes a function return a Promise (which fetch requests return)
async function getAllReimbursements() {

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
            document.getElementById("allReimbursementRequests").appendChild(row);

        }
        //so here, for every employee object, we create a new row, fill it with data, add it to table

    } else {
        //alert causes a popup!!
        alert("uh oh your session is inactive. Maybe not logged in? :/");
    }


}
async function approveDenyButton(){


}



//this function will get the entire history from the database by communicating with the server via Javalin
async function getAllHistory(){


//This object should reflect the LoginDTO in our Java... This is the data we want to transfer

//for debugging purposes, print out the user object to the console
console.log(user);

//fetch request to the server
//rememeber, the second parameter in a fetch is for configuring our fetch request
//fetch sends a GET by default, but we need a POST, as well as some other configs
let response = await fetch(url+"/login", {

    method: "POST", //send a POST request (would be a GET if we didn't specify...)
    body: JSON.stringify(user), //turning our user object into JSON to send to the server
    credentials: "include"
    //this last line will ensure that the cookie is captured (so that we can have a session)
    //future fetches after login will require this "include" value 
})

//log the response status code, useful for debugs
console.log(response.status);



//control flow based on successful/unsuccessful login
if(response.status === 202){

    //converting from json to JS
    let data = await response.json();

    //wipe our login row and welcome the user
    document.getElementById("loginRow").innerText="Welcome " + data.first_name + "!!";

    //THIS IS PROBABLY WHERE YOUR REDIRECT WOULD BE IF USING MULTIPLE HTML PAGES
    //don't be intimidated, it's an easy google :)

} else {
    document.getElementById("welcomeHead").innerText="Login failed! Try Again";
    document.getElementById("welcomeHead").style.color = "red";
}

}
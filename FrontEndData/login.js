const url = "http://localhost:3000"; //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in fetch requests and make calls to our server by appending endpoints

//add an event listener to give our buttons functionality (using DOM selection)
//"When the getEmployeeButton gets clicked, execute the getEmployees function"

//"When the loginButton gets clicked, execute the loginFunction"
document.getElementById("loginButton").addEventListener("click", loginFunction);

//this function will send the user-inputted login credentials to our server
async function loginFunction(){

//gather the user inputs from the login inputs
//when the login button is clicked, the value from username and password will be put into variables
let usern = document.getElementById("username").value;
let userp = document.getElementById("password").value;
let user_role_id;



//we want to send the user/pass as JSON, so we need a JS object first.
let user = {
    username:usern,
    password:userp,

    
}
//This object should reflect the LoginDTO in our Java... This is the data we want to transfer

//this JS object will be the role value of the person logging into the table. With this value, the person will be redirected to the appropriate HTML page AFTER a successful login
//Since this data will not be put in by the user but by checking the database through the server, there will be only one value. 



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

//this fetch request will be used to get the role of the employee. If the user's role below will equal the 'Finance Manager below then the website will redirect you to the
//finance managers page, whereas all other successful logins will redirect you to the employees page. 




//control flow based on successful/unsuccessful login
if(response.status === 202){

    //converting from json to JS
    let data = await response.json();
    
    //wipe our login row and welcome the user. This gets the login row from the HTML page, more specifically the div id = loginRow
    document.getElementById("loginRow").innerText="Welcome " + data.first_name + "!!";

    //THIS IS PROBABLY WHERE YOUR REDIRECT WOULD BE IF USING MULTIPLE HTML PAGES
    //don't be intimidated, it's an easy google :)
    
    //this is the placeholder URL used for when there is a succesful login. Two separate functions need to be made depending on what is being pulled from the database.
    if (data.user_role_id != 1) {
    location.href = 'http://localhost:5500/employees.html';
    } else {
    location.href = 'http://localhost:5500/financemanager.html';
    }

} else {
    document.getElementById("welcomeHead").innerText="Login failed! Try Again";
    document.getElementById("welcomeHead").style.color = "red";
}

}
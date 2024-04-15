/**
 * 
 */

// function validateRegister() {
//     var password = document.getElementById("password").value;
//     var confirmpassword = document.getElementById("confirmPassword").value;
//     var email = document.getElementById("email").value;
//     var parttern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

//     var table = document.getElementById("tbl-result");
//     if (password == confirmpassword && parttern.test(email)) {
//         var row = table.insertRow(-1);

//         var cell1 = row.insertCell(0);
//         var cell2 = row.insertCell(1);
//         var cell3 = row.insertCell(2);
//         var cell4 = row.insertCell(3);
//         var cell5 = row.insertCell(4);

//         cell1.innerHTML = table.rows.length - 1;
//         cell2.innerHTML = document.getElementById("firstName").value;
//         cell3.innerHTML = document.getElementById("lastName").value;
//         cell4.innerHTML = document.getElementById("email").value;
//         cell5.innerHTML = document.getElementById("userName").value;

//     }

// }

function validateRegister() {
	// Get the value that user enters at the form
	var userNameElement = document.getElementById("username");
	var emailElement = document.getElementById("email");

	var passwordElement = document.getElementById("password");
	var repasswordElement = document.getElementById("repassword");

	// variable to check valid input
	var status = false;

	var message = "Please fill all mandatory fields";


	setBorderColor(userNameElement);
	setBorderColor(emailElement);

	setBorderColor(passwordElement);
	setBorderColor(repasswordElement);

	var email = emailElement.value;
	var username = userNameElement.value;
	var password = passwordElement.value;


	if (username != "" && (username.length > 30 || username.length < 3)) {
		message = "User name length must be from 3-30 character";
		userNameElement.style.borderColor = "red";
	}
	if (email != "" && !validateEmail(email)) {
		message = "Email is incorrect format";
		emailElement.style.borderColor = "red";
	}
	else if (email != "" && (email.length < 5 || email.length > 50)) {
		message = "Email length must be from 5-50 character";
		emailElement.style.borderColor = "red";
	}
	else if (password != "" && (8 > password.length || password.length > 30)) {
		message = "password length must be from 8-30 character";
		passwordElement.style.borderColor = "red";
	}
	else if (repasswordElement.value != passwordElement.value) {
		message = "Confirm password is not match with password";
		repasswordElement.style.borderColor = "red";
	}


	// count number of input tags
	var numberOfInput = document.getElementsByTagName("input").length;
	var countNumberValidInput = 0;
	for (var j = 0; j < numberOfInput; j++) {
		// check all input are valid
		if (document.getElementsByTagName("input")[j].style.borderColor == "green") {
			countNumberValidInput++;
		}
	}

	console.log(numberOfInput);
	console.log(countNumberValidInput);
	// if all input are valid, set ok = true
	if (countNumberValidInput == numberOfInput) {
		message = "";
		status = true;
	}

	document.getElementById("error").innerHTML = message;
	// if status -> call method showUserRegisted()
	if (status) {
		window.location.href = "LoginController";
		message = "Success";
	}

}

function validateLogin() {
	// Get the value that user enters at the form
	var emailElement = document.getElementById("email");

	var passwordElement = document.getElementById("password");

	// variable to check valid input
	var status = false;

	var message = "Please fill all mandatory fields";



	setBorderColor(emailElement);

	setBorderColor(passwordElement);


	var email = emailElement.value;
	var password = passwordElement.value;



	if (email != "" && !validateEmail(email)) {
		message = "Email is incorrect format";
		emailElement.style.borderColor = "red";
	}
	else if (email != "" && (email.length < 5 || email.length > 50)) {
		message = "Email length must be from 5-50 character";
		emailElement.style.borderColor = "red";
	}
	else if (password != "" && (8 > password.length || password.length > 30)) {
		message = "password length must be from 8-30 character";
		passwordElement.style.borderColor = "red";
	}


	// count number of input tags
	var numberOfInput = document.getElementsByTagName("input").length;
	var countNumberValidInput = 0;
	for (var j = 0; j < numberOfInput; j++) {
		// check all input are valid
		if (document.getElementsByTagName("input")[j].style.borderColor == "green") {
			countNumberValidInput++;
		}
	}

	// if all input are valid, set ok = true
	if (countNumberValidInput == numberOfInput - 1) {
		message = "";
		status = true;
	}

	document.getElementById("error").innerHTML = message;
	// if status -> call method showUserRegisted()
	if (status) {
		window.location.href = "ViewContentController";
		message = "";


	}

}

/*
This function to create a header row for an existed table and append data to it.
*/
function showUserRegisted() {
	// get element tbody of table with id = tbl-result
	var table = document.getElementById("tbl-result").getElementsByTagName("tbody")[0];
	var index = table.rows.length;
	// if number rows of table == 0, insert th into thead of table
	if (table.rows.length == 0) {
		var thead = document.getElementById("tbl-result").getElementsByTagName("thead")[0];
		// var row = thead.insertRow(0);
		// row.insertCell(0).outerHTML = "<th>No</th>";
		// row.insertCell(1).outerHTML = "<th>First Name</th>";
		// row.insertCell(2).outerHTML = "<th>Last Name</th>";
		// row.insertCell(3).outerHTML = "<th>Email</th>";
		// row.insertCell(4).outerHTML = "<th>Username</th>";
	}
	// insert user registed rows into table result
	var row = table.insertRow(table.rows.length);
	row.insertCell(0).innerHTML = ++index;
	row.insertCell(1).innerHTML = document.getElementById("firstName").value;
	row.insertCell(2).innerHTML = document.getElementsByClassName("lastName")[0].value;
	row.insertCell(3).innerHTML = document.getElementsByTagName("input")[2].value;
	row.insertCell(4).innerHTML = document.getElementById("userName").value;

}
/*
Check valid email.
*/
function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}
/*
Change border to an element.
*/
function setBorderColor(element) {
	if (element.value == "") {
		element.style.borderColor = "red";
	} else {
		element.style.borderColor = "green";
	}
}
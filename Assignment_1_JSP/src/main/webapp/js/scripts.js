/**
 * 
 */
/*!
* Start Bootstrap - Simple Sidebar v6.0.5 (https://startbootstrap.com/template/simple-sidebar)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-simple-sidebar/blob/master/LICENSE)
*/
// 
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

	// Toggle the side navigation
	const sidebarToggle = document.body.querySelector('#sidebarToggle');
	if (sidebarToggle) {
		// Uncomment Below to persist sidebar toggle between refreshes
		// if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
		//     document.body.classList.toggle('sb-sidenav-toggled');
		// }
		sidebarToggle.addEventListener('click', event => {
			event.preventDefault();
			document.body.classList.toggle('sb-sidenav-toggled');
			localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
		});
	}



});

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

function validateEditProfile() {
	// Get the value that user enters at the form
	var firstNameElement = document.getElementById("firstName");
	var lastNameElement = document.getElementById("lastName");

	var phoneElement = document.getElementById("phone");
	var descriptionElement = document.getElementById("description");

	// variable to check valid input
	var status = false;

	var message = "Please fill all mandatory fields";


	setBorderColor(firstNameElement);
	setBorderColor(lastNameElement);

	setBorderColor(phoneElement);
	setBorderColor(descriptionElement);

	var firstName = firstNameElement.value;
	var lastName = lastNameElement.value;
	var phone = phoneElement.value;
	var description = descriptionElement.value;


	if (firstName != "" && (firstName.length > 30 || firstName.length < 3)) {
		message = "FirstName length must be from 3-30 character";
		firstNameElement.style.borderColor = "red";
	}
	if (lastName != "" && (lastName.length > 30 || lastName.length < 3)) {
		message = "LastName length must be from 3-30 character";
		lastNameElement.style.borderColor = "red";
	}

	else if (phone != "" && (phone.length < 9 || phone.length > 13)) {
		message = "Phone length must be from 9-13 character";
		phoneElement.style.borderColor = "red";
	}
	else if (description.length > 200) {
		message = "description length must be less than 200 character";
		descriptionElement.style.borderColor = "red";
	}


	// count number of input tags
	var numberOfInput = document.getElementsByTagName("input").length;
	var countNumberValidInput = 1;
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
		descriptionElement.style.borderColor = "green";

	}

}

function validateAddContent() {
	// Get the value that user enters at the form
	var titleElement = document.getElementById("title");

	var briefElement = document.getElementById("brief");

	var contentElement = document.getElementById("content");

	// variable to check valid input
	var status = false;

	var message = "Please fill all mandatory fields";



	setBorderColor(titleElement);

	setBorderColor(briefElement);

	setBorderColor(contentElement);


	var title = titleElement.value;
	var brief = briefElement.value;
	var content = contentElement.value;


	if (title != "" && (title.length < 10 || title.length > 200)) {
		message = "Title length must be from 10-200 character";
		titleElement.style.borderColor = "red";
	}
	else if (brief != "" && (30 > brief.length || brief.length > 150)) {
		message = "Brief length must be from 30-150 character";
		briefElement.style.borderColor = "red";
	}
	else if (content != "" && (50 > content.length || content.length > 1000)) {
		message = "Content length must be from 50-1000 character";
		contentElement.style.borderColor = "red";
	}


	// count number of input tags
	var numberOfInput = document.getElementsByTagName("input").length;
	var countNumberValidInput = 1;
	for (var j = 0; j < numberOfInput; j++) {
		// check all input are valid
		if (document.getElementsByTagName("input")[j].style.borderColor == "green") {
			countNumberValidInput++;
		}
	}
	var numberOfTextArea = document.getElementsByTagName("textarea").length;
	var countNumberValidTextArea = 0;
	for (var i = 0; i < numberOfTextArea; i++) {
		// check all input are valid
		if (document.getElementsByTagName("textarea")[i].style.borderColor == "green") {
			countNumberValidTextArea++;
		}
	}
	console.log(countNumberValidInput);
	console.log(numberOfInput);
	console.log(countNumberValidTextArea);
	console.log(numberOfTextArea);


	// if all input are valid, set ok = true
	if (countNumberValidInput == numberOfInput && countNumberValidTextArea == numberOfTextArea) {
		message = "";
		status = true;
	}

	document.getElementById("error").innerHTML = message;
	// if status -> call method showUserRegisted()
	if (status) {
		window.location.href = "file:///E:/files/Projects%20VSCode/project/userinterface/ViewContent.html";

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

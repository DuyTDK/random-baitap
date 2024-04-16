<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Update Book</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/CreateBook.css" />

</head>

<body>
	<div class="allcontent">
		<div class="top-header" id="top-header">
			<h1 style="color: blue;">BOOK MANAGEMENT WEB APPLICARION</h1>
		</div>
		<div class="content">



			<div class="sidebar" style="width: 20%">
				<a href="http://localhost:8080/DuyTDK_/view/CreateBook.jsp"
					class="sidebar-link">Add a Book</a><br> <a
					href="http://localhost:8080/DuyTDK_/view/ListBook.jsp"
					class="sidebar-link">List Book</a>
			</div>

			<div class="main" style="margin-left: 5%;">
				<h2>Update Book</h2>
				<form id="formAdd" onsubmit="submitForm(event)" name="frm-register">
					<table id="tbl-register">
						<tr>
							<td>Book Title <span id="star">*</span>:
							</td>
							<td><input type="text" name="Btitle" class="Btitle"
								id="Btitle" value="" maxlength="10" required />
								<p id="Btitle-error" class="error"></p></td>
						</tr>
						<tr>
							<td>Page Count :</td>
							<td><input type="number" name="BookPage" id="BookPage"
								value="" required />
								<p id="BookPage-error" class="error"></p></td>

						</tr>
						<tr>
							<td>Price <span id="star">*</span>:
							</td>
							<td><input type="number" name="Price" id="Price" value=""
								required />
								<p id="Price-error" class="error"></p></td>
						</tr>
						<tr>
							<td>Date published :</td>
							<td><input type="date" id="DP" name="DP" value="" required />
								<p id="DP-error" class="error"></p></td>
						</tr>
						<tr>
							<td>Author Name<span id="star">*</span>:
							</td>
							<td><select id="Aname" name="Aname">
									<option value="" selected="" disabled="">Join Smith</option>

									<option value="Name 1">Name 1</option>
									<option value="Name 2">Name 2</option>
									<option value="Name 3">Name 3</option>
									<option value="Name 4">Name 4</option>
									<option value="Name 5">Name 5</option>
							</select></td>
						</tr>
						<tr>
							<td>Status<span id="star">*</span>:
							</td>
							<td><label for="Active"><input id="Active"
									type="radio" name="Active-InActive" checked>Active</label> <label
								for="InActive"><input id="InActive" type="radio"
									name="Active-InActive"> InActive</label>
								<p id="Status-error" class="error"></p></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Update"></td>
						</tr>
					</table>
				</form>
			</div>


		</div>

	</div>
	<div class="footer">
		<h6>Copyright - FSOFT Fresher Academy</h6>
	</div>
</body>

</html>
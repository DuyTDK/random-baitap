<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Create Book</title>
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
				<h2>Create Book</h2>
				<form id="formAdd" action="create" method="POST">
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
							<td><select id="Aname" name="Author_Id">
								<c:forEach items="${authors}" var="author">
									<option value="${author.getAuthor_ID()}">${author.getAuthor_Name()}</option>
								</c:forEach>
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
							<td><input type="submit" value="Create"></td>
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
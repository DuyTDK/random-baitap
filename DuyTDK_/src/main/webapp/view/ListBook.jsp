<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>List Book</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ListBooks.css" />

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
				<h2>List Books</h2>
				<div class="profile-container">
					<div>
						<div class="profile-container-header"></div>
						<div class="content-table">
							<table class="table table-bordered">
								<thead>
									<tr class="table-title">
										<th class="tableNumber" scope="col">Book ID</th>
										<th class="tableTitle" scope="col">Book Title</th>
										<th class="tableBrief" scope="col">Price</th>
										<th class="tableDate" scope="col">Page Count</th>
										<th class="tableDate" scope="col">Date Published</th>
										<th class="tableDate" scope="col">Author Name</th>
										<th class="tableDate" scope="col">Active</th>
										<th class="tableDate" scope="col"></th>

									</tr>
								</thead>
								<tbody>
											<c:forEach items="${books}" var="book">
												<tr class="datarow">
													<th scope="row">${book.getbook_ID}</th>
													<td>${book.getTitle()}</td>
													<td>
														<p>${book.getPage_Count()}</p>
													</td>
													<td>
														<p>${book.getDate_Published()}</p>
													</td>
													<td>
														<p>${book.getPrice()}</p>
													</td>
													<td>
														<p>${book.getStatus()}</p>
													</td>
													<td>
														<p>${book.getAuthor_ID()}</p>
													</td>
													
												</tr>
											</c:forEach>
										</tbody>
							</table>
						</div>
					</div>

				</div>


			</div>
		</div>


	</div>

	<div class="footer">
		<h6>Copyright - FSOFT Fresher Academy</h6>
	</div>
</body>

</html>
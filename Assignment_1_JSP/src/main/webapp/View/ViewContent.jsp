<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<script src="https://kit.fontawesome.com/cc5101c50a.js"
	crossorigin="anonymous"></script>
<title>View Content</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-git.js"></script>
</head>

<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">
			<div class="sidebar-heading border-bottom bg-light">CMS</div>
			<div class="list-group list-group-flush">
				<a class="list-group-item list-group-item-light p-3">
					<div class="input-group">
						<input type="search" class="form-control rounded"
							placeholder="Search" aria-label="Search"
							aria-describedby="search-addon" />
						<button type="button" class="btn btn-outline-primary">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>

					</div>
				</a> <a id="view-content"
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="#"><i class="fa fa-table" aria-hidden="true"></i> View
					content</a> <a id="form-content"
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="#"><i class="fa-solid fa-pen-to-square"></i> Form content</a>

			</div>
		</div>
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<div class="container-fluid">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ms-auto mt-2 mt-lg-0">
							<li class="nav-item-dropdown"><a
								class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
								role="button" data-bs-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"><i class="fa fa-user"
									aria-hidden="true"></i></a>
								<div class="dropdown-menu dropdown-menu-end"
									aria-labelledby="navbarDropdown">

									<a id="user-profile" class="dropdown-item" href="#"><i
										class="fa fa-user" aria-hidden="true"></i> User Profile</a>
									<div class="dropdown-divider"></div>
									<a id="log-out" class="dropdown-item" href="#"><i
										class="fa-sharp fa-solid fa-right-from-bracket"></i> Log Out</a>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Page content-->
			<div class="container-fluid">
				<div class="page-container">
					<div class="content-header">
						<h3>View Content</h3>
						<div class="search-bar-right">
							<button type="button" class="btn btn-outline-primary">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
							<input type="search" class="form-control rounded"
								aria-label="Search" aria-describedby="search-addon" />


						</div>
						<div class="top-right-dropdown">
							<button type="button" data-toggle="dropdown">
								<i class="fa-solid fa-filter"></i> Filter by
							</button>
						</div>
						<div class="dropdown-top-right">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								data-toggle="dropdown" aria-expanded="false">Title</button>
							<div class="dropdown-menu">
								<button class="dropdown-item" type="button">Action</button>
								<button class="dropdown-item" type="button">Another
									action</button>
								<button class="dropdown-item" type="button">Something
									else here</button>
							</div>
						</div>
						<button type="button" class="btn btn-primary btn-top-right">Search
						</button>

					</div>

					<div class="profile-container">
						<div>
							<div class="profile-container-header">
								<h6>View Content List</h6>
							</div>
							<div class="content-table">
								<table class="table table-bordered">
									<thead>
										<tr class="table-title">
											<th class="tableNumber" scope="col">#</th>
											<th class="tableTitle" scope="col">Title</th>
											<th class="tableBrief" scope="col">Brief</th>
											<th class="tableDate" scope="col">Created Date</th>
										</tr>
									</thead>
									<tbody>
											<c:forEach items="${contents}" var="content">
												<tr class="datarow">
													<th scope="row">${content.getId()}</th>
													<td>${content.getTitle()}</td>
													<td>
														<p>${content.getBrief()}</p>
													</td>
													<td>
														<p>${content.getCreatedDate()}</p>
													</td>
												</tr>
											</c:forEach>
										</tbody>
								</table>
							</div>
						</div>

					</div>
					<div>
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#">Previous</a></li>
								<li class="page-item"><a class="page-link paging-number"
									href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		// click event on button
		$("#view-content")
				.click(
						function() {
							$(".page-container").text("Loading....")

							// storing url and time
							let delay = 1000;
							let url = "http://localhost:8080/Assignment_1_JSP/View/ViewContent.jsp";
							setTimeout(function() {
								location = url;
							}, 1000)
						})

		$("#form-content")
				.click(
						function() {
							$(".page-container").text("Loading....")

							// storing url and time
							let delay = 1000;
							let url = "http://localhost:8080/Assignment_1_JSP/View/addContent.jsp";
							setTimeout(function() {
								location = url;
							}, 1000)
						})

		$("#user-profile")
				.click(
						function() {
							$(".page-container").text("Loading....")

							// storing url and time
							let delay = 1000;
							let url = "http://localhost:8080/Assignment_1_JSP/View/editProfile.jsp";
							setTimeout(function() {
								location = url;
							}, 1000)
						})
		$("#log-out").click(function() {
			$(".page-container").text("Loading....")

			// storing url and time
			let delay = 1000;
			let url = "http://localhost:8080/Assignment_1_JSP/View/Login.jsp";
			setTimeout(function() {
				location = url;
			}, 1000)
		})
	</script>
	<!-- Core theme JS-->
	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
</body>

</html>
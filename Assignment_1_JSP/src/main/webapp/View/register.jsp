<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<meta name="viewport"
	content="width=devicewidth, initialscale=1, shrinktofit=no">
<title>Register User</title>
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">
</head>

<body>
	<!-- //login box -->
	<div class="loginbox">
		<div class="request">Register</div>
		<div>
			<div id="error" style="padding: 5px;"></div>
			<form id="formAdd" action="#" onsubmit="validateRegister()"
				method="post" name="frm-register">
				<table id="tbl-register">
					<p id="error"></p>
					<tr>
						<td class="input"><input class="inputArea" type="text"
							name="username" id="username" placeholder="User name"
							minlength="3" maxlength="30" required />
							<div id="username-error" class="error"></div></td>

					</tr>
					<tr>
						<td class="input"><input class="inputArea" type="email"
							name="email" id="email" placeholder="E-mail" minlength="5"
							maxlength="50" required />
							<div id="email-error" class="error"></div></td>
					</tr>
					<tr>
						<td class="input"><input class="inputArea" type="password"
							name="password" id="password" placeholder="Password"
							minlength="8" maxlength="30" required />
							<div id="password-error" class="error"></div></td>
					</tr>
					<tr>
						<td class="input"><input class="inputArea" type="password"
							name="repassword" id="repassword" placeholder="Re Password"
							required />
							<div id="repassword-error" class="error"></div></td>
					</tr>
					<tr>
						<td class="input">
							<button class="submit" type="button" onclick="validateRegister()"
								name="register">Register</button>
						</td>

					</tr>
					<tr>
						<td class="link"><a href="LoginController">Click here to Login</a></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/login.js"></script>
</body>
</html>
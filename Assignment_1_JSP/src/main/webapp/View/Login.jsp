<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<meta name="viewport"
	content="width=devicewidth, initialscale=1, shrinktofit=no">
<title>Login</title>
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">
</head>

<body>
	<!-- //login box -->
	<div class="loginbox">
		<div class="request">Please Sign In</div>
		<div>
			<div id="error" style="padding: 5px;"></div>
			<form id="formAdd" action="#" onsubmit="validateLogin()"
				method="post" name="frm-register">
				<table>
					<tr>
						<td class="input"><input class="inputArea" type="email"
							name="email" id="email" placeholder="E-mail" minlength="5"
							maxlength="50" required /></td>
					</tr>
					<tr>
						<td class="input"><input class="inputArea" type="password"
							name="password" id="password" placeholder="Password"
							minlength="8" maxlength="30" required /></td>
					</tr>
					<tr>
						<td class="checkbox"><input type="checkbox" name="rememberMe"
							id="rememberMe">Remember Me</input></td>
					</tr>
					<tr>
						<td class="input"><button class="submit" type="button"
								onclick="validateLogin()" name="Login">Login</button></td>
					</tr>
					<tr>
						<td class="link"><a href="RegisterController">Click here to
								Register</a></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/login.js"></script>
</body>
</html>
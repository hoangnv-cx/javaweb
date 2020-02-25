<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dang nhap</title>

</head>
<style>
</style>
<body>
	<div class="container">

		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Admin Login</h2>
					<p>Please enter your user and password</p>
				</div>
				<form action="<c:url value='/dang-nhap'/>" id="formLogin" method="post">

					<div class="form-group">


						<input type="email" class="form-control" id="userName" name="userName"
							placeholder="Tên đăng nhập">

					</div>

					<div class="form-group">

						<input type="password" class="form-control" id="password" name="password"
							 placeholder="Mật khẩu">

					</div>
					<input type="hidden" value="login" id="sortBy" name="action"/>
					<button type="submit" class="btn btn-primary">Đăng Nhập</button>

				</form>
			</div>

		</div>
	</div>
</body>
</html>
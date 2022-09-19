<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Login Page</title>
</head>
<body>


	<div class=" bg-light"
		style="align: center; margin: auto; display: flex; height: 600px;">
		<div class="" style="align: center; margin: auto;">

			<form action="/login" method="GET">

				<div class=" container-fluid sm px-2 input-group-sm mb-2"
					style="display: flex;">
					<span class=" px-2"
						style="width: 150px; padding-right: 1rem; color: black;">UserName</span>
					<input type="text" class="form-control px-2" name="username"
						style="width: 170px; margin-left: 1rem"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm">
				</div>
				<div class=" container-fluid sm px-2 input-group-sm mb-2"
					style="display: flex;">
					<span class=" px-2"
						style="width: 150px; padding-right: 1rem; color: black;">Password</span>
					<input type="password" class="form-control px-2" name="password"
						style="width: 170px; margin-left: 1rem"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm">
				</div>

				<button type="submit" class="btn btn-outline-danger"
					style="height: 30px; font-size: 14px; margin-left: 7rem; margin-right: 2rem; width: 100px">Login</button>
			</form>
		</div>
	</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Doctor Availability Form Flat Responsive Widget Template
	:: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Doctor Availability Form Bootstrap Responsive Templates, Iphone Compatible Templates, Smartphone Compatible Templates, Ipad Compatible Templates, Flat Responsive Templates" />
<link rel="stylesheet" href="css/jquery-ui.css" type="text/css"
	media="all">
<link href="css/wickedpicker.css" rel="stylesheet" type='text/css'
	media="all" />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700"
	rel="stylesheet">
<!--//webfonts-->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700"
	rel="stylesheet">
<link rel="stylesheet" href="css/ionicons.min.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.css">
<link rel="stylesheet" href="css/style.css">

</head>
<body style="background-image: url('bg1.jpg');">
	<div style="width: 10%"></div>
	<header id="home" class="gradient-violat">
		<nav class="navbar navbar-default navbar-fixed-top" style="background-color: black;">
			<div class="container" style="height: 20%; background-color: black;">
				<!--change  -->
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="#"><span
						class="logo-wraper logo-white"
						style="font-size: 30px; color: white;">
							<!--change  --> 
					</span></a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1" style="height: 20%">
					<ul class="nav navbar-nav  navbar-right">
						<li><a href="index.html">Home <span class="sr-only">(current)</span></a></li>
						<li class="active"><a style="color: white;"
							href="LoginPage.jsp">Login Page</a></li>
						<!--change  -->
						<li><a href="RegisterPage.jsp">Register Page</a></li>
						<li><a href="PatientRegisterPage.jsp">Patient Register</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
				<hr class="navbar-divider">
			</div>
			<!-- /.container-fluid -->
		</nav>
		<div class="w3lsfooteragileits" style="height: 50%; padding-top: 4%">
			<h1>Health Care Privacy Approach using Blockchain Technology</h1>
		</div>
	</header>
	<div class="containerw3layouts-agileits">
		<div class="w3layoutscontactagileits">

			<div id="wrapper">
				<form action="Login" method="post">
					<div id="login" class="animate w3layouts agileits form">

						<div class="ferry ferry-from">
							<label>Select Role:</label> <select name="roll">
								<option selected="selected">Select Role</option>
								<option value="Patient">Patient</option>
								<option value="Admin">Hospital</option>
								<option value="Insurance">Insurance</option>
							</select>
						</div>
						<div class="ferry ferry-from">
							<label>Email-ID:</label> <input type="email"
								style="width: 100%; height: 40px" name="email"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="required">
						</div>
						&nbsp;
						<div class="ferry ferry-from">
							<label>Password:</label><input type="password"
								style="width: 100%; height: 40px" name="password" required="required">
						</div>
						<br />

						<div class="wthreesubmitaits">
							<input type="submit" name="submit" value="Login">
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>
	<div style="height: 20%"></div>
	<div style="height: 20%"></div>
	<div class="w3lsfooteragileits" style="height: 50%; padding-top: 50%">

	</div>
	<!-- Necessary-JavaScript-Files-&-Links -->
	<!-- Date-Picker-JavaScript -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/wickedpicker.js"></script>

	<script type="text/javascript">
		$(function() {
			$("#datepicker,#datepicker1,#datepicker2").datepicker();
		});
	</script>

	<script type="text/javascript">
		$('.timepicker').wickedpicker({
			twentyFour : false
		});
	</script>

	<!-- //Date-Picker-JavaScript -->
	<!-- //Necessary-JavaScript-Files-&-Links -->


</body>
</html>
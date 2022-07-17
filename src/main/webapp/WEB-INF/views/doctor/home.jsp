<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Medical Center - Home</title>
<!----======== CSS ======== -->
<link rel="icon" href="<c:url value ="/resources/img/icono.png"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/styles.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap.min.css"/>">
<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
</head>
<body>
	<nav class="sidebar">
		<header>
			<div class="image-text">
				<div class="text logo-text">
					<span class="name">MEDICAL CENTER</span>
				</div>
			</div>

			<i class='bx bx-chevron-right toggle'></i>
		</header>
		<hr>
		<div class="menu-bar">
			<div class="menu">

				<ul class="menu-links">
					<li class="nav-link"><a href="/sistema/home"> <i
							class='bx bx-home-alt icon'></i> <span class="text nav-text">Home</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/appointments"> <i
							class='bx bx-food-menu icon'></i> <span class="text nav-text">Citas</span>
					</a></li>
					<li class="nav-link"><a href="/sistema/schedules"> <i
							class='bx bx-calendar icon'></i> <span class="text nav-text">Horarios</span>
					</a></li>
				</ul>
			</div>

			<div class="bottom-content">
				<li class=""><a href="/sistema/logout"> <i
						class='bx bx-log-out icon'></i><span class="text nav-text">Logout</span>
				</a></li>
			</div>
		</div>

	</nav>

	<section class="home">

		<div class='container'>

			<h4 class='mt-4 text-welcome'>BIENVENIDO DE NUEVO DOCTOR</h4>
			<hr>
			<div class='row jutify-content-center text-center'></div>
		</div>
	</section>


	<script src='<c:url value="/resources/js/script.js" />'></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Medical Center - Especialidades</title>
<!----======== CSS ======== -->
<link rel="icon" href="<c:url value ="/resources/img/icono.png"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/sweetalert2.min.css" />">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/styles.css"/>">
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

<!----===== Javascript ===== -->
<script type="text/javascript"
	src="<c:url value="/resources/js/sweetalert2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/scripts.js"/>"></script>
<script src='<c:url value="/resources/js/script.js" />'></script>
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

					<li class="nav-link"><a href="/sistema/doctors"> <i
							class='bx bx-user icon'></i> <span class="text nav-text">Doctores</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/schedules"> <i
							class='bx bx-calendar icon'></i> <span class="text nav-text">Horarios</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/specialtys"> <i
							class='bx bx-pie-chart-alt icon'></i> <span class="text nav-text">Especialidades</span>
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

			<h4 class='mt-4 text-welcome'>ESPECIALIDADES</h4>
			<hr>
			<button class='btn btn-primary' data-bs-toggle="modal"
				data-bs-target="#exampleModal">Agregar</button>
			<div class='row jutify-content-center text-center'></div>
			<%
			String add = request.getParameter("add");
			%>
			<c:set var="va" value="<%=add%>" />
			<c:if test="${va == 'ok'}">
				<script type="text/javascript">
					alertSuccessfull();
				</script>
			</c:if>
			<c:if test="${va == 'error'}">
				<script type="text/javascript">
					alertError();
				</script>
			</c:if>
			<br>
			<div class="card mb-4">
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th class='text-center'>ID</th>
								<th class='text-center'>Tipo</th>
								<th class='text-center'>Estado</th>
								<th class='text-center'>Acciones</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>ID</th>
								<th>Tipo</th>
								<th>Estado</th>
								<th>Acciones</th>
							</tr>
						</tfoot>

						<tbody>
							<c:forEach items="${specialtys}" var="sp">
								<c:url var="deleteSpecialty" value="/deleteSpecialty">
									<c:param name="specialtyId" value="${sp.id}" />
								</c:url>
								<tr>
									<td class='text-center'>${sp.id}</td>
									<td class='text-center'>${sp.type }</td>
									<td class='text-center'>${sp.status }</td>
									<td class='text-center'><a class='bx bx-trash bx-sm'
										href="${deleteSpecialty}"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">REGISTRAR NUEVA
						ESPECIALIDAD</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form:form action='addEspecialty' modelAttribute="especialty"
						method="post">
						<input type="text" name='type'
							placeholder='Nombre de la especialidad' class='form-control'
							required>
						<br>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Guardar</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script src='<c:url value="/resources/js/bootstrap.bundle.min.js" />'></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value = "/resources/js/datatables-simple-demo.js"/>"></script>
</body>
</html>
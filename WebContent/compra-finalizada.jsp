<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Final</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav"> 
					<li class="nav-item"> 
						<a class="nav-link" href="contexto-vendedor.jsp">Home</a>
					</li>
				</ul>
			</div>
				<a class="btn btn-outline-primary my-2 my-sm-0" href="index.html">Sair</a>
		</nav>
		<div class="col-sm-6">
		<h1>Compra finalizada</h1>
		<table class="table table-bordered">
			<tr> 
				<th scope="col">Valor Final</th>
			</tr>
			<tr>
				<td>R$ <c:out value="${venda}"></c:out></td>
			</tr>
		</table>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Carrinho</title>
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
					<li class="nav-item"> 
						<a class="nav-link" href="ListarProdutosVenda">Iniciar Venda</a>
					</li>
				</ul>
			</div>
				<a class="btn btn-outline-primary my-2 my-sm-0" href="index.html">Sair</a>
		</nav>
		<form action="FinalizaCompra" method="POST"> 
			<div class="form-group col-sm-6">
				<span>Nome do Produto : </span> 
				<span class="font-weight-bold"><c:out value="${produto.nome}"></c:out></span>
			</div>
			<div class="form-group col-sm-3">
				<label>Quantidade que deseja comprar: </label>
				<input class="form-control" type="text" value="<c:out value="${produto.qtnEstoque}"></c:out>" name="qtnProdutos">
			</div>
				<input hidden="true" type="text" value="<c:out value="${produto.id}"></c:out>" name="id" >
				<input hidden="true" type="text" value="<c:out value="${produto.preco}"></c:out>" name="preco" >
			<div class="d-flex">
		          <div class="p-3">
		               <button type="submit" class="btn btn-primary">Submit</button>
		          </div>
		     </div>
		</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import="controllers.ControllerProduto" %>
 <jsp:useBean id="controller" class="controllers.ControllerProduto"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista de Produto</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	</head>
		<body>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"> 
                  		<a class="nav-link" href="contexto-gerente.jsp">Home</a>
               		</li> 
					<li class="nav-item"> 
						<a class="nav-link" href="cadastro-produtos.html">Cadastrar Produtos</a>
					</li>
					<li class="nav-item"> 
						<a class="nav-link" href="ListarProdutos">Listar Produtos</a>
					</li>
				</ul>
			</div>
			<a class="btn btn-outline-primary my-2 my-sm-0" href="index.html">Sair</a>
		</nav>
			<%ControllerProduto p = new ControllerProduto();  %>
			<table class="table table-bordered" >
			  <tr>
			    <th scope="col">Nome: </th>
			    <th scope="col">Preço: </th>
			    <th scope="col">Quantidade de Estoque: </th>
			    <th scope="col">Acao</th>
			  </tr>
			  <c:forEach items="${produtos}" var="produto">
			  <tr>
			    <td><c:out value="${produto.nome}"></c:out></td>
			    <td><c:out value="${produto.preco}"></c:out></td>
			    <td><c:out value="${produto.qtnEstoque}"></c:out></td>
			    <td><a href="RemoverProduto?id=${produto.id}" class="btn btn-primary btn-sm">Remover</a>
			    	<a href="AtualizarProduto?id=${produto.id}" class="btn btn-primary btn-sm">Editar</a>
			    </td>
			  </tr>
			  </c:forEach>
			</table>
		</body>
</html>
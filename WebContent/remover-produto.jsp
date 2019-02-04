 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
         <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
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
<form action="RemoverProduto" method="POST"> 
	<label>Nome: </label>
	<p><c:out value="${produto.nome}"></c:out></p>
	<label>Quantidade: </label>
	<input type="text" value="<c:out value="${produto.qtnEstoque}"></c:out>" name="qtnProdutos">
	<input hidden="true" type="text" value="<c:out value="${produto.id}"></c:out>" name="id">
	<input type="submit">
</form>

</body>

</html>
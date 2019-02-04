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
<form action="FinalizaCompra" method="POST"> 
<label>Nome: </label>
<p><c:out value="${produto.nome}"></c:out></p>

<label>Quantidade: </label>
	<input type="text" value="<c:out value="${produto.qtnEstoque}"></c:out>" name="qtnProdutos">

	<input hidden="true" type="text" value="<c:out value="${produto.id}"></c:out>" name="id" >
	
	<input hidden="true" type="text" value="<c:out value="${produto.preco}"></c:out>" name="preco" >
	<br/>
	<input type="submit">

</form>
</body>
</html>
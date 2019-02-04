<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <title>Insert title here</title>
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
      <form action="AtualizarProduto" method="POST">
         <div class="form-group col-sm-3">
            <label>Nome do Produto: </label>
            <input  class="form-control" type="text"  value="<c:out value="${produto.nome}"></c:out>" name="nome">
         </div>
         <div class="form-group col-sm-3">
            <label>Valor do Produto: </label>
            <input class="form-control "  type="text"  value="<c:out value="${produto.preco}"></c:out>" name="valor">
         </div>
         <div class="form-group col-sm-3">
            <label> Quantidade em Estoque: </label>
            <input class="form-control " type="text"  value="<c:out value="${produto.qtnEstoque}"></c:out>" name="estoque">
         </div>
         <div class="form-group col-sm-3">
            <label hidden="true"> Id: </label>
            <input hidden="true" class="form-control" type="text"  value="<c:out value="${produto.id}"></c:out>" name="id">
         </div>
         <div class="d-flex">
            <div class="p-3">
               <button type="submit" class="btn btn-primary">Submit</button>
            </div>
         </div>
      </form>
   </body>
</html>
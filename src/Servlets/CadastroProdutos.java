package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controllers.ControllerProduto;
import models.Produto;

@WebServlet("/CadastroProdutos")
public class CadastroProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControllerProduto controller;

	public CadastroProdutos() {
		super();
		controller = new ControllerProduto();
	}
	/**Captura os dados do cadastro e chama o metodo add e 
	 * renderiza a pagina de listar*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Produto p = new Produto();

		p.setNome(request.getParameter("nome"));
		p.setPreco(Double.parseDouble(request.getParameter("valor")));
		p.setQtnEstoque(Integer.parseInt(request.getParameter("estoque")));
		controller.addProduto(p);
		try {
			javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/listar-produtos.jsp");
			request.setAttribute("produtos", controller.findAll());
			view.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}

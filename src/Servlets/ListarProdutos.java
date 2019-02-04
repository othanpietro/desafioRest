package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ControllerProduto;


@WebServlet("/ListarProdutos")
public class ListarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControllerProduto controller;
    public ListarProdutos() {
        super();
        controller = new ControllerProduto();
    }
    /**renderiza a tela de listar produto*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/listar-produtos.jsp");
			request.setAttribute("produtos", controller.findAll());
			view.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


}

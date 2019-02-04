package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ControllerProduto;

@WebServlet("/ListarProdutosVenda")
public class ListarProdutosVenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControllerProduto controller;
    public ListarProdutosVenda() {
        super();
        controller = new ControllerProduto();
    }
    /**Renderiza a tela 
     * de Listar produutos a vender*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/listar-produtos-venda.jsp");
			request.setAttribute("produtos", controller.findAll());
			view.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


}

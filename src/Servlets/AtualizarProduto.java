package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ControllerProduto;
import models.Produto;

@WebServlet("/AtualizarProduto")
public class AtualizarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public AtualizarProduto() {
        super();
    }
	/** recebe o id via get e renderiza a pagina de de atualizar produto*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControllerProduto controller = new ControllerProduto();
		try {
			javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/atualizar-produto.jsp");
			request.setAttribute("produto", controller.findById(Integer.parseInt(request.getParameter("id"))));
			view.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**captura os paramentros para editar o Produto 
	 * chama o metodo que edita e renderiza 
	 * a view de lista*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControllerProduto controller = new ControllerProduto();
		Produto p = new Produto();
		p.setNome(request.getParameter("nome"));
		p.setPreco(Double.parseDouble(request.getParameter("valor")));
		p.setQtnEstoque(Integer.parseInt(request.getParameter("estoque")));
		p.setId(Integer.parseInt(request.getParameter("id")));
		controller.updateProduto(p);
		try {
			javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/listar-produtos.jsp");
			request.setAttribute("produtos", controller.findAll());
			view.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}

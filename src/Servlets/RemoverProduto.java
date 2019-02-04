package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controllers.ControllerProduto;
@WebServlet("/RemoverProduto")
public class RemoverProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoverProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControllerProduto controller = new ControllerProduto();
		try {
			javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/remover-produto.jsp");
			request.setAttribute("produto", controller.findById(Integer.parseInt(request.getParameter("id"))));
			view.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControllerProduto controller = new ControllerProduto();
		
		if(controller.remove(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("qtnProdutos")))) {
			try {
				javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/listar-produtos.jsp");
				request.setAttribute("produtos", controller.findAll());
				view.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}

}

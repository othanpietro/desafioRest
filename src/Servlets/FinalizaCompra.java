package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ControllerProduto;
import controllers.ControllerVendas;

@WebServlet("/FinalizaCompra")
public class FinalizaCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FinalizaCompra() {
        super();
       
    }
    /**recebe o id por via get e renderiza 
     * a tela com o produto a 
     * ser desejado a compra*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControllerProduto controller = new ControllerProduto();
		try {
			javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/finaliza-compra.jsp");
			request.setAttribute("produto", controller.findById(Integer.parseInt(request.getParameter("id"))));
			view.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	/**pesquisa no banco se existe algum produto
	 *  se sim remove a quantidade de
	 *   desejada e retorna o valor final da compra*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControllerProduto controller = new ControllerProduto();
		ControllerVendas vendas = new ControllerVendas();
		if(controller.findById(Integer.parseInt(request.getParameter("id"))) != null) {
		controller.remove(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("qtnProdutos")));
		}
		try {
			javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/compra-finalizada.jsp");
			request.setAttribute("venda", vendas.realizaVendas(Double.parseDouble(request.getParameter("preco")),Integer.parseInt(request.getParameter("qtnProdutos"))));
			view.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}

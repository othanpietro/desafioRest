package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controllers.ControllerFuncionario;
import models.Funcionario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   try {
				javax.servlet.RequestDispatcher view = req.getRequestDispatcher("/index.html");
				view.forward(req, resp);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
    	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    /** captura os paramentos da requisição e chama 
     * o metodo que verifica o funcionario e retorna se for gerente 
     * ou vendedor se for vendedor abre o contexto vendedor
     * se for gerente abre o contexto gerente*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Funcionario f = new Funcionario();
		ControllerFuncionario CF = new ControllerFuncionario();
		f.setLogin(request.getParameter("login"));
		f.setSenha(request.getParameter("senha"));
		
		if(CF.verificaFuncionario(f)) {
			if(f.getCargo().equals("gerente")) {
				System.out.println("gerente");
				try {
					javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/contexto-gerente.jsp");
					view.forward(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			else if(f.getCargo().equals("vendedor")){
				System.out.println("vendedor");
				try {
					javax.servlet.RequestDispatcher view = request.getRequestDispatcher("/contexto-vendedor.jsp");
					view.forward(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
		
		doGet(request, response);
	}

}

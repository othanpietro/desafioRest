package controllers;

import java.util.ArrayList;
import java.util.List;

import dao.FuncionarioDao;
import models.Funcionario;

public class ControllerFuncionario {
	/** recebe um objeto funcionario e 
	 * pesquisa todos no banco e compara se tem um igual
	 * se existir retorna true
	 * */
	public boolean verificaFuncionario(Funcionario f) {
		FuncionarioDao dao = new FuncionarioDao();
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		listaFuncionarios =  dao.findAll();
		for(Funcionario funcionario : listaFuncionarios) {
			if(f.login(funcionario.getLogin(), funcionario.getSenha())) {
				f.setCargo(funcionario.getCargo());
				return true;
			}
			}
		return false;
	}
}

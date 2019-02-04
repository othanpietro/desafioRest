package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexao.ConnectionFactory;
import models.Funcionario;

public class FuncionarioDao {
	private Connection conn;
	
	public FuncionarioDao() {
		conn = new ConnectionFactory().getConnection();
	}
	public List<Funcionario> findAll(){
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM tb_funcionarios";
		try {
			PreparedStatement sttm = conn.prepareStatement(sql);
			ResultSet resultado = sttm.executeQuery();
			
			while(resultado.next()){
				Funcionario f = new Funcionario();
				
				f.setCargo(resultado.getString("cargo"));
				f.setLogin(resultado.getString("login"));			
				f.setSenha(resultado.getString("senha"));
				
				listaFuncionarios.add(f);
			}
			sttm.close();
					
			
		} 	catch (SQLException e) {
			e.printStackTrace();
		}
		return listaFuncionarios;
	}
	
}

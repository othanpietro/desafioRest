package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import models.Produto;

public class ProdutoDao {
	private Connection conn;

	public ProdutoDao() {
		conn = new ConnectionFactory().getConnection();
	}
	/**recebe como parametro um objeto do tipo Produto 
	 *  1 compara se existe algum produto com o mesmo nome se sim adiciona 
	 *  a qantidade na quantidade em estoque 
	 *  se não adiciona mais uma tupla no banco */
	public boolean add(Produto p) {
		Produto produto = new Produto();
		produto = findByName(p.getNome());
		if(produto.getNome()!=null) {
			String sql = "UPDATE tb_produto SET qtnEstoque = ? WHERE id = ?";
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				produto.setQtnEstoque(produto.getQtnEstoque()+ p.getQtnEstoque() );
				
				stmt.setInt(1, produto.getQtnEstoque());
				stmt.setInt(2, produto.getId());
				
				stmt.execute();
				stmt.close();
				return true;
				
			} 	catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		
		String sql = "INSERT INTO tb_produto (preco, nome, qtnEstoque) values (?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			System.out.println(p.getPreco());
			System.out.println(p.getNome());
			System.out.println(p.getQtnEstoque());
			stmt.setDouble(1, p.getPreco());
			stmt.setString(2, p.getNome());			
			stmt.setInt(3, p.getQtnEstoque());
			
			stmt.execute();
			conn.commit();
			stmt.close();
			return true;
					
		} 	catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return false;
		}
		}
	
	public boolean update(Produto p) {
		String sql = "UPDATE tb_produto SET preco = ?, nome = ?, qtnEstoque = ? WHERE id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, p.getPreco());
			stmt.setString(2, p.getNome());			
			stmt.setInt(3, p.getQtnEstoque());
			stmt.setInt(4, p.getId());
			stmt.execute();
			stmt.close();
			return true;
			
		} 	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**Retorna todos os elementos do banco*/
	public List<Produto> findAll(){
		List<Produto> listaProdutos = new ArrayList<Produto>();
		String sql = "SELECT * FROM tb_produto";
		try {
			PreparedStatement sttm = conn.prepareStatement(sql);
			ResultSet resultado = sttm.executeQuery();
			
			while(resultado.next()){
				Produto produto = new Produto();
				produto.setId(resultado.getInt("id"));
				produto.setPreco(resultado.getDouble("preco"));
				produto.setNome(resultado.getString("nome"));				
				produto.setQtnEstoque(resultado.getInt("qtnEstoque"));
				
				listaProdutos.add(produto);
			}
			sttm.close();
					
			
		} 	catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProdutos;
	}
	/**Remove a quantidade da venda no da quantidade em estoque*/
	public boolean remove(int id, int qtn) {
		Produto p = new Produto();
		p = findById(id);
		
		String sql = "UPDATE tb_produto SET qtnEstoque = ? WHERE id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			p.setQtnEstoque(p.getQtnEstoque()-qtn);
			
			stmt.setInt(1, p.getQtnEstoque());
			stmt.setInt(2, p.getId());
			
			stmt.execute();
			stmt.close();
			return true;
			
		} 	catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Produto findById(int  id) {
		Produto p = new Produto();
		String sql = "SELECT * FROM tb_produto where id = ?";
		 
		try {
			
			PreparedStatement smtt = conn.prepareStatement(sql);
			smtt.setInt(1,id);
			ResultSet resultado = smtt.executeQuery();
			
			while(resultado.next()){
			p.setId(resultado.getInt("id"));
			p.setPreco(resultado.getDouble("preco"));
			p.setNome(resultado.getString("nome"));				
			p.setQtnEstoque(resultado.getInt("qtnEstoque"));
			}
			smtt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	public Produto findByName(String nome) {
		Produto p = new Produto();
		String sql = "SELECT * FROM tb_produto WHERE nome = ?";
		 
		try {
			
			PreparedStatement smtt = conn.prepareStatement(sql);
			smtt.setString(1,nome);
			ResultSet resultado = smtt.executeQuery();
			
			while(resultado.next()){
			p.setId(resultado.getInt("id"));
			p.setPreco(resultado.getDouble("preco"));
			p.setNome(resultado.getString("nome"));				
			p.setQtnEstoque(resultado.getInt("qtnEstoque"));
			}
			smtt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
		
	}
	
}

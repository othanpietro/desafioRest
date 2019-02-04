package controllers;

import models.Produto;

import java.util.ArrayList;
import java.util.List;

import dao.ProdutoDao;

public class ControllerProduto {
	ProdutoDao dao;
	/**Recebe um objeto do tipo produto e
	 * adiciona no banco
	 * */
	public boolean addProduto(Produto p) {
		dao = new ProdutoDao();
		List<Produto> produtos = new ArrayList<Produto>();
		produtos = dao.findAll();
		if(p!=null) {
			if(!produtos.contains(p)){
				return dao.add(p);
			}
		
		}
		return false;
		}
	/**Recebe um objeto do tipo produto e
	 * atualiza no banco
	 * */
	public boolean updateProduto(Produto p) {
		dao = new ProdutoDao();
		return dao.update(p);
	}
	/**Retorna todos os produtos do banco
	 * */
	public List<Produto> findAll() {
		dao = new ProdutoDao();
		return dao.findAll();
	}
	/**Recebe um id e retorna um objeto produto do 
	 * banco
	 * */
	public Produto findById(int id) {
		dao = new ProdutoDao();
		return dao.findById(id);
	}
	/** recebe como paramentro o id e quantidade que deseja remover 
	 * */
	public boolean remove(int id, int qtn) {
		dao = new ProdutoDao();
		return dao.remove(id, qtn);
	}
}

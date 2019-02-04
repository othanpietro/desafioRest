package models;

public class Funcionario implements IFazerLogin {
	private String login;
	private String senha;
	private String cargo;
	public Funcionario(String login, String senha, String cargo) {
		super();
		this.login = login;
		this.senha = senha;
		this.cargo= cargo;
	}
	public Funcionario() {}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Override
	/**Verifica se os paramentros login e 
	 * senha são igual o do funcionario 
	 * em tempo de execução*/
	public boolean login(String login, String senha) {
		return (this.login.equals(login) && this.senha.equals(senha));
	}
}

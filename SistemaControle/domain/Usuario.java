package SistemaControle.domain;

import SistemaControle.domain.Interface.*;

public class Usuario implements iUsuario{
	
	//private String Nome;
	private String userName;
	private String senha;
	
	public void set_userName(String userName) {
		this.userName = userName;
	}
	
	public String get_userNamer() {
		return this.userName;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}

}

package SistemaControle.controller;

import java.util.Scanner;
import SistemaControle.domain.Usuario;

public class UsuarioController {
	
	public boolean login(Usuario user){
		boolean logado = false;
		Scanner scan = new Scanner(System.in);
		String userName;
		String senha;
		while (logado == false) {
			System.out.println("Nome de usuário:\n");
		    userName = scan.nextLine();
		    System.out.println("Senha:\n");
		    senha = scan.nextLine();
		    if (!(user.get_userNamer().equals(userName)) || !(user.getSenha().equals(senha))) {
		    	System.out.println("Nome de usuário ou senha inválidos.\n");
		    }
		    else if ((user.get_userNamer().equals(userName)) && (user.getSenha().equals(senha))) {
		    	logado = true;
		    }
		}
		return logado;
	}
	
	public void altSenha(Usuario user) {
		Scanner scan = new Scanner(System.in);
		String senhaAntiga;
		String senhaNova;
		System.out.println("Senha antiga:\n");
		senhaAntiga = scan.nextLine();
		if (!user.getSenha().equals(senhaAntiga)) {
			System.out.println("Senha incorreta.\n");
			return;
		}
		else if (user.getSenha().equals(senhaAntiga)) {
			System.out.println("Senha nova:\n");
			senhaNova = scan.nextLine();
			user.setSenha(senhaNova);
		}
	}


}

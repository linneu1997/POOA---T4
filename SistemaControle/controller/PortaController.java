package SistemaControle.controller;

import java.util.Scanner;

import SistemaControle.domain.Porta;
import SistemaControle.domain.Usuario;
import SistemaControle.service.Interface.IPortaService;

public class PortaController {
	
	private IPortaService service;
	
	public PortaController(IPortaService service) {
		this.service = service;
	}
	
	public boolean altEstado(Porta porta, Usuario user, UsuarioController uControl) {
		if (uControl.login(user) == true) {
			service.altEstado(porta);
			return true;
		}
		return false;
	}
	
	public Porta addPorta() {
		Porta porta = new Porta();
		Scanner scan = new Scanner(System.in);
		String portaName;
		System.out.println("Escolha o nome da porta a ser adicionada:\n");
		portaName = scan.nextLine();
		porta.setNome(portaName);
		return porta;
	}
}

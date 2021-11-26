package SistemaControle.controller;

import java.util.Scanner;
import SistemaControle.domain.Usuario;
import SistemaControle.domain.Interface.iLampada;
import SistemaControle.domain.Interface.iVentilador;
import SistemaControle.domain.Interruptor.Lampada;
import SistemaControle.service.Interface.ILampadaService;

public class LampadaController {
	
	private ILampadaService service;
	
	public LampadaController(ILampadaService service){
		this.service = service;
	}
	
	public boolean altEstado(iLampada lampada, Usuario user, UsuarioController uControl) {
		if (uControl.login(user) == true) {
			this.service.altEstado(lampada.getNome());
			return true;
		}
		return false;
	}
	
	public Lampada addLampada() {
		Lampada lampada = new Lampada();
		Scanner scan = new Scanner(System.in);
		String lampadaName;
		System.out.println("Escolha o nome da lampada a ser adicionada:\n");
		lampadaName = scan.nextLine();
		lampada.setNome(lampadaName);
		return lampada;
	}
	
	public void altIntensidade(iLampada lampada) {
		Scanner scan = new Scanner(System.in);
		int lampadaInt;
		System.out.println("Qual a intensidade de iluminação da lâmpada? (0-100)\n");
		lampadaInt = scan.nextInt();
		lampada.setIntensidade(lampadaInt);
	}
	
}

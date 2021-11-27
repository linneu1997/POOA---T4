package SistemaControle.controller;

import java.util.Scanner;

import SistemaControle.domain.Usuario;
import SistemaControle.domain.Interface.iUsuario;
import SistemaControle.domain.Interface.iVentilador;
import SistemaControle.domain.Interruptor.Ventilador;
import SistemaControle.service.Interface.IVentiladorService;


public class VentiladorController {
		
	private IVentiladorService service;
	
	public VentiladorController(IVentiladorService service){
		this.service = service;
	}
	
	public boolean altEstado(iVentilador ventilador, iUsuario user, UsuarioController uControl) {
		if (uControl.login(user) == true) {
			this.service.altEstado(ventilador.getNome());
			return true;
		}
		return false;
	}
		
	public Ventilador addVentilador() {
		Ventilador ventilador = new Ventilador();
		Scanner scan = new Scanner(System.in);
		String ventiladorName;
		System.out.println("Escolha o nome da ventilador a ser adicionada:\n");
		ventiladorName = scan.nextLine();
		ventilador.setNome(ventiladorName);
		return ventilador;
	}
	
	public void altIntensidade(iVentilador ventilador) {
		Scanner scan = new Scanner(System.in);
		String ventiladorInt;
		System.out.println("Qual a intensidade do ventilador? (Baixo/Médio/Alto)\n");
		ventiladorInt = scan.nextLine();
		ventilador.setIntensidade(ventiladorInt);
	}
		
}

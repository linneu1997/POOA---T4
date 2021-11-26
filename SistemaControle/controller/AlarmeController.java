package SistemaControle.controller;

import java.util.Scanner;
import SistemaControle.domain.*;
import SistemaControle.service.Interface.IAlarmeService;

public class AlarmeController {
	
	private IAlarmeService service;
	
	public AlarmeController(IAlarmeService service) {
		this.service = service;
	}
	
	public boolean altEstado(Alarme alarme, Usuario user, UsuarioController uControl) {
		if (uControl.login(user) == true) {
			this.service.altEstado(alarme);
			return true;
		}
		return false;
	}
	
	public Alarme addAlarme() {
		Alarme alarme = new Alarme();
		Scanner scan = new Scanner(System.in);
		String alarmeName;
		System.out.println("Escolha o nome do alarme a ser adicionada:\n");
		alarmeName = scan.nextLine();
		alarme.setNome(alarmeName);
		return alarme;
	}

}

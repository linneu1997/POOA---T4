import java.util.Scanner;

import SistemaControle.domain.*;
import SistemaControle.domain.Interruptor.*;
import SistemaControle.service.*;
import SistemaControle.controller.*;

public class SistemaControle {
	 public static void main(String[] args)
	    {
	        Usuario user = new Usuario();
	        Scanner scan = new Scanner(System.in);
			String userName;
			String senha;
			
			System.out.println("Crie um nome de usuário:\n");
		    userName = scan.next();
		    System.out.println("Crie uma senha:\n");
		    senha = scan.next();
		    
		    user.set_userName(userName);
		    user.setSenha(senha);
		    
		    Sistema homeSystem = new Sistema();
		    PortaService pService = new PortaService();
		    AlarmeService aService = new AlarmeService();
		    LampadaService lService = new LampadaService(homeSystem);
		    VentiladorService vService = new VentiladorService(homeSystem);
		    PortaController pControl = new PortaController(pService);
		    AlarmeController aControl = new AlarmeController(aService);
		    LampadaController lControl = new LampadaController(lService);
		    VentiladorController vControl = new VentiladorController(vService);
		    UsuarioController uControl = new UsuarioController();
		     
		    Porta porta_entrada = new Porta();
		    porta_entrada.setNome("Entrada");
		    Alarme alarme_entrada = new Alarme();
		    alarme_entrada.setNome("Entrada");
		    Lampada lampada_corredor = new Lampada();
		    lampada_corredor.setNome("Corredor");
		    Ventilador ventilador_quarto = new Ventilador();
		    ventilador_quarto.setNome("Quarto");
		    
		    homeSystem.newAlarme(alarme_entrada);
		    homeSystem.newPorta(porta_entrada);
		    homeSystem.newLampada(lampada_corredor);
		    homeSystem.newVentilador(ventilador_quarto);
		    
	    	//homeSystem.newPorta(pControl.addPorta());
		    
		    int opcao = 20;
		    int operacao = 20;
		    String aux;
		    System.out.println("Escolha uma opção:\n");
		    System.out.println("1 - Porta   2 - Alarme   3 - Lampadas   4 - Ventilador   5 - Alterar Senha   0 - Sair\n");
		    opcao = scan.nextInt();
		    while (opcao != 0) {
		    	switch(opcao) {
		    	case 1:
				    System.out.println("Escolha uma operação:\n");
				    System.out.println("1 - Adicionar Porta   2 - Abrir/Fechar Porta   3 - Checar Porta   0 - Voltar\n");
				    operacao = scan.nextInt();
				    if (operacao == 1) {
				    	homeSystem.newPorta(pControl.addPorta());
				    }
				    if (operacao == 2) {
					    System.out.println("Escolha qual porta abrir/fechar:\n");
					    for (Porta p : homeSystem.getPorta()) {
					    	System.out.printf("%s  ", p.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Porta p : homeSystem.getPorta()) {
					    	if (p.getNome().equals(aux)) {
					    		pControl.altEstado(p, user, uControl);
					    	}
					    }
				    }
				    if (operacao == 3) {
					    System.out.println("Escolha qual porta checar:\n");
					    for (Porta p : homeSystem.getPorta()) {
					    	System.out.printf("%s  ", p.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Porta p : homeSystem.getPorta()) {
					    	if (p.getNome().equals(aux)) {
					    		pService.checarPorta(p);
					    	}
					    }
				    } 
		    		break;
		    		
		    	case 2:
		    		System.out.println("Escolha uma operação:\n");
				    System.out.println("1 - Adicionar Alarme   2 - Ligar/Desligar Alarme   3 - Checar Alarme   0 - Voltar\n");
				    operacao = scan.nextInt();
				    if (operacao == 1) {
				    	homeSystem.newAlarme(aControl.addAlarme());
				    }
				    if (operacao == 2) {
					    System.out.println("Escolha qual alarme ligar/desligar:\n");
					    for (Alarme a : homeSystem.getAlarme()) {
					    	System.out.printf("%s  ", a.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Alarme a : homeSystem.getAlarme()) {
					    	if (a.getNome().equals(aux)) {
					    		aControl.altEstado(a, user, uControl);
					    	}
					    }
				    }
				    if (operacao == 3) {
					    System.out.println("Escolha qual alarme checar:\n");
					    for (Alarme a : homeSystem.getAlarme()) {
					    	System.out.printf("%s  ", a.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Alarme a : homeSystem.getAlarme()) {
					    	if (a.getNome().equals(aux)) {
					    		aService.checarAlarme(a);
					    	}
					    }
				    } 
		    		break;
		    	case 3:
		    		System.out.println("Escolha uma operação:\n");
				    System.out.println("1 - Adicionar Lampada   2 - Acender/Apagar Lampada   3 - Alterar intensidade da luz   4 - Checar Lampada   0 - Voltar\n");
				    operacao = scan.nextInt();
				    if (operacao == 1) {
				    	homeSystem.newLampada(lControl.addLampada());
				    }
				    if (operacao == 2) {
				    	System.out.println("Escolha qual lampada acender/apagar:\n");
					    for (Lampada l : homeSystem.getLampada()) {
					    	System.out.printf("%s  ", l.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Lampada l : homeSystem.getLampada()) {
					    	if (l.getNome().equals(aux)) {
					    		lControl.altEstado(l, user, uControl);
					    	}
					    }
				    }
				    if (operacao == 4) {
					    System.out.println("Escolha qual lampada checar:\n");
					    for (Lampada l : homeSystem.getLampada()) {
					    	System.out.printf("%s  ", l.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Lampada l : homeSystem.getLampada()) {
					    	if (l.getNome().equals(aux)) {
					    		lService.checarInterruptor(l.getNome());
					    	}
					    }
				    }
				    if (operacao == 3) {
				    	System.out.println("Escolha a lampada que deseja alterar a iluminosidade:\n");
					    for (Lampada l : homeSystem.getLampada()) {
					    	System.out.printf("%s  ", l.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Lampada l : homeSystem.getLampada()) {
					    	if (l.getNome().equals(aux)) {
					    		lControl.altIntensidade(l);
					    	}
					    }
				    }
				    break;
		    	case 4:
		    		System.out.println("Escolha uma operação:\n");
				    System.out.println("1 - Adicionar Ventilador   2 - Ligar/Desligar Ventilador   3 - Alterar velocidade do ventilador   4 - Checar Ventilador   0 - Voltar\n");
				    operacao = scan.nextInt();
				    if (operacao == 1) {
				    	homeSystem.newVentilador(vControl.addVentilador());
				    }
				    if (operacao == 2) {
				    	System.out.println("Escolha qual ventilador ligar/desligar:\n");
					    for (Ventilador v : homeSystem.getVentilador()) {
					    	System.out.printf("%s  ", v.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Ventilador v : homeSystem.getVentilador()) {
					    	if (v.getNome().equals(aux)) {
					    		vControl.altEstado(v, user, uControl);
					    	}
					    }
				    }
				    if (operacao == 4) {
					    System.out.println("Escolha qual ventilador checar:\n");
					    for (Ventilador v : homeSystem.getVentilador()) {
					    	System.out.printf("%s  ", v.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Ventilador v : homeSystem.getVentilador()) {
					    	if (v.getNome().equals(aux)) {
					    		vService.checarInterruptor(v.getNome());
					    	}
					    }
				    }
				    if (operacao == 3) {
				    	System.out.println("Escolha o ventilador para alterar a velocidade:\n");
					    for (Ventilador v : homeSystem.getVentilador()) {
					    	System.out.printf("%s  ", v.getNome());
					    }
					    System.out.println("\n");
					    aux = scan.next();
					    for (Ventilador v : homeSystem.getVentilador()) {
					    	if (v.getNome().equals(aux)) {
					    		vControl.altIntensidade(v);
					    	}
					    }
				    }
				    break;
				    	
		    	case 5:
		    		uControl.altSenha(user);
		    		break;
		    		
		    	}
			    System.out.println("Escolha uma opção:\n");
			    System.out.println("1 - Porta   2 - Alarme   3 - Lampadas   4 - Ventilador   5 - Alterar Senha   0 - Sair\n");
			    opcao = scan.nextInt();
		    }
		  
		    scan.close();
		    return;
	    }
}

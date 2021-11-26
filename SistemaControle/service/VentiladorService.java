package SistemaControle.service;

import java.util.List;

import SistemaControle.domain.Sistema;
import SistemaControle.domain.Interface.iSistema;
import SistemaControle.domain.Interruptor.Ventilador;
import SistemaControle.service.Interface.IVentiladorService;

public class VentiladorService implements IVentiladorService {
	
	private iSistema sistema;
	
	public VentiladorService(iSistema sistema) {
		this.sistema = sistema;
	}

	@Override
	public boolean checarInterruptor(String Nome) {
		Ventilador ventilador = new Ventilador();
		
		for (Ventilador l : this.sistema.getVentilador()) {
			if (l.getNome().equals(Nome)) {
				ventilador = l;
			}
		}
		if (ventilador.getEstado() == true) {
			System.out.printf("A ventilador %s está ligado com uma intensidade de %s.\n", ventilador.getNome(), ventilador.getIntensidade());
		}
		
		else if (ventilador.getEstado() == false) {
			System.out.printf("A ventilador %s está desligado.\n", ventilador.getNome());
		}
		return false;
	}

	@Override
	public void altEstado(String Nome) {
		Ventilador ventilador = new Ventilador();
		
		for (Ventilador i : this.sistema.getVentilador()) {
			if (i.getNome().equals(Nome)) {
				ventilador = i;
			}
		}
		if (ventilador.getEstado() == true) {
			ventilador.setEstado(false);
			ventilador.setIntensidade("Desligado");
		}
		else if (ventilador.getEstado() == false) {
			ventilador.setEstado(true);
			ventilador.setIntensidade("Média"); //intensidade padrão
		}

	}

	@Override
	public List<Ventilador> buscarTodas(Sistema sistema) {
		return sistema.getVentilador();
	}
	
	public boolean altIntensidade(Ventilador ventilador, String intensidade) {
		ventilador.setIntensidade(intensidade);
		return true;
	}

}

package SistemaControle.service;

import java.util.List;
import SistemaControle.domain.Interface.iLampada;
import SistemaControle.domain.Interface.iSistema;
import SistemaControle.domain.Interruptor.Lampada;
import SistemaControle.service.Interface.ILampadaService;

public class LampadaService extends InterruptorService implements ILampadaService  {

	private iSistema sistema;
	
	public LampadaService(iSistema sistema) {
		this.sistema = sistema;
	}

	@Override
	public boolean checarInterruptor(String Nome) {
		Lampada lampada = new Lampada();
		
		for (Lampada l : this.sistema.getLampada()) {
			if (l.getNome().equals(Nome)) {
				lampada = l;
			}
		}
		if (lampada.getEstado() == true) {
			System.out.printf("A lampada %s está ligado com uma intensidade de %d.\n", lampada.getNome(), lampada.getIntensidade());
		}
		
		else if (lampada.getEstado() == false) {
			System.out.printf("A lampada %s está desligado.\n", lampada.getNome());
		}
		return lampada.getEstado();
	}

	@Override
	public void altEstado(String Nome) {
		Lampada lampada = new Lampada();
		
		for (Lampada i : this.sistema.getLampada()) {
			if (i.getNome().equals(Nome)) {
				lampada = i;
			}
		}
		if (lampada.getEstado() == true)
			lampada.setEstado(false);
		else if (lampada.getEstado() == false) {
			lampada.setEstado(true);
			lampada.setIntensidade(100); //intensidade padrão
		}
	}


	@Override
	public List<Lampada> buscarTodas(iSistema sistema) {
		return sistema.getLampada();
	}
	
	public boolean altIntensidade(iLampada lampada, int intensidade) {
		lampada.setIntensidade(intensidade);
		return true;
	}

}

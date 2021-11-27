package SistemaControle.service;

import SistemaControle.domain.Interface.iSistema;
import SistemaControle.domain.Interruptor.Interruptor;
import SistemaControle.service.Interface.IInterruptorService;

public abstract class InterruptorService implements IInterruptorService {
	
	private iSistema sistema;

	@Override
	public boolean checarInterruptor(String Nome) {
		Interruptor interruptor = new Interruptor();
		
		for (Interruptor i : this.sistema.getInterruptor()) {
			if (i.getNome().equals(Nome)) {
				interruptor = i;
			}
		}
		
		if (interruptor.getEstado() == true) {
			System.out.printf("O interruptor %s está ligado.\n", interruptor.getNome());
		}
		
		else if (interruptor.getEstado() == false) {
			System.out.printf("O interruptor %s está desligado.\n", interruptor.getNome());
		}
		return interruptor.getEstado();
	}

	@Override
	public void altEstado(String Nome) {
		Interruptor interruptor = new Interruptor();
		
		for (Interruptor i : this.sistema.getInterruptor()) {
			if (i.getNome().equals(Nome)) {
				interruptor = i;
			}
		}
		if (interruptor.getEstado() == true)
			interruptor.setEstado(false);
		else if (interruptor.getEstado() == false) {
			interruptor.setEstado(true);
		}
	}

}

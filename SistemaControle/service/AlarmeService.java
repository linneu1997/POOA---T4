package SistemaControle.service;

import java.util.List;

import SistemaControle.domain.Alarme;
import SistemaControle.domain.Sistema;
import SistemaControle.service.Interface.IAlarmeService;

public class AlarmeService implements IAlarmeService {

	@Override
	public boolean checarAlarme(Alarme alarme) {
		if (alarme.getEstado() == true)
			System.out.printf("O alarme %s está ligado.\n", alarme.getNome());
		else if (alarme.getEstado() == false)
			System.out.printf("O alarme %s está desligado.\n", alarme.getNome());
		return false;
	}

	@Override
	public List<Alarme> buscarTodas(Sistema sistema) {
		return sistema.getAlarme();
	}

	@Override
	public void altEstado(Alarme alarme) {
		if (alarme.getEstado() == true)
			alarme.setEstado(false);
		else if (alarme.getEstado() == false)
			alarme.setEstado(true);
	}

}

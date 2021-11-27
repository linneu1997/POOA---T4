package SistemaControle.service;

import java.util.List;

import SistemaControle.domain.Alarme;
import SistemaControle.domain.Interface.Devices;
import SistemaControle.domain.Interface.iSistema;
import SistemaControle.service.Interface.IAlarmeService;

public class AlarmeService implements IAlarmeService {

	@Override
	public boolean checarAlarme(Devices alarme) {
		if (alarme.getEstado() == true)
			System.out.printf("O alarme %s está ligado.\n", alarme.getNome());
		else if (alarme.getEstado() == false)
			System.out.printf("O alarme %s está desligado.\n", alarme.getNome());
		return false;
	}

	@Override
	public List<Alarme> buscarTodas(iSistema sistema) {
		return sistema.getAlarme();
	}

	@Override
	public void altEstado(Devices alarme) {
		if (alarme.getEstado() == true)
			alarme.setEstado(false);
		else if (alarme.getEstado() == false)
			alarme.setEstado(true);
	}

}

package SistemaControle.service;

import java.util.List;

import SistemaControle.domain.Porta;
import SistemaControle.domain.Interface.Devices;
import SistemaControle.domain.Interface.iSistema;
import SistemaControle.service.Interface.IPortaService;

public class PortaService implements IPortaService {

	@Override
	public boolean checarPorta(Devices porta) {
		if (porta.getEstado() == true) {
			System.out.printf("A porta %s está aberta.\n", porta.getNome());
		}
		
		else if (porta.getEstado() == false) {
			System.out.printf("A porta %s está fechada.\n", porta.getNome());
		}
		
		return porta.getEstado();
	}

	@Override
	public List<Porta> buscarTodas(iSistema sistema) {
		return sistema.getPorta();
	}

	@Override
	public void altEstado(Devices porta) {
		if (porta.getEstado() == true)
			porta.setEstado(false);
		else if (porta.getEstado() == false) {
			porta.setEstado(true);
		}
	}

	//@Override
	//public void addPorta(String Nome)


}

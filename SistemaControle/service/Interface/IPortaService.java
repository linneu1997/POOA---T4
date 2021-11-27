package SistemaControle.service.Interface;

import java.util.List;
import SistemaControle.domain.Porta;
import SistemaControle.domain.Interface.Devices;
import SistemaControle.domain.Interface.iSistema;

public interface IPortaService {
	
	public boolean checarPorta(Devices porta);
	public List<Porta> buscarTodas(iSistema sistema);
	public void altEstado(Devices porta);
	//public void addPorta();
}

package SistemaControle.service.Interface;

import java.util.List;
import SistemaControle.domain.Porta;
import SistemaControle.domain.Sistema;

public interface IPortaService {
	
	public boolean checarPorta(Porta porta);
	public List<Porta> buscarTodas(Sistema sistema);
	public void altEstado(Porta porta);
	//public void addPorta();
}

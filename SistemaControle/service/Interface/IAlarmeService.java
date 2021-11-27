package SistemaControle.service.Interface;

import java.util.List;
import SistemaControle.domain.Alarme;
import SistemaControle.domain.Interface.*;

public interface IAlarmeService {
	
	public boolean checarAlarme(Devices alarme);
	public List<Alarme> buscarTodas(iSistema sistema);
	public void altEstado(Devices alarme);
	//public void addAlarme();

}

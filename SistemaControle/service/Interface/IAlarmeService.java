package SistemaControle.service.Interface;

import java.util.List;
import SistemaControle.domain.Alarme;
import SistemaControle.domain.Sistema;

public interface IAlarmeService {
	
	public boolean checarAlarme(Alarme alarme);
	public List<Alarme> buscarTodas(Sistema sistema);
	public void altEstado(Alarme alarme);
	//public void addAlarme();

}

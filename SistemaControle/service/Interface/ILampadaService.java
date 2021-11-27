package SistemaControle.service.Interface;

import java.util.List;
import SistemaControle.domain.Interface.iLampada;
import SistemaControle.domain.Interface.iSistema;
import SistemaControle.domain.Interruptor.Lampada;

public interface ILampadaService extends IInterruptorService{
	public List<Lampada> buscarTodas(iSistema sistema);
	public boolean altIntensidade(iLampada lampada, int intensidade);
}

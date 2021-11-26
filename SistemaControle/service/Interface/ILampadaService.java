package SistemaControle.service.Interface;

import java.util.List;
import SistemaControle.domain.Sistema;
import SistemaControle.domain.Interruptor.Lampada;

public interface ILampadaService extends IInterruptorService{
	public List<Lampada> buscarTodas(Sistema sistema);
	public boolean altIntensidade(Lampada lampada, int intensidade);
}

package SistemaControle.service.Interface;

import java.util.List;
import SistemaControle.domain.Sistema;
import SistemaControle.domain.Interruptor.Ventilador;

public interface IVentiladorService extends IInterruptorService{
	public List<Ventilador> buscarTodas(Sistema sistema);
	public boolean altIntensidade(Ventilador ventilador, String intensidade);
}

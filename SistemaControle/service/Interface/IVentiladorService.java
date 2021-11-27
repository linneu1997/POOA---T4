package SistemaControle.service.Interface;

import java.util.List;
import SistemaControle.domain.Interface.iSistema;
import SistemaControle.domain.Interface.iVentilador;
import SistemaControle.domain.Interruptor.Ventilador;

public interface IVentiladorService extends IInterruptorService{
	public List<Ventilador> buscarTodas(iSistema sistema);
	public boolean altIntensidade(iVentilador ventilador, String intensidade);
}

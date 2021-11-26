package SistemaControle.domain.Interface;

import java.util.List;

import SistemaControle.domain.Alarme;
import SistemaControle.domain.Porta;
import SistemaControle.domain.Interruptor.*;

public interface iSistema {
	public void setNome(String Nome);
	public String getNome();
	public void newPorta(Porta porta);
	public List<Porta> getPorta();
	public void newAlarme(Alarme alarme);
	public List<Alarme> getAlarme();
	public void newLampada(Lampada lampada);
	public List<Lampada> getLampada();
	public void newVentilador(Ventilador ventilador);
	public List<Ventilador> getVentilador();
	public void newInterruptor(Interruptor interruptor);
	public List<Interruptor> getInterruptor();
}

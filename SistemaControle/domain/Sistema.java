package SistemaControle.domain;

import java.util.*;
import SistemaControle.domain.Interface.*;
import SistemaControle.domain.Interruptor.*;

public class Sistema implements iSistema {
	
	private String Nome;
	private List<Porta> listaPorta = new ArrayList<Porta>();
	private List<Alarme> listaAlarme = new ArrayList<Alarme>();
	private List<Interruptor> listaInterruptor = new ArrayList<Interruptor>();
	private List<Lampada> listaLampada = new ArrayList<Lampada>();
	private List<Ventilador> listaVentilador = new ArrayList<Ventilador>();
	
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public String getNome() {
		return this.Nome;
	}
	
	public void newPorta(Porta porta) {
		this.listaPorta.add(porta);
	}
	
	public List<Porta> getPorta(){
		return this.listaPorta;
	}
	
	public void newAlarme(Alarme alarme) {
		this.listaAlarme.add(alarme);
	}
	
	public List<Alarme> getAlarme(){
		return this.listaAlarme;
	}
	
	public void newLampada(Lampada lampada) {
		this.listaLampada.add(lampada);
	}
	
	public List<Lampada> getLampada(){
		return this.listaLampada;
	}
	
	public void newVentilador(Ventilador ventilador) {
		this.listaVentilador.add(ventilador);
	}
	
	public List<Ventilador> getVentilador(){
		return this.listaVentilador;
	}
	
	public void newInterruptor(Interruptor interruptor) {
		this.listaInterruptor.add(interruptor);
	}
	
	public List<Interruptor> getInterruptor(){
		return this.listaInterruptor;
	}
	
}

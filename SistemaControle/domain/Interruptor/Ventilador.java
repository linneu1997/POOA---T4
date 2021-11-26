package SistemaControle.domain.Interruptor;

import SistemaControle.domain.Interface.*;

public class Ventilador extends Interruptor implements iVentilador{
	
	private String intensidade = "Desligado";
	
	public void setIntensidade(String intensidade) {
		this.intensidade = intensidade;
	}
	
	public String getIntensidade() {
		return this.intensidade;
	}
}

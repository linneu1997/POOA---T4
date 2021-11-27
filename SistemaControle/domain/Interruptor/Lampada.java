package SistemaControle.domain.Interruptor;

import SistemaControle.domain.Interface.*;

public class Lampada extends Interruptor implements iLampada{
	
	private int intensidade = 0;
	
	public void setIntensidade(int intensidade) {
		this.intensidade = intensidade;
	}
	
	public int getIntensidade() {
		return this.intensidade;
	}

}

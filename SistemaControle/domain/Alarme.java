package SistemaControle.domain;

import SistemaControle.domain.Interface.*;

public class Alarme implements Devices{
	
	private boolean Estado;
	private String Nome;
	
	public void setEstado(boolean Estado) {
		this.Estado = Estado;
	}
	
	public boolean getEstado() {
		return this.Estado;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public String getNome() {
		return this.Nome;
	}
}


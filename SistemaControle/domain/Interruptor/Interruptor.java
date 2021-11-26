package SistemaControle.domain.Interruptor;

import SistemaControle.domain.Interface.Devices;

public class Interruptor implements Devices {

	private boolean Estado = false;
	protected String Nome;
	
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

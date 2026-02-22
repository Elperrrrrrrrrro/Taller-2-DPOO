package uniandes.dpoo.aerolinea.tiquetes;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class Tiquete {
	private Cliente cliente;
	private int tarifa;
	private String codigo;
	private Boolean usado;
	private Vuelo vuelo;
	
	
	public Tiquete(String Codigo,Vuelo vuelo,Cliente cliente, int tarifa,Boolean usado ) {
		this.tarifa = tarifa ;
		this.codigo = Codigo;
		this.usado = usado;
		this.cliente = cliente;
		this.vuelo= vuelo;
	}
	

	public int getTarifa() {
		return this.tarifa;
	}
	public String getCodigo() {
		return this.codigo;
	}

	
	public boolean esUsado() {
		return this.usado;
	}
	public void marcarComoUsado() {
		this.usado = true;
	}
	
	public Vuelo getVuelo() {
		return this.vuelo;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
}

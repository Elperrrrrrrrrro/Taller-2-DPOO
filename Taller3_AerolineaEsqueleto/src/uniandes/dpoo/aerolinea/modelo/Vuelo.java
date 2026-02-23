package uniandes.dpoo.aerolinea.modelo;
import uniandes.dpoo.aerolinea.tiquetes.*;
import uniandes.dpoo.aerolinea.modelo.tarifas.*;
import java.util.HashMap; 
import java.util.Map;
import uniandes.dpoo.aerolinea.modelo.cliente.*;
import uniandes.dpoo.aerolinea.exceptions.*;

public class Vuelo {
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private HashMap<String,Tiquete> tiquetes;
	
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		
				
	}
	
	public Ruta getRuta() {
		return this.ruta;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	public Avion getAvion() {
		return this.avion;
	}
	
	public HashMap<String,Tiquete> getTiquetes(){
		return this.tiquetes;
	}
	
	public int venderTiquetes​(Cliente cliente,
			CalculadoraTarifas calculadora,
			int cantidad) throws VueloSobrevendidoException {
		int costo = 0;
		if ( avion.getCapacidad()> cantidad) {
			costo = calculadora.calcularTarifa(this, cliente);
			
			for ( int i=0 ; i < cantidad ; i++) {
				Tiquete nuevo = GeneradorTiquetes.generarTiquete(this, cliente, costo);
				tiquetes.put(nuevo.getCodigo(), nuevo);
			}
		}else {
			throw new VueloSobrevendidoException(this);
		}
		
		
		return costo*cantidad;
	}
	
}

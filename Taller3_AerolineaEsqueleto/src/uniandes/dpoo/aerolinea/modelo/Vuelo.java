package uniandes.dpoo.aerolinea.modelo;
import uniandes.dpoo.aerolinea.tiquetes.*;
import java.util.HashMap; 
import java.util.Map;
import uniandes.dpoo.aerolinea.modelo.cliente.*;


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
			int cantidad) {
		
		
	}
	
}

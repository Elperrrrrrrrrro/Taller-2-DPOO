package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.cliente.*;
import uniandes.dpoo.aerolinea.modelo.*;

public abstract class CalculadoraTarifas {
	public static final double IMPUESTO = 0.28;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
	    int costo = calcularCostoBase(vuelo, cliente);
	    double descuento = calcularPorcentajeDescuento(cliente);
	    int impuesto = calcularValorImpuestos(costo);

	    return (int) ((costo + impuesto) - (costo * descuento));
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaEnKM(Ruta ruta) {
	    // Radio de la tierra en kilómetros
		double lat1= ruta.getOrigen().getLatitud();
		double lon1 = ruta.getOrigen().getLongitud();
		
		
		double lat2= ruta.getDestino().getLatitud();
		double lon2= ruta.getDestino().getLongitud();
	    double radioTierra = 6371.0;

	    // Diferencias de coordenadas en radianes
	    double dLat = Math.toRadians(lat2 - lat1);
	    double dLon = Math.toRadians(lon2 - lon1);

	    // Aplicación de la fórmula de Haversine
	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLon / 2) * Math.sin(dLon / 2);

	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	    return (int)radioTierra *(int) c;
	}
	
	protected int calcularValorImpuestos(int costoBase) {
		
		return (int)(costoBase*IMPUESTO);
	}
	
}

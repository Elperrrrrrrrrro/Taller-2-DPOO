package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	
	protected int COSTO_POR_KM= 100;
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int rta = 0;
		String tipo = cliente.getTipoCliente();

		
		double distania = calcularDistanciaEnKM(vuelo.getRuta());
		
		
		
		return rta*COSTO_POR_KM ;

	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		
		return 1; 
	}
}

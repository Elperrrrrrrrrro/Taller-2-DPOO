package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.cliente.*;
import uniandes.dpoo.aerolinea.modelo.*;
public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	protected int COSTO_POR_KM_NATURAL=600;
	protected int COSTO_POR_KM_CORPORATIVO=900; 
	protected double DESCUENTO_PEQ=0.02 ;
	protected double DESCUENTO_MEDIANAS = 0.1 ;
	protected double DESCUENTO_GRANDES = 0.2;
	
	
	
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int rta = 0;
		String tipo = cliente.getTipoCliente();

		
		double distania = calcularDistanciaEnKM(vuelo.getRuta());
		
		if ("Corporativo".equals(tipo)) {
			rta = (int)distania*COSTO_POR_KM_CORPORATIVO;
		}else if("Natural".equals(tipo)) {
			rta = (int)distania*COSTO_POR_KM_NATURAL;
		}
		
		return rta;

	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		double rta = 0;
		if (cliente instanceof ClienteCorporativo) {
	        

	        ClienteCorporativo empresa = (ClienteCorporativo) cliente;
	        

	        int tamano = empresa.getTamanoEmpresa();
	        switch (tamano) {
	            case 1:
	            	rta = DESCUENTO_GRANDES;
	            case 2:
	            	rta = DESCUENTO_MEDIANAS;
	            case 3:
	            	rta = DESCUENTO_PEQ;
	        
	        }

	    }
		return rta;
	}
	
}
	

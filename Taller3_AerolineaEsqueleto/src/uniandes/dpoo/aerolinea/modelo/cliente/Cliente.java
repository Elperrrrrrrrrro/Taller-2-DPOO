package uniandes.dpoo.aerolinea.modelo.cliente;
import java.util.ArrayList;
import uniandes.dpoo.aerolinea.modelo.*;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
public abstract class Cliente {
		
		private ArrayList<Tiquete> tiquetesSinUsar;
		private ArrayList<Tiquete> 	tiquetesUsados;
		
		public Cliente() {
			
		}
		
		
		
		public abstract String getTipoCliente();
		
		public abstract String getIdentificador();
		
		public void agregarTiquete(Tiquete tiquete) {
			tiquetesSinUsar.add(tiquete);
		}
		
		public  int calcularValorTotalTiquetes() {
			int total = 0;
			for( Tiquete i : tiquetesSinUsar) {
				total += i.getTarifa();
			}
			for( Tiquete i : tiquetesUsados) {
				total += i.getTarifa();
			}
			return total;
		}
		
		public void usarTiquetes(Vuelo vuelo) {
			for (Tiquete i: vuelo.getTiquetes() .values()) {
				if ( tiquetesSinUsar.contains(i)) {
					int posicion = tiquetesSinUsar.indexOf(i);
					i.marcarComoUsado();
					Tiquete eliminado = tiquetesSinUsar.remove(posicion);
					tiquetesUsados.add(eliminado);
					
				}
			}
		}
		
			
		
}

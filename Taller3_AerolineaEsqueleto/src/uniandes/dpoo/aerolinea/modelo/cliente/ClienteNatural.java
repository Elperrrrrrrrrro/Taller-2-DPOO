package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente{
	// atributos
	public static final String NATURAL = "Natural";
	private String nombre;
	
	// costructor
	public ClienteNatural(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	// metodos
	@Override
	public String getIdentificador() {
		return this.nombre;
	}
	@Override
	public String getTipoCliente() {
		return this.NATURAL;
	}
	
}

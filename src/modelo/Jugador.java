package modelo;
public class Jugador {
	
	// ATRIBUTOS
	
	private String nombreJugador;
	private int puntosGanadores;
	private int erroresNoForzados;
	private int saquesDirectos;
	
	// CONSTRUCTORES
	
	public Jugador() {}
	
	public Jugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
		this.puntosGanadores = 0;
		this.erroresNoForzados = 0;
		this.saquesDirectos = 0;
	}
	
	// METODOS GET / SET

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public int getPuntosGanadores() {
		return puntosGanadores;
	}

	public void setPuntosGanadores(int puntosGanadores) {
		this.puntosGanadores = puntosGanadores;
	}

	public int getErroresNoForzados() {
		return erroresNoForzados;
	}

	public void setErroresNoForzados(int erroresNoForzados) {
		this.erroresNoForzados = erroresNoForzados;
	}

	public int getSaquesDirectos() {
		return saquesDirectos;
	}

	public void setSaquesDirectos(int saquesDirectos) {
		this.saquesDirectos = saquesDirectos;
	}
	
	// METODOS IMPLEMENTADOS
	
	public void anadePuntoGanador() {
		puntosGanadores++;
	}
	
	public void anadeErrorNoForzado() {
		erroresNoForzados++;
	}
	
	public void anadeSaqueDirecto() {
		saquesDirectos++;
	}
	
	@Override
	public String toString() {
		String info = "+++ " + nombreJugador.toUpperCase() + " +++\n"
				+ "\tPuntos ganadores: " + getPuntosGanadores() + "\n"
				+ "\tErrores no forzados: " + getErroresNoForzados() + "\n"
				+ "\tSaques directos: " + getSaquesDirectos() + "\n";
		return info;
	}

}

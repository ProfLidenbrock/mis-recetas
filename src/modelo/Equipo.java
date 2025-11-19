package modelo;

public class Equipo {
	
	// ATRIBUTOS
	
	private String nombreEquipo;
	private Jugador jugador1;
	private Jugador jugador2;
	
	// CONSTRUCTORES
	
	public Equipo(String nombreEquipo, Jugador jugador1, Jugador jugador2) {
		this.nombreEquipo = nombreEquipo;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	
	public Equipo(String nombreEquipo, String nombreJugador1, String nombreJugador2) {
		this.nombreEquipo = nombreEquipo;
		this.jugador1 = new Jugador(nombreJugador1);
		this.jugador2 = new Jugador(nombreJugador2);
	}
	
	// METODOS GET / SET

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}
	
	// METODOS IMPLEMENTADOS
	
	public boolean existeJugador(String nombreJugador) {
		boolean existe = false;
		if (nombreJugador.equals(jugador1.getNombreJugador())) {
			existe = true;
		}
		if (nombreJugador.equals(jugador2.getNombreJugador())) {
			existe = true;
		}
		return (existe);
	}
	
	public Jugador obtenerJugador(String nombreJugador) {
		Jugador jugador = null;
		if (nombreJugador.equals(jugador1.getNombreJugador())) {
			jugador = jugador1;
		}
		if (nombreJugador.equals(jugador2.getNombreJugador())) {
			jugador = jugador2;
		}
		return jugador;
	}
	
	/*
	 * CASOS DE USO 1, 2, 3
	 * 
	 * Recibe: el nombre del jugador y un parametro llamado tipoPunto 
	 * (1 si es un PUNTO GANADOR, 2 si es un ERROR NO FORZADO, 3 si es un SAQUE DIRECTO)
	 * 
	 * Devuelve:
	 *  	-1 		Si el jugador no existe
	 *  	 0		Si otra cosa sale mal
	 *  	 1		Si se contabiliza el punto 
	 */
	public void contabiliza(String nombreJugador, int tipoPunto){
		
		Jugador jugadorAnotador = obtenerJugador(nombreJugador);
		
		if (tipoPunto == 1) {	// Para PUNTO GANADOR
			jugadorAnotador.anadePuntoGanador();
			
		} else if (tipoPunto == 2) { // Para ERROR NO FORZADO
			jugadorAnotador.anadeErrorNoForzado();
			
		} else if (tipoPunto == 3) { // Para SAQUE DIRECTO
			jugadorAnotador.anadeSaqueDirecto();
		}
		
	}


	@Override
	public String toString() {
		String info = "*** " + nombreEquipo.toUpperCase() + " ***\n"
				+ "\tPuntos ganadores: " + (jugador1.getPuntosGanadores() + jugador2.getPuntosGanadores()) + "\n"
				+ "\tErrores no forzados: " + (jugador1.getErroresNoForzados() + jugador2.getErroresNoForzados()) + "\n"
				+ "\tSaques directos: " + (jugador1.getSaquesDirectos() + jugador2.getSaquesDirectos()) + "\n";
		return info;
	}
	
	public String estadisticasJugador(String nombreJugador) {
		Jugador jugador = obtenerJugador(nombreJugador);
		return (jugador.toString());
	}
	
	/*
	 * METODOS DE LA FUNCIONALIDAD ADICIONAL
	 */
	
	public String nombreJugador(int orden) {
		// Devuelve nombre del primer jugador
		if (orden == 1) {
			return (jugador1.getNombreJugador());
		// Devuelve nombre del primer jugador
		} else {
			return (jugador2.getNombreJugador());
		}
	}
	
}

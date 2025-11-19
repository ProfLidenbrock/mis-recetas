package modelo;

public class Partido {
	
	// ATRIBUTOS
	
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	
	// CONSTRUCTORES
	
	private Partido() {}
	
	public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
	}
	
	public Partido(String equipo1, String jugador1E1, String jugador2E1, String equipo2, String jugador1E2, String jugador2E2) {
		this.equipoLocal = new Equipo(equipo1, jugador1E1, jugador2E1);
		this.equipoVisitante = new Equipo(equipo2, jugador1E2, jugador2E2);;
	}
	
	// METODOS NECESARIOS PARA LOS CASOS DE USO 1, 2 y 3
	
	private boolean existeJugador(String nombreJugador) {
		boolean existe = false;
		if (equipoLocal.existeJugador(nombreJugador)) {
			existe = true;
		}
		if (equipoVisitante.existeJugador(nombreJugador)) {
			existe = true;
		}
		return (existe);
	}
	
	/*
	 * Dado un nombre de jugador, nos devuelve el objeto equipo al que pertenece
	 */
	public Equipo equipoDelJugador(String nombreJugador) {
		Equipo equipo = null;
		if (this.equipoLocal.existeJugador(nombreJugador)) {
			equipo = this.equipoLocal;
		}
		if (equipoVisitante.existeJugador(nombreJugador)) {
			equipo = this.equipoVisitante;
		}
		return equipo;
	}
	
	/*
	 * Dado un nombre de equipo, si un partido tiene un objeto equipo con ese nombre, nos devuelve ese equipo.
	 */
	private Equipo obtenerEquipo(String nombreEquipo) {
		Equipo equipo = null;
		if (nombreEquipo.equals(equipoLocal.getNombreEquipo())) {
			equipo = equipoLocal;
		}
		if (nombreEquipo.equals(equipoVisitante.getNombreEquipo())) {
			equipo = equipoVisitante;
		}
		return (equipo);
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
	public int contabiliza(String nombreJugador, int tipoPunto){
		int valor = 0;
		if (!existeJugador(nombreJugador)) {
			valor = -1;
		} else {
			Equipo equipoJugador = equipoDelJugador(nombreJugador);	
			equipoJugador.contabiliza(nombreJugador, tipoPunto);
		}
		return valor;
	}
	
	/*
	 * CASO DE USO 4 
	 */
	public String estadisticasJugador(String nombreJugador) {
		String info = "";
		if (!existeJugador(nombreJugador)) {
			info = "NO EXISTE NINGUN JUGADOR CON ESE NOMBRE";
		} else {
			Equipo equipo = equipoDelJugador(nombreJugador);
			info = equipo.estadisticasJugador(nombreJugador);
		}
		
		
		return info;
	}
	
	public boolean existeEquipo(String nombreEquipo) {
		boolean existe = false;
		if (nombreEquipo.equals(equipoLocal.getNombreEquipo())) {
			existe = true;
		}
		if (nombreEquipo.equals(equipoVisitante.getNombreEquipo())) {
			existe = true;
		}
		return (existe);
	}
	
	/*
	 * CASO DE USO 5
	 */
	public String estadisticasEquipo(String nombreEquipo) {
		String info = "";
		if (!existeEquipo(nombreEquipo)) {
			info = "NO EXISTE NINGUN EQUIPO CON ESE NOMBRE";
		} else {
			Equipo equipo = obtenerEquipo(nombreEquipo);
			info = equipo.toString();
		}
		return info;
	}
	
	/*
	 * Funcionalidad extra que permite chequear que no se mete 2 veces el mismo jugador o el mismo equipo
	 * 
	 * Devuelve:
	 * 0 si no hay datos repetidos
	 * 2 si el segundo equipo ya se llama como el equipo 1
	 * -2 si el segundo jugador se llama con el jugador 1
	 * -3 si el tercer jugador se llama con el jugador 1 o 2
	 * -4 si el cuarto jugador se llama con el jugador 1, 2 o 3
	 */
	public int comprobarDatosRepetidos() {
		int codigo = 0;
		if (equipoLocal.getNombreEquipo().equals(equipoVisitante.getNombreEquipo())) {			// Comparo los nombres de EQUIPOS
			codigo = 2;
		} else if (equipoLocal.nombreJugador(1).equals(equipoLocal.nombreJugador(2))) {			// Comparo en el EQUIPO 1 los nombres de los JUGADORES
			codigo = -2;
		} else if (equipoLocal.existeJugador(equipoVisitante.nombreJugador(1))) {				// Compruebo del EQUIPO 2, si su JUGADOR 1, existe en el EQUIPO 1
			codigo = -3;
		} else if (equipoLocal.existeJugador(equipoVisitante.nombreJugador(2))) {				// Compruebo del EQUIPO 2, si su JUGADOR 2, existe en el EQUIPO 1 
			codigo = -4;
		}
		return codigo;
	}

} // 196

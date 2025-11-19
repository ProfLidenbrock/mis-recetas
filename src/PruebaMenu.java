import java.util.Scanner;

import fundamentos.*;
import modelo.Partido;

public class PruebaMenu {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Partido cuartos = null;
		
		boolean datosValidos = false;
		String nomE1, nombreJ1, nombreJ2, nomE2, nombreJ3, nombreJ4;
		while (!datosValidos) {

			// Informacion del EQUIPO 1 y sus jugadores
			
			Lectura lec1 = new Lectura ("Equipo LOCAL");
			
			lec1.creaEntrada("Introduzca nombre del PRIMER equipo", "");
		    lec1.creaEntrada("Jugador 1", "");
		    lec1.creaEntrada("Jugador 2", "");
		    lec1.esperaYCierra("Introduce datos y pulsa aceptar");
		    
		    nomE1  = lec1.leeString("Introduzca nombre del PRIMER equipo");
		    nombreJ1 = lec1.leeString("Jugador 1");
		    nombreJ2 = lec1.leeString("Jugador 2");

			// Informacion del EQUIPO 2 y sus jugadores
		    
		    Lectura lec2 = new Lectura ("Equipo VISITANTE");
			
			lec2.creaEntrada("Introduzca nombre del SEGUNDO equipo", "Internacional");
		    lec2.creaEntrada("Jugador 1", "djkovic");
		    lec2.creaEntrada("Jugador 2", "federer");
		    lec2.esperaYCierra("Introduce datos y pulsa aceptar");
		    
		    nomE2  = lec2.leeString("Introduzca nombre del SEGUNDO equipo");
		    nombreJ3 = lec2.leeString("Jugador 1");
		    nombreJ4 = lec2.leeString("Jugador 2");

			cuartos = new Partido(nomE1, nombreJ1, nombreJ2, nomE2, nombreJ3, nombreJ4);

			int codigo = cuartos.comprobarDatosRepetidos();
			if (codigo == 0) {
				datosValidos = true;
			} else if (codigo > 0) {
				Mensaje mensaje = new Mensaje ();
				mensaje.escribe("El nombre del EQUIPO " + codigo + " esta REPETIDO");
			} else if (codigo < 0) {
				Mensaje mensaje = new Mensaje ();
				mensaje.escribe("El nombre del JUGADOR " + Math.abs(codigo) + " esta REPETIDO");
			}
		}
		
		Menu menu= new Menu("CUARTOS DE FINAL DE ROLAND GARROS"); 
		
		menu.insertaOpcion("Contabiliza punto ganador", 1);
		menu.insertaOpcion("Contabiliza error no forzado", 2);
		menu.insertaOpcion("Contabiliza saque directo", 3);
		menu.insertaOpcion("Estadisticas jugador", 4);
		menu.insertaOpcion("Estadisticas equipo", 5);
		menu.insertaOpcion("Salir", 6);
	

		boolean finalizar = false;
		while (!finalizar) {

			int opcion = menu.leeOpcion("Elige una opcion");
			
			if (opcion == 1) {
				
				Lectura lec = new Lectura ("PUNTO GANADOR");
				
				lec.creaEntrada("Jugador que lo realiza", "");
			    lec.esperaYCierra("Introduce datos y pulsa aceptar");
			    
			    String nombreJugador  = lec.leeString("Jugador que lo realiza");

				int valor = cuartos.contabiliza(nombreJugador, 1); /////////////////////////////////////////

				if (valor == -1) {
					Mensaje mensaje = new Mensaje ();
					mensaje.escribe("NO EXISTE NINGUN JUGADOR CON ESE NOMBRE");
				} else if (valor == 1) {
					Mensaje mensaje = new Mensaje ();
					mensaje.escribe("*** PUNTO GANADOR REGISTRADO ***");
				}

			} else if (opcion == 2) {
				
				Lectura lec = new Lectura ("ERROR NO FORZADO");
				
				lec.creaEntrada("Jugador que lo realiza", "");
			    lec.esperaYCierra("Introduce datos y pulsa aceptar");
			    
			    String nombreJugador  = lec.leeString("Jugador que lo realiza");

				int valor = cuartos.contabiliza(nombreJugador, 2); ///////////////////////////////////////////

				if (valor == -1) {
					Mensaje mensaje = new Mensaje ();
					mensaje.escribe("NO EXISTE NINGUN JUGADOR CON ESE NOMBRE");
				} else if (valor == 1) {
					Mensaje mensaje = new Mensaje ();
					mensaje.escribe("*** ERROR NO FORZADO REGISTRADO ***");
				}

			} else if (opcion == 3) {
				
				Lectura lec = new Lectura ("SAQUE DIRECTO");
				
				lec.creaEntrada("Jugador que lo realiza", "");
			    lec.esperaYCierra("Introduce datos y pulsa aceptar");
			    
			    String nombreJugador  = lec.leeString("Jugador que lo realiza");

				int valor = cuartos.contabiliza(nombreJugador, 3); ////////////////////////////////////////////

				if (valor == -1) {
					Mensaje mensaje = new Mensaje ();
					mensaje.escribe("NO EXISTE NINGUN JUGADOR CON ESE NOMBRE");
				} else if (valor == 1) {
					Mensaje mensaje = new Mensaje ();
					mensaje.escribe("*** SAQUE DIRECTO REGISTRADO ***");
				}

			} else if (opcion == 4) {
				
				Lectura lec = new Lectura ("Estadisticas JUGADOR");
				
				lec.creaEntrada("Jugador que lo realiza", "");
			    lec.esperaYCierra("Introduce datos y pulsa aceptar");
			    
			    String nombreJugador  = lec.leeString("Jugador que lo realiza");

				Mensaje mensaje = new Mensaje ("Estadisticas de... " + nombreJugador);
				mensaje.escribe(cuartos.estadisticasJugador(nombreJugador));		 ////////////////
				
			} else if (opcion == 5) {
				
				Lectura lec = new Lectura ("Estadisticas EQUIPO");
				
				lec.creaEntrada("Nombre del equipo", "");
			    lec.esperaYCierra("Introduce datos y pulsa aceptar");
			    
			    String nombreEquipo  = lec.leeString("Nombre del equipo");

				Mensaje mensaje = new Mensaje ("Estadisticas de... " + nombreEquipo);
				mensaje.escribe(cuartos.estadisticasEquipo(nombreEquipo));			 /////////////////
				
			} else if (opcion == 6){
				MensajeSiNo mensaje = new MensajeSiNo ("Salir de la aplicacion");
				boolean respuesta = mensaje.pregunta("Esta seguro de que quiere cerrar el programa ???");
				if (respuesta == true) {
					finalizar = true;
					menu.cierra();
				}
				
			}

		}

	}

}

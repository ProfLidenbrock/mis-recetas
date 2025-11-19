import java.util.Scanner;

import modelo.Equipo;
import modelo.Jugador;
import modelo.Partido;

/**
 * 
 * @author Carlos-PC
 * 
 * Version 1: no controla que pueda haber un jugador repetido.
 *
 */

public class PruebaTenis1 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		Partido cuartos;
		
		System.out.println("CUARTOS DE FINAL DE ROLAND GARROS \n");
	
		// Informacion del EQUIPO 1 y sus jugadores
		
		System.out.println("Introduzca el nombre del 1er equipo: ");
		String nomE1 = entrada.nextLine();
		System.out.println("Jugador 1: ");
		String nombreJ1 = entrada.nextLine();
		System.out.println("Jugador 2: ");
		String nombreJ2 = entrada.nextLine();
		
		// Informacion del EQUIPO 2 y sus jugadores
		
		System.out.println("\nIntroduzca el nombre del 2º equipo: ");
		String nomE2 = entrada.nextLine();
		System.out.println("Jugador 1: ");
		String nombreJ3 = entrada.nextLine();
		System.out.println("Jugador 2: ");
		String nombreJ4 = entrada.nextLine();
		
		/**
		 * 1a forma de trabajar.
		 */
		
		
		// Creo los jugadores del 1er equipo
		Jugador jugador1 = new Jugador(nombreJ1);
		
		Jugador jugador2 = new Jugador();
		jugador2.setNombreJugador(nombreJ2);			// Utilizo este metodo a proposito para la siguiente explicacion
				
		// Creo el 1er equipo
		Equipo e1 = new Equipo(nomE1, jugador1, jugador2);
		// Creo el 2º equipo y a la vez sus jugadores
		Equipo e2 = new Equipo(nomE2, new Jugador (nombreJ3), new Jugador (nombreJ4));
		
		// Creo un partido 
		cuartos = new Partido(e1, e2);
		
		
		/**
		 *  PROBLEMA DE ESTA FORMA DE TRABAJAR: *** ACOPLAMIENTO DE CLASES ***
		 *  La linea jugador2.setNombreJugador(nombreJ2) dara error, si elimino el metodo setNombreJugador() de la clase Jugador.
		 *  Parece improbable que este metodo lo tenga que borrar, pero ¿y si es un metodo para leer info de fichero y ahora leo de un BD relacional MySQL?
		 *  ¿Y si por lo que sea, ya no uso BD relacionales y leo de una BD XML o un BD Orientada a grafos? 
		 *  (TENGO QUE MODIFICAR CODIGO EN MUCHOS ARCHIVOS: Podria haber 20 clases en las que hubiera llamado a ese metodo.
		 *  LA IDEA ES QUE SI MODIFICO/BORRO UN METODO DE UNA CLASE, solo tenga que modificar 1 archivo mas: la clase donde uso la instancia de ese objeto)
		 */
		
		/**
		 * 2a forma de trabajar, algo MAS OPTIMA
		 */
		
		// Usando este constructor de partido, ahorro las lineas de codigo de antes.
		//cuartos = new Partido(nomE1, nombreJ1, nombreJ2, nomE2, nombreJ3, nombreJ4);
		
		boolean finalizar = false;
		while (!finalizar) {
			System.out.println("\t Estadisticas");
			System.out.println("\t ------------ \n");
			
			System.out.println("\t 1. Contabiliza punto ganador.");
			System.out.println("\t 2. Contabiliza error no forzado");
			System.out.println("\t 3. Contabiliza saque directo.");
			System.out.println("\t 4. Muestra estadisticas jugador.");
			System.out.println("\t 5. Muestra estadisticas equipo. \n");
			
			System.out.println("Introduce opcion: ");
			int opcion = entrada.nextInt();
			entrada.nextLine();
			
			if (opcion == 1) {
				System.out.print("\n ¿Que jugador ha realizado el punto ganador?\n ");
				String nombreJugador = entrada.nextLine();
				
				int valor = cuartos.contabiliza(nombreJugador, 1);				/////////////////////////////////////////
				
				if (valor == -1) {
					System.err.println("\t NO EXISTE NINGUN JUGADOR CON ESE NOMBRE \n");
				} else if (valor == 1) {
					System.out.println("\t *** PUNTO GANADOR REGISTRADO *** \n");
				}
				
			} else if (opcion == 2) {
				System.out.print("\n ¿Que jugador ha realizado el error no forzado?\n ");
				String nombreJugador = entrada.nextLine();
				
				int valor = cuartos.contabiliza(nombreJugador, 2);			///////////////////////////////////////////
				
				if (valor == -1) {
					System.err.println("\t NO EXISTE NINGUN JUGADOR CON ESE NOMBRE \n");
				} else if (valor == 1) {
					System.out.println("\t *** ERROR NO FORZADO REGISTRADO *** \n");
				}
				
			} else if (opcion == 3) {
				System.out.print("\n ¿Que jugador ha realizado el saque directo?\n ");
				String nombreJugador = entrada.nextLine();
				
				int valor = cuartos.contabiliza(nombreJugador, 3);				////////////////////////////////////////////
				
				if (valor == -1) {
					System.err.println("\t NO EXISTE NINGUN JUGADOR CON ESE NOMBRE \n");
				} else if (valor == 1) {
					System.out.println("\t *** SAQUE DIRECTO REGISTRADO *** \n");
				}
				
			} else if (opcion == 4) {
				System.out.print("\n Nombre del jugador: \n ");
				String nombreJugador = entrada.nextLine();
				
				System.out.println("\t " + cuartos.estadisticasJugador(nombreJugador) + " \n");		////////////////////////////////////////////
				
			} else if (opcion == 5) {
				System.out.print("\n Nombre del equipo: \n ");
				String nombreEquipo = entrada.nextLine();
				
				System.out.println("\t " + cuartos.estadisticasEquipo(nombreEquipo) + " \n");		////////////////////////////////////////////
				
			} else {
				System.err.println("\t OPCION NO CONTEMPLADA EN EL MENU \n");
				//finalizar = true;
			}
			
		}

	}

}

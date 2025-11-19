import java.util.Scanner;

import modelo.Partido;

/**
 * 
 * @author Carlos-PC
 * 
 * Version 2: CONTROLA que el nombre de los jugadores, sea distinto en los 2 equipos.
 *
 */

public class PruebaTenis2 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		Partido cuartos = null;
		
		System.out.println("CUARTOS DE FINAL DE ROLAND GARROS \n");
		
		boolean datosValidos = false;
		String nomE1, nombreJ1, nombreJ2, nomE2, nombreJ3, nombreJ4;
		while(!datosValidos) {
			
			// Informacion del EQUIPO 1 y sus jugadores
		
			System.out.println("Introduzca el nombre del 1er equipo: ");
			nomE1 = entrada.nextLine();
			System.out.println("Jugador 1: ");
			nombreJ1 = entrada.nextLine();
			System.out.println("Jugador 2: ");
			nombreJ2 = entrada.nextLine();
		
			// Informacion del EQUIPO 2 y sus jugadores
		
			System.out.println("\nIntroduzca el nombre del 2º equipo: ");
			nomE2 = entrada.nextLine();
			System.out.println("Jugador 3: ");
			nombreJ3 = entrada.nextLine();
			System.out.println("Jugador 4: ");
			nombreJ4 = entrada.nextLine();
		
			cuartos = new Partido(nomE1, nombreJ1, nombreJ2, nomE2, nombreJ3, nombreJ4);
			
			int codigo = cuartos.comprobarDatosRepetidos();
			if (codigo == 0) {
				datosValidos = true;
			} else if (codigo > 0) {
				System.out.println("\n**** El nombre del EQUIPO " + codigo + " esta REPETIDO. ***\n ");
			} else if (codigo < 0) {
				System.out.println("\n*** El nombre del JUGADOR " + Math.abs(codigo) + " esta REPETIDO. ***\n ");
			}
		}
		
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
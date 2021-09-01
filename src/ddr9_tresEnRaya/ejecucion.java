package ddr9_tresEnRaya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejecucion {

	static Scanner teclado = new Scanner(System.in); // se pone en global porq lo utilizamos en varios sitios
	public static void main(String[] args) {
	
		jugar();
	}
	
	
	private static void jugar() {
		TicTacToe juego = new TicTacToe();

		//juego.inicializarTablero();
		int fila, columna;
		boolean postValida, correcto;
		
		

		while (!juego.finPartida()) {

			// todo esto es para validar la casilla

			do {

				juego.mostrarTurnoActual();
				juego.mostrarTablero();

				fila = pedirInteger("Introduce el numero de fila");
				correcto = false;

				columna = pedirInteger("Introduce el numero de columna");

				postValida = juego.validarPosicion(fila, columna);

				if (postValida) {

					if (!juego.hayValorPosicion(fila, columna)) {

						correcto = true;  //para que termine el bucle

					} else {
						for (int i = 0; i < 10; ++i)
							System.out.println();
						System.out.println("la posicion elegida ya está ocupada, elige otra nueva");

					}

				} else {
					for (int i = 0; i < 10; ++i)
						System.out.println();
					System.out.println("La posicion introducida esta fuera del tablero");

				}

			} while (!correcto); // hasta que no sea correcto no acaba

			juego.insertarEn(fila, columna);
			
			juego.cambiarTurno(); // para cambiar de jugador

		}
		juego.mostrarTablero();
		
		Simbolos ganador = juego.ganador();
		
		if (ganador == null) {
			System.out.println("hay empate");
		}else if (ganador == ganador.X) {
			System.out.println("el ganador es J1");
		}else {
			System.out.println("el ganador es J2");
		}
		
	}

	public static int pedirInteger(String mensaje) {

		//metodo para pedir los datos del usuario
		boolean correcto;
		int numero = 0;
		
		do {
			System.out.println(mensaje);
			try {
				
				numero = teclado.nextInt();
				correcto = true;
				
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				teclado.next();
				correcto = false;
			}
			
		} while (!correcto);

		return numero;

	}

}

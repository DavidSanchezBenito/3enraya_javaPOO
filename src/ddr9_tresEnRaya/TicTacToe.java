	package ddr9_tresEnRaya;

public class TicTacToe {

	//version POO del ejercicio de tres en raya
	//31-8-21 empezado y acabado el 1-9-21
	//https://www.youtube.com/watch?v=Od-E8YaAPF0
	//https://www.youtube.com/watch?v=xdfbQg77qfE&t=528s
	
	private Simbolos [][] tablero;
	private boolean turno;  //true = J1 (ficha X), false = J2 (ficha O)
	
//	private final int TIPO_LINEA = 1;
//	private final int TIPO_COLUMNA = 2;
//	private final int TIPO_DIAGONAL = 3;
	
	public TicTacToe() { //inicializo automaticamente cuando se crea un objeto
		
		this.tablero = new Simbolos [3][3];
		this.turno = true;
		inicializarTablero();
	}
	
	public void mostrarTablero() {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				System.out.print(tablero[i][j].getSimbolos());
			}
			System.out.println("");
		}

	}
	

	public void mostrarTurnoActual() {
		if (this.turno) {
			System.out.println("le toca al jugador 1");
		} else {
			System.out.println("le toca al jugador 2");
		}

	}


	public void inicializarTablero() {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = Simbolos.VACIO;
			}

		}
	}


	public  boolean validarPosicion( int fila, int columna) {

		// la posicion esta dentro del rango del tablero
		if (fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length) {

			return true;
		}
		return false;
	}

	public  boolean hayValorPosicion(int fila, int columna) {

		if (tablero[fila][columna] != Simbolos.VACIO) {

			return true;
		}
		return false; // no hay ninguna ficha puesta y se puede sustituir

	}

	public  void insertarEn(int fila, int columna) {

		if (turno) {
			tablero[fila][columna] = Simbolos.X;	
		}else {
			tablero[fila][columna] = Simbolos.O; 
		}
		

	}

	public  boolean tableroLleno() {
		for (int i = 0; i < tablero.length; i++) {  //tamaño filas
			for (int j = 0; j < tablero[0].length; j++) {  //tamaño columnas
				if (tablero[i][j] == Simbolos.VACIO) {
					return false; // hay todavia alguna posicion con guion q 
									//se puede rellenar
				}
			}

		}
		
		return true; // esta lleno con fichas de los jugadores
		

	}

	public  boolean finPartida() {

	
	//la partida acaba cuando se da alguna de estas 4 opciones
		if (tableroLleno() 
				|| coincidenciaLinea() != Simbolos.VACIO
				|| coincidenciaColumna() != Simbolos.VACIO
				|| coincidenciaDiagonal() != Simbolos.VACIO) {
		
			return true;
	
		}

		return false;

	}

	public Simbolos coincidenciaLinea() {

	
		Simbolos simbolo;
		boolean coincidencia;

		for (int i = 0; i < tablero.length; i++) {
			coincidencia = true;
			simbolo = tablero[i][0];

			if (simbolo != Simbolos.VACIO) { // si es distinto al simbolo por defecto continua

				for (int j = 1; j < tablero[0].length; j++) {
					if (simbolo != tablero[i][j]) {
						coincidencia = false;
					}

				}
				if (coincidencia) { // es decir no se ha cambaido
					return simbolo;

				}

			}

		} // for


		return Simbolos.VACIO;
		

	}

	public Simbolos coincidenciaColumna() {
		
		Simbolos simbolo;
		boolean coincidencia;

		for (int j = 0; j < tablero.length; j++) {
			coincidencia = true;
			simbolo = tablero[0][j];

			if (simbolo != Simbolos.VACIO) { // si es distinto al simbolo por defecto continua

				for (int i = 1; i < tablero[0].length; i++) {
					if (simbolo != tablero[i][j]) {
						coincidencia = false;
					}

				}
				if (coincidencia) { // es decir no se ha cambaido
					return simbolo;

				}

			}

		} // for

		return Simbolos.VACIO;

	}

	public Simbolos coincidenciaDiagonal() {


		Simbolos simbolo;
		boolean coincidencia = true;

		// diagonal principal

		simbolo = tablero[0][0];
		if (simbolo != Simbolos.VACIO) { // si es distinto al simbolo por defecto continua

			for (int i = 1; i < tablero.length; i++) {
				if (simbolo != tablero[i][i]) {
					coincidencia = false;
				}
			}
			if (coincidencia) {
				return simbolo;
			}

		}

		//diagonal inversa
		simbolo = tablero[0][2];
		if (simbolo != Simbolos.VACIO) { // si es distinto al simbolo por defecto continua

			for (int i = 1, j = 1; i < tablero.length; i++, j--) {
				if (simbolo != tablero[i][j]) {
					coincidencia = false;
				}
			}
			if (coincidencia) {
				return simbolo;
			}

		}

		return Simbolos.VACIO;

	}

	
	public Simbolos ganador() {

		Simbolos simbolo = coincidenciaLinea();

		if (simbolo != Simbolos.VACIO) {
		//ganador(simbolo, TIPO_LINEA);
		//return;
			return simbolo;
			
		}

		simbolo = coincidenciaColumna();

		if (simbolo != Simbolos.VACIO) {
		//ganador(simbolo, TIPO_COLUMNA);
	//	return;
			return simbolo;
		}

		simbolo = coincidenciaDiagonal();

		if (simbolo != Simbolos.VACIO) {
//			ganador(simbolo, TIPO_DIAGONAL);	
			return simbolo;			}
	//	return;
		return null;

	}

	/*
	public void ganador(Simbolos simbolo, int tipo) {

		
		switch(tipo) {
		case 1:	
				if (simbolo == Simbolos.X) {
					System.out.println("ha ganado el jugador 1 por linea");
				} else {
					System.out.println("ha ganado el jugador 2 por linea");
				}
			
			break;
		
		case 2:
				if (simbolo == Simbolos.X) {
					System.out.println("ha ganado el jugador 1 por columna");
				} else {
					System.out.println("ha ganado el jugador 2 por columna");
				}
			
			break;
			
		case 3:
				if (simbolo == Simbolos.X) {
					System.out.println("ha ganado el jugador 1 por diagonal");
				} else {
					System.out.println("ha ganado el jugador 2 por diagonal");
				}
			break;
			
		}
	}
	*/
	public void cambiarTurno() {
		this.turno = !turno;
		
	}
}  //end class


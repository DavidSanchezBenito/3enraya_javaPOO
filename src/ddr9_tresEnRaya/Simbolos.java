package ddr9_tresEnRaya;

public enum Simbolos {

	X('X'),
	O('O'),
	VACIO ('-');
	
	private char simbolo;

	private Simbolos(char simbolo) {
		this.simbolo = simbolo;
	}

	public char	getSimbolos() {  
		return simbolo;
	}
		
		
}

package pgn.examenMarzo.utiles;

/**
 * Crea y gestiona un men&uacute;
 * 
 * @author Estela Mu&ntilde;oz
 * @author Pedro J. Ramos
 * @version 1.0
 * 
 */

public class Menu {
	
	/**
	 * T&iacute;tulo del men&uacute;
	 */
	String titulo = null;
	
	/**
	 * Opciones del men&uacute;
	 */
	String opciones[] = null;
	
	/**
	 * N&uacute;mero de opciones del men&uacute;
	 */
	int numOpciones = 2;

	/**
	 * Constructor que crea un men&uacute;
	 * 
	 * @param titulo T&iacute;tulo del men&uacute;
	 * @param opciones Opciones del men&uacute;
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}

	/**
	 * Gestiona el men&uacute;
	 * 
	 * @return Opci&oacute;n elegida
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del men&uacute;
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Recoge la opci&oacute; escogida del men&uacute;
	 * 
	 * @return Opci&oacute;n elegida
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero();
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

}

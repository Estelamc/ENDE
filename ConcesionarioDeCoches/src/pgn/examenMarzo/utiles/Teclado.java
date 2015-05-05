package pgn.examenMarzo.utiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Interact&uacute;a con el usuario, 
 * leyendo lo que &eacute;ste escribe desde el teclado
 * 
 * @author Estela Mu&ntilde;oz
 * @author Pedro J. Ramos
 * @version 1.0
 */
public class Teclado {

	/**
	 * Lee un car&aacute;cter introducido por el usuario
	 * 
	 * @return Car&aacute;cter escrito
	 */
	public static char leerCaracter() {
		char caracter;
		try {
			caracter = leerCadena().charAt(0);
		} catch (Exception e) {
			caracter = 0;
		}
		return caracter;
	}

	/**
	 * Lee un car&aacute;cter introducido por el usuario
	 * 
	 * @param msj Texto que se muestra por pantalla
	 * @return Car&aacute;cter escrito
	 */
	public static char leerCaracter(String msj) {
		System.out.println(msj);
		return leerCaracter();
	}

	/**
	 * Lee una cadena de caracteres introducida por el usuario
	 * 
	 * @param msj Texto que se muestra por pantalla
	 * @return Cadena de caracteres escrita
	 */
	public static String leerCadena(String msj) {
		System.out.println(msj);
		return leerCadena();
	}

	/**
	 * Lee una cadena de caracteres escrita por el usuario
	 * 
	 * @return Cadena de caracteres escrita
	 */

	public static String leerCadena() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));
		String cadena;
		try {
			cadena = bReader.readLine(); // Lee una línea de texto (hasta intro)
		} catch (Exception e) {
			cadena = "";
		}
		return cadena;
	}

	/**
	 * Lee un n&uacute;mero entero introducio por el usuario
	 * 
	 * 
	 * @return Entero escrito
	 */
	public static int leerEntero() {
		int x;
		try {
			x = Integer.parseInt(leerCadena().trim()); // Quita los espacios del
														// String y convierte a
														// int
		} catch (Exception e) {
			x = 0;
		}
		return x;
	}

	/**
	 * Lee un n&uacute;mero entero introducido por el usuario
	 * 
	 * @param msj Texto que se muestra por pantalla
	 * @return Entero escrito
	 */
	public static int leerEntero(String msj) {
		System.out.println(msj);
		return leerEntero();
	}

	/**
	 * Lee un n&uacute;mero decimal introducido por el usuario
	 * 
	 * @return Decimal escrito
	 */
	public static double leerDecimal() {
		double x;
		try {
			x = Double.parseDouble(leerCadena().trim()); // Quita los espacios
															// del String y
															// convierte a
															// double
		} catch (Exception e) {
			x = 0;
		}
		return x;
	}

	/**
	 * Lee un n&uacute;mero decimal introducido por el usuario
	 * 
	 * @param msj Texto que se muestra por pantalla
	 * @return Decimal escrito
	 */
	public static double leerDecimal(String msj) {
		System.out.println(msj);
		return leerDecimal();
	}

}

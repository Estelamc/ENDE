package pgn.examenMarzo.concesionarioCoches;

import java.util.regex.Pattern;

/** 
 * Crea y manipula un coche
 * 
 * @author Estela Mu&ntilde;oz
 * @author Pedro J. Ramos
 * @version 1.0
 * 
 */

public class Coche {
	/**
	 * Matr&iacute;cula del coche, 
	 * que es un identificador inequ&iacute;voco de &eacute;ste.
	 */
	private String matricula;
	/**
	 * Color del coche
	 */
	private Color color;
	/**
	 * Modelo del coche
	 */
	private Modelo modelo;
	/**
	 * Patr&oacute;n para comprobar que la matr&iacute;cula es v&aacute;lida
	 */
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	/**
     * Constructor para crear un coche
     *
     * @param matricula Matr&iacute;cula del coche 
     * @param color Color del coche
     * @param modelo Modelo del coche
     */
	private Coche(String matricula, Color color, Modelo modelo) {
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Constructor que crea un coche s&oacute;lo con la matr&iacute;cula
	 * 
	 * @param matricula Matr&iacute;cula del coche
	 */
	private Coche(String matricula) {
		setMatricula(matricula);
	}

	/**
	 * Crea un coche
	 * 
	 * @param matricula Matr&iacute;cula del coche
	 * @param color Color del coche
	 * @param modelo Modelo del coche
	 * 
	 * @return El coche si la matr&iacute;cula es v&aacute;lida 
	 * y el color y el modelo no son nulos, o null en caso contrario
	 */
	static Coche instanciarCoche(String matricula, Color color, Modelo modelo) {
		if (esValida(matricula) && color != null && modelo != null)
			return new Coche(matricula, color, modelo);
		return null;
	}

	/**
	 * Crea un coche s&oacute;lo con la matr&iacute;cula
	 * 
	 * @param matricula Matr&iacute;cula del coche
	 * 
	 * @return El coche si la matr&iacute;cula es v&aacute;lida o null sino
	 */
	static Coche instanciarCoche(String matricula) {
		if (esValida(matricula))
			return new Coche(matricula);
		return null;
	}

	/**
	 * Comprueba si la matr&iacute;cula es v&aacute;lida
	 * 
	 * @param matricula Matr&iacute;cula del coche
	 * 
	 * @return True si la matr&iacute;cula es v&aacute;lida o false sino
	 */
	private static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}

	/**
	 * Modifica la matr&iacute;cula del coche
	 * 
	 * @param matricula Matr&iacute;cula del coche
	 */
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Devuelve el color del coche
	 * 
	 * @return Color del coche
	 */
	Color getColor() {
		return color;
	}

	/**
	 * Modifica el color del coche
	 * 
	 * @param color Color del coche
	 */
	private void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Modifica el modelo del coche
	 * 
	 * @param modelo Modelo del coche
	 */
	private void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * Calcula un valor num&eacute;rico &uacute;nico que
	 * definie a un coche en base a su matr&iacute;cula
	 * 
	 * @return Valor n&uacute;merico &uacute;nico para un 
	 * coche de matr&iacute;cula concreta 
	 */
	@Override
	public int hashCode() { // Se usa en el remove() de forma autom�tica
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Compara si dos coches tienen la misma matr&iacute;cula
	 * 
	 * @param obj Objeto a comparar
	 * 
	 * @return true si los coches coinciden 
	 * en la matr&iacute;cula o false sino
	 */
	@Override
	public boolean equals(Object obj) { // Se usa en el contains() de forma autom�tica
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Muestra el coche
	 * 
	 * @return El coche
	 */
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

}

package concesionario;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Crea otra versi&oacute;n de Concesionario de coches, ahora mediante excepciones. Las excepciones
 * que has de lanzar ser&aacute;n:
 * 		En coche:
 * 			MatriculaNoValidaException
 * 			ColorNoValidoException
 * 			ModeloNoValidoException
 * 		En Concesionario:
 * 			CocheNoExisteException
 *			CocheYaExisteException
 *
 * @author Estela Mu&ntilde;oz
 * @author Pedro J. Ramos
 * @version 1.0
 *
 */

public class Coche implements Serializable {
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 4634929412608767221L;
	/**
	 * Matr&iacute;cula del coche, que es un identificador inequ&iacute;voco de
	 * &eacute;ste.
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
	 * @param matricula
	 *            Matr&iacute;cula del coche
	 * @param color
	 *            Color del coche
	 * @param modelo
	 *            Modelo del coche
	 * @throws MatriculaNoValidaException
	 * @throws ColorNoValidoException
	 * @throws ModeloNoValidoException
	 */
	public Coche(String matricula, Color color, Modelo modelo)
			throws MatriculaNoValidaException, ColorNoValidoException,
			ModeloNoValidoException {
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Constructor que crea un coche s&oacute;lo con la matr&iacute;cula
	 * 
	 * @param matricula
	 *            Matr&iacute;cula del coche
	 * @throws MatriculaNoValidaException
	 */
	public Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	/**
	 * Comprueba si la matr&iacute;cula es v&aacute;lida
	 * 
	 * @param matricula
	 *            Matr&iacute;cula del coche
	 * 
	 * @return True si la matr&iacute;cula es v&aacute;lida o false sino
	 */
	public static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}

	/**
	 * Modifica la matr&iacute;cula del coche
	 * 
	 * @param matricula
	 *            Matr&iacute;cula del coche
	 * @throws MatriculaNoValidaException
	 */
	private void setMatricula(String matricula)
			throws MatriculaNoValidaException {
		if (esValida(matricula))
			this.matricula = matricula;
		else
			throw new MatriculaNoValidaException("La matr�cula no es v�lida");
	}

	/**
	 * Devuelve la matr&iacute;cula del coche
	 * 
	 * @return Matr&iacute;cula del coche
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Devuelve el color del coche
	 * 
	 * @return Color del coche
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Modifica el color del coche
	 * 
	 * @param color
	 *            Color del coche
	 * @throws ColorNoValidoException
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if (color != null)
			this.color = color;
		else
			throw new ColorNoValidoException("El color no es v�lido");
	}

	/**
	 * Modifica el modelo del coche
	 * 
	 * @param modelo
	 *            Modelo del coche
	 * @throws ModeloNoValidoException
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo != null)
			this.modelo = modelo;
		else
			throw new ModeloNoValidoException("El modelo no es v�lido");
	}

	/**
	 * Calcula un valor num&eacute;rico &uacute;nico que definie a un coche en
	 * base a su matr&iacute;cula
	 * 
	 * @return Valor n&uacute;merico &uacute;nico para un coche de
	 *         matr&iacute;cula concreta
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
	 * @param obj
	 *            Objeto a comparar
	 * 
	 * @return true si los coches coinciden en la matr&iacute;cula o false sino
	 */
	@Override
	public boolean equals(Object obj) { // Se usa en el contains() de forma
										// autom�tica
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

	/**
	 * Devuelve el modelo del coche
	 *  
	 * @return Modelo del coche
	 */
	public Modelo getModelo() {
		return modelo;
	}

}

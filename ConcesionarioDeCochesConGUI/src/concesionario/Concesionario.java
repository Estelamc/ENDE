package concesionario;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Gestiona el concesionario de coches.
 *
 * @author Estela Mu&ntilde;oz
 * @version 1.0
 *
 */

public class Concesionario implements Serializable{
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n
	 */
	private static final long serialVersionUID = -5042099624350455082L;
	/**
	 * Lista de coches almacenados en el concesionario (almac&eacute;n)
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capitán";
	/**
	 * Indica si el concesionado ha sido modificado.
	 */
	private boolean modificado = true;
	
	// ----------------------------------- NUESTROS MÉTODOS ----------------------------------- \\
	
	/**
	 * Devuelve si el concesionario ha sido modificado o no.
	 * 
	 * @return Si el concesionario ha sido modificado o no
	 */
	public boolean isModificado() {
		return modificado;
	}

	/**
	 * Cambia si está modificado o no
	 * 
	 * @param modificado Estado que indica que el concesionario ha sido modificado
	 */
	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	/**
	 * A&ntilde;ade un coche al almac&eacute;n del concesionario
	 * 
	 * @param matricula
	 *            Matr&iacute;cula del coche
	 * @param color
	 *            Color del coche
	 * @param modelo
	 *            Modelo del coche
	 * 
	 * @return True si a&ntilde;ade el coche o false si es nulo o ya existe
	 * @throws ModeloNoValidoException
	 * @throws ColorNoValidoException
	 * @throws CocheYaExisteException
	 */
	public boolean annadir(String matricula, Color color, Modelo modelo)throws MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException, CocheYaExisteException {
		Coche coche = new Coche(matricula, color, modelo);
		if (almacen.contains(coche))
			throw new CocheYaExisteException("El coche ya existe en el concesionario");
		setModificado(true);
		return almacen.add(coche);
	}

	/**
	 * Elimina un coche del almac&eacute;n del concesionario
	 * 
	 * @param matricula
	 *            Matr&iacute;cula del coche
	 * 
	 * @return true si lo elimina y false sino
	 */
	public boolean eliminar(String matricula) throws MatriculaNoValidaException {
		Coche coche = new Coche(matricula);
		setModificado(true);
		return almacen.remove(coche);
	}

	/**
	 * Cantidad de coches que hay en el almac&eacute;n del concesionario
	 * 
	 * @return Cantidad de coches del almac&eacute;n
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve un coche del almac&eacute;n busc&aacute;ndolo por su
	 * matr&iacute;cula
	 * 
	 * @param matricula
	 *            Matr&iacute;cula del coche a buscar
	 * 
	 * @return Coche encontrado o null si no existe
	 * @throws CocheNoExisteException 
	 * @throws MatriculaNoValidaException 
	 */
	public Coche get(String matricula) throws CocheNoExisteException, MatriculaNoValidaException {
		Coche coche = new Coche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		else
			throw new CocheNoExisteException("El coche no existe en el concesionario");
	}

	/**
	 * Muestra el concesionario de coches
	 * 
	 * @return El concesionario de coches
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}

	/**
	 * Devuelve los coches de un solo color
	 * 
	 * @param color Color del coche
	 * 
	 * @return Coches del mismo color
	 */
	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if (coche.getColor() == color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}
	
	/**
	 * Devuelve el coche de acuerdo a un &iacute;ndice
	 * 
	 * @param index &Iacute;ndice
	 * @return El coche
	 */
	public Coche get(int index) {
		if(almacen.isEmpty())
			return null;
		if(index < 0 | index > almacen.size()-1)
			return null;
		return almacen.get(index);
	}
}

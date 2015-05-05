package pgn.examenMarzo.concesionarioCoches;

import java.util.ArrayList;

/*
 * No pueden existir dos coches con la misma matrícula en el almacén del concesinario
 * no puede añadirse un coche al concecionario con alguno de sus atributos inválidos. Han de conocerse todas sus características 
 * Ninguno de los valores puede ser por defecto
 */

/**
 * Crea y manipula el concesionario de coches &quot;IES Gran Capit&aacute;n&quot;
 * 
 * @author Estela Mu&ntilde;oz
 * @author Pedro J. Ramos
 * @version 1.0
 *
 */

public class Concesionario {
	/**
	 * Lista de coches almacenados en el concesionario (almac&eacute;n)
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capitán";

	/**
	 * A&ntilde;ade un coche al almac&eacute;n del concesionario
	 * 
	 * @param matricula Matr&iacute;cula del coche
	 * @param color Color del coche
	 * @param modelo Modelo del coche
	 * 
	 * @return True si a&ntilde;ade el coche o false si es nulo o ya existe
	 */
	boolean annadir(String matricula, Color color, Modelo modelo) {
		Coche coche = Coche.instanciarCoche(matricula, color, modelo);
		if (coche == null || almacen.contains(coche))
			return false;
		return almacen.add(coche);
	}

	/**
	 * Elimina un coche del almac&eacute;n del concesionario
	 * 
	 * @param matricula Matr&iacute;cula del coche
	 * 
	 * @return true si lo elimina y false sino
	 */
	boolean eliminar(String matricula) {
		return almacen.remove(Coche.instanciarCoche(matricula));
	}

	/**
	 * Cantidad de coches que hay en el almac&eacute;n del concesionario
	 * 
	 * @return Cantidad de coches del almac&eacute;n
	 */
	int size() {
		return almacen.size();
	}

	/**
	 * Devuelve un coche del almac&eacute;n busc&aacute;ndolo por su matr&iacute;cula
	 * 
	 * @param matricula Matr&iacute;cula del coche a buscar
	 * 
	 * @return Coche encontrado o null si no existe
	 */
	Coche get(String matricula) {
		Coche coche = Coche.instanciarCoche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		return null;
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
			if(coche.getColor()== color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}

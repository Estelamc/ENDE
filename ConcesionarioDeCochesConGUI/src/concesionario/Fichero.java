package concesionario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase para gestionar ficheros.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Fichero {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Archivo para guardar un objeto (concesionario).
	 */
	public static File archivo = new File("Sin_titulo");
	/**
	 * Ventana para gestionar archivos.
	 */
	private static JFileChooser ventanaSeleccion = new JFileChooser();	
	/**
	 * Filtro para seleccionar archivos de tipo objeto.
	 */
	private final static FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos OBJ", "obj");
	
	
	// ----------------------------------- NUESTROS MÉTODOS ----------------------------------- \\
	
	/**
	 * Modifica el nombre del fichero.
	 * 
	 * @param nombreArchivo Nombre del archivo que deseamos poner
	 */
	public static void setArchivo(String nombreArchivo){
		archivo = new File(nombreArchivo + ".obj");
	}
	
	/**
	 * Crea un nuevo archivo.
	 * 
	 * @param archivo Fichero nuevo
	 */
	public static void nuevoArchivo(File archivo){
		// Si el archivo previo ha sido modificado, me lo guarda
		if(General.concesionario.isModificado()){
			guardarArchivo(archivo, General.concesionario);
		}
		// Después de guardarlo (si es que es necesario) crea uno nuevo
		Fichero.archivo = new File ("Sin_titulo.obj"); // Machaca el archivo nuevo para empezar desde 0
		General.concesionario = new Concesionario(); // Crea un concesionario
		General.concesionario.setModificado(false);
	}
	
	/**
	 * Abre un fichero.
	 * 
	 * @param archivo Fichero a abrir
	 * 
	 * @return Fichero seleccionado
	 * 
	 * @throws FileNotFoundException Error por no encontrarse el archivo
	 * @throws IOException Error por un fallo o interrupci&oacute;n en la entrada o salida de datos
	 * @throws ClassNotFoundException Error cuando el archivo no es de la clase buscada
	 * @throws FicheroCorruptoException Error al estar el archivo da&ntilde;ado
	 */
	public static Concesionario abrirArchivo(File archivo) throws FileNotFoundException, IOException, 
	ClassNotFoundException, FicheroCorruptoException {
		// Se añade el filtro
		ventanaSeleccion.setFileFilter(filtro);
		int opcionAbrir = ventanaSeleccion.showOpenDialog(new JFileChooser()); //new JFileChooser antes en vez de panelContenedor -- Funciona con ambos
		// Si funciona correctamente
		if(opcionAbrir == JFileChooser.APPROVE_OPTION) { 
			// El archivo será el seleccionado - Se reemplaza el que estuviera por el que se quiere abrir
			Fichero.archivo = ventanaSeleccion.getSelectedFile();
			// Le añadimos la extensión correcta por si acaso
			archivo = annadirExtension(archivo); 
			try (ObjectInputStream objetoEntrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream(
				archivo)))) {
				// Nos lee nuestro archivo
				return (Concesionario) objetoEntrada.readObject(); 
			}catch (StreamCorruptedException e) {
				// En caso de que esté dañado nuestro archivo
				throw new FicheroCorruptoException("Fichero corrupto."); 
			}	
		}
		General.concesionario.setModificado(false); 
		ventanaSeleccion.setSelectedFile(Fichero.archivo); // Modifica el nombre de la ventana por 
															// el nombre del archivo seleccionado
		return null;
	}	
	
	/**
	 * Guarda un fichero
	 * 
	 * @param archivo Archivo donde vamos a guardar
	 * @param concesionario Concesionario a guardar
	 * @throws IOException Excepci&oacute;n por un fallo o interrupci&oacute;n en la entrada o salida de datos
	 */
	public static void guardarArchivo(File archivo, Concesionario concesionario)
			throws IOException {
		// Se añade el filtro
		ventanaSeleccion.setFileFilter(filtro);
		int opcionGuardar = ventanaSeleccion.showSaveDialog(new JFileChooser());
		if(opcionGuardar == JFileChooser.APPROVE_OPTION){
			archivo = ventanaSeleccion.getSelectedFile();
			try {
				guardarArchivo(archivo, General.concesionario);
			} catch (IOException e) {
				e.printStackTrace();
			}
			General.concesionario.setModificado(false); 
			ventanaSeleccion.setSelectedFile(Fichero.archivo);
		}
	/*	archivo = annadirExtension(archivo);
		try (ObjectOutputStream objetoSalida = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(archivo, false)))) { // no añade, machaca el fichero
			objetoSalida.writeObject(concesionario);
		}*/
	}

	/*
	 * JFileChooser guardar = new JFileChooser();
				int opcionGuardar = guardar.showSaveDialog(frame);
				if (opcionGuardar == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardarArchivo(file, General.concesionario);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					General.concesionario.setModificado(false);
					setSelectedFile(file);
				} 
	 */
	
	/**
	 * A&ntilde;ade una extensi&oacute;n espec&iacute;fica al archivo
	 * 
	 * @param archivo Fichero al que se le a&ntilde;ade la extensi&oacute;n
	 * @return Archivo con la extensi&oacute;n a&ntilde;adida
	 */
	public static File annadirExtension(File archivo) {
		String extension = archivo.getPath();
		if (!extension.endsWith(".obj"))
			return new File(archivo + ".obj");
		return archivo;
	}

	/**
	 * Comprueba si el archivo existe ya o no
	 * 
	 * @param archivo Fichero a comprobar
	 * @return True si el archivo existe o False sino
	 */
	public static boolean confirmarSiExiste(File archivo) {
		archivo = annadirExtension(archivo);
		return archivo.exists();
	}
}

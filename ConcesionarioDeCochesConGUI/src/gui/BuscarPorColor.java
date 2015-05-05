package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import concesionario.Color;
import concesionario.General;

/**
 * Busca un coche en el concesionario por su color.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class BuscarPorColor extends VentanaPadre {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -7467876018442480591L;

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\

	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			BuscarPorColor dialog = new BuscarPorColor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public BuscarPorColor() {
		super();
		setResizable(false);
		setModal(true);
		// Ponemos todos los campos, menos los colores, no editables
		modeloComboBox.setEnabled(false);
		marcaComboBox.setEnabled(false);
		matriculaCampo.setEnabled(false);
	
		setTitle("Buscar coche por el color"); // Se modifica el título de la ventana
		botonOK.setText("Buscar"); // Se modifica el texto del botón OK
		// Añade una acción al botón Buscar
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getCoche(matriculaCampo, panelContenedor, marcaComboBox, modeloComboBox, colorAzul, colorPlata, colorRojo);  
				General.concesionario.getCochesColor(getColor());
			}
		});
	}
	
	/**
	 * Devuelve el color seleccionado.
	 * 
	 * @return Color elegido.
	 */
	private Color getColor() {
		if (colorAzul.isSelected())
			return concesionario.Color.AZUL;
		else if (colorPlata.isSelected())
			return concesionario.Color.PLATA;
		else if (colorRojo.isSelected())
			return concesionario.Color.ROJO;
		else
			return null;
	}
	
	/**
	 * Muestra el coche si existe o sino informa de que no existe
	 */
	/*private static void getCoche(JTextField matriculaCampo, JPanel panelContenedor, 
			JComboBox marcaComboBox, JComboBox modeloComboBox, JRadioButton colorAzul, 
			JRadioButton colorPlata, JRadioButton colorRojo) {
		Coche coche = null;
		try {
			// Obtiene un coche del concesionario por su matrícula y de él obtiene el resto de campos
			coche = General.concesionario.get(matriculaCampo.getText());
			matriculaCampo.setText(coche.getMatricula());
			marcaComboBox.setSelectedItem(coche.getModelo().getMarca());
			modeloComboBox.setSelectedItem(coche.getModelo());
			switch (coche.getColor()) {
				case AZUL:
					colorAzul.setSelected(true);
					break;
				case PLATA:
					colorPlata.setSelected(true);
					break;
				case ROJO:
					colorRojo.setSelected(true);
			}
			JOptionPane.showMessageDialog(panelContenedor, "Coche encontrado con éxito.", "Acción realizada", JOptionPane.INFORMATION_MESSAGE);
		} catch (CocheNoExisteException | MatriculaNoValidaException e) {
			JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
*/
}

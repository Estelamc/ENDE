package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import concesionario.Coche;
import concesionario.CocheNoExisteException;
import concesionario.General;
import concesionario.MatriculaNoValidaException;

/**
 * Busca un coche en el concesionario por su matr&iacute;cula
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class BuscarPorMatricula extends VentanaPadre {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -6351036634148204657L;

	
	// ----------------------------------- NUESTRA APLICACI�N ----------------------------------- \\

	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			BuscarPorMatricula dialog = new BuscarPorMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public BuscarPorMatricula() {
		super();
		setModal(true);
		setResizable(false);
		// Ponemos todos los campos, menos la matr�cula, no editables
		modeloComboBox.setEnabled(false);
		marcaComboBox.setEnabled(false);
		colorRojo.setEnabled(false);
		colorPlata.setEnabled(false);
		colorAzul.setEnabled(false);
		// Acci�n cuando se est� dentro del campo de la matr�cula
		matriculaCampo.addFocusListener(new FocusAdapter() {
			// Mientras se escriba en el campo de matr�cula, la letra ser� de color negro
			@Override
			public void focusGained(FocusEvent arg0) {
				matriculaCampo.setForeground(java.awt.Color.BLACK);
			}
			// Si al salir del campo de matr�cula �sta es inv�lida, se pone la letra de color rojo
			@Override
			public void focusLost(FocusEvent e) {
				if(!Coche.esValida(matriculaCampo.getText()))
					matriculaCampo.setForeground(java.awt.Color.RED);
			}
		});
		setTitle("Buscar coche"); // Se modifica el t�tulo de la ventana
		botonOK.setText("Buscar"); // Se modifica el texto del bot�n OK
		// A�ade una acci�n al bot�n Buscar
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCoche(matriculaCampo, panelContenedor, marcaComboBox, modeloComboBox, colorAzul, colorPlata, colorRojo);      
			}
		});
	}
	
	/**
	 * Muestra el coche si existe o sino informa de que no existe
	 */
	private static void getCoche(JTextField matriculaCampo, JPanel panelContenedor, 
			JComboBox marcaComboBox, JComboBox modeloComboBox, JRadioButton colorAzul, 
			JRadioButton colorPlata, JRadioButton colorRojo) {
		Coche coche = null;
		try {
			// Obtiene un coche del concesionario por su matr�cula y de �l obtiene el resto de campos
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
			JOptionPane.showMessageDialog(panelContenedor, "Coche encontrado con �xito.", "Acci�n realizada", JOptionPane.INFORMATION_MESSAGE);
		} catch (CocheNoExisteException | MatriculaNoValidaException e) {
			JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
package gui;

import java.awt.event.ActionListener;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import concesionario.Coche;
import concesionario.General;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

/**
 * Muestra todos los coches del concesionario.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class MostrarStock extends VentanaPadre {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 2435359341555777067L;
	
	/**
	 * Bot&oacute;n Anterior.
	 */
	JButton botonAnterior = new JButton("<");
	
	/**
	 * Bot&oacute;n Siguiente.
	 */
	JButton botonSiguiente = new JButton(">");

	/**
	 * &Iacute;ndice identificador del coche para 
	 * tener una referencia para saber si podemos
	 * seguir adelante o para atrás o ya no hay m&aacute;s
	 * coches que mostrar.*-
	 */
	private int indiceCoche = -1;

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\

	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			MostrarStock dialog = new MostrarStock();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public MostrarStock() {
		super();
		setModal(true);
		setResizable(false);
		
		// Ponemos todos los campos no editables
		matriculaCampo.setEnabled(false);
		colorRojo.setEnabled(false);
		colorPlata.setEnabled(false);
		colorAzul.setEnabled(false);
		modeloComboBox.setEnabled(false);
		marcaComboBox.setEnabled(false);
		botonOK.setEnabled(false);
		// Ponemos el botón OK no visible
		botonOK.setVisible(false);
		
		setTitle("Mostrar concesionario"); // Se modifica el título de la ventana
		botonAnterior.addActionListener(new ActionListener() {
			// Añade una acción al botón Anterior (<)
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		
		// Botón Anterior
		botonesPanel.add(botonAnterior);
		botonSiguiente.addActionListener(new ActionListener() {
			// Añade una acción al botón Siguiente (>)
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		actualizar();
		
		// Botón Siguiente
		botonesPanel.add(botonSiguiente);		
		botonesPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{botonAnterior, botonSiguiente, botonOK, botonSalir}));
	}
	
	/**
	 * Muestra el coche siguiente.
	 */
	private void mostrarSiguiente() {
		mostrarCoche(General.concesionario.get(++indiceCoche));
		comprobarBotones();
	}
	
	/**
	 * Muestra el coche anterior.
	 */
	private void mostrarAnterior() {
		mostrarCoche(General.concesionario.get(--indiceCoche));
		comprobarBotones();
	}
	
	/**
	 * Muestra el coche
	 * 
	 * @param coche Coche del concesionario
	 */
	private void mostrarCoche(Coche coche) {
		matriculaCampo.setText(coche.getMatricula());
		switch (coche.getColor()) {
			case PLATA:
				colorPlata.setSelected(true);
				break;
			case ROJO:
				colorRojo.setSelected(true);
				break;
			case AZUL:
				colorAzul.setSelected(true);
		}
		marcaComboBox.addItem(coche.getModelo().getMarca());
		marcaComboBox.setSelectedItem(coche.getModelo().getMarca());
		modeloComboBox.addItem(coche.getModelo());
		modeloComboBox.setSelectedItem(coche.getModelo());
		panelContenedor.setLayout(null);
				
	}
	
	/**
	 * Vuelve a empezar desde cero.
	 */
	void actualizar() {
		if (General.concesionario.size() == 0) {
			return;
		}
		indiceCoche = 0;
		mostrarCoche(General.concesionario.get(indiceCoche));
		comprobarBotones();		
	}
	
	/**
	 * Comprueba que los botones han de estar activos
	 * (si se ha llegado al final o al principio, no sigue)
	 */
	private void comprobarBotones() {
		if (General.concesionario.get(indiceCoche + 1) == null)
			botonAnterior.setEnabled(false);
		else
			botonSiguiente.setEnabled(true);

		if (General.concesionario.get(indiceCoche - 1) == null)
			botonAnterior.setEnabled(false);
		else
			botonAnterior.setEnabled(true);
	}
	
}
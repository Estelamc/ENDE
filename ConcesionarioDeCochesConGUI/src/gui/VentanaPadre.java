package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import concesionario.Marca;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import concesionario.Modelo;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Ventana de di&aacute;logo con la que gestionamos el concesionario.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class VentanaPadre extends JDialog {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n de serie predeterminado.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Panel que contiene los elementos de la ventana.
	 */
	protected final JPanel panelContenedor = new JPanel();
	
	// --------- Matrícula --------- \\
	/**
	 * Etiqueta para la matr&iacute;cula del coche.
	 */
	protected JLabel matriculaEtiqueta = new JLabel("Matr\u00EDcula");
	/**
	 * Campo para escribir la matr&iacute;cula del coche.
	 */
	protected JTextField matriculaCampo;
	
	// --------- Botones Salir y OK --------- \\
	/**
	 * Panel que contiene los botones para realizar las acciones.
	 */
	protected JPanel botonesPanel = new JPanel();
	/**
	 * Bot&oacute;n de OK (para realizar la acci&oacute;n).
	 */
	protected JButton botonOK = new JButton("OK");
	/**
	 * Bot&oacute;n de Salir para cerrar la ventana.
	 */
	protected JButton botonSalir = new JButton("Salir");
	
	// --------- Colores --------- \\
	/**
	 * Panel que contiene los colores disponibles para un coche.
	 */
	protected JPanel colorPanel = new JPanel();
	/**
	 * Grupo de botones que recoge los diferentes colores disponibles
	 * para un coche.
	 */
	protected final ButtonGroup colorGrupo = new ButtonGroup();
	/**
	 * Color Azul para el coche.
	 */
	protected JRadioButton colorAzul = new JRadioButton("Azul");
	/**
	 * Color Plata para el coche.
	 */
	protected JRadioButton colorPlata = new JRadioButton("Plata");
	/**
	 * Color Rojo para el coche.
	 */
	protected JRadioButton colorRojo = new JRadioButton("Rojo");
	
	// ---------- ComboBox marca y modelo --------- \\
	/**
	 * Etiqueta para la marca del coche.
	 */
	protected JLabel marcaEtiqueta = new JLabel("Marca");
	/**
	 * Etiqueta para el modelo del coche
	 */
	protected JLabel modeloEtiqueta = new JLabel("Modelo");
	/**
	 * Lista de marcas disponibles para elegir.
	 */
	protected JComboBox<Marca> marcaComboBox = new JComboBox<Marca>();
	/**
	 * Lista de modelos disponibles para elegir.
	 */
	protected JComboBox modeloComboBox = new JComboBox(getModelo(marcaComboBox));

	//protected JButton anterior = new JButton("<");
		//protected JButton siguiente = new JButton(">");
	/*
	protected JList list = new JList();*/
	
	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			// Se crea el Diálogo de Alta
			VentanaPadre dialog = new VentanaPadre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public VentanaPadre() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 323, 253);
		getContentPane().setLayout(new BorderLayout());
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelContenedor, BorderLayout.CENTER);
		panelContenedor.setLayout(null);
		
		// Campo matrícula
		matriculaCampo = new JTextField();
		matriculaCampo.setColumns(10);
		matriculaCampo.setBounds(116, 11, 165, 20);
		panelContenedor.add(matriculaCampo);
		
		// Etiqueta matrícula
		matriculaEtiqueta.setBounds(23, 14, 80, 14);
		panelContenedor.add(matriculaEtiqueta);
		
		// Panel de colores
		colorPanel.setLayout(null);
		colorPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Color", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		colorPanel.setBounds(23, 57, 121, 108);
		panelContenedor.add(colorPanel);
		
		// Color Azul
		colorAzul.setForeground(new Color(0, 0, 128));
		colorAzul.setFont(new Font("Tahoma", Font.BOLD, 11));
		colorAzul.setBounds(6, 16, 109, 23);
		colorPanel.add(colorAzul);
		colorGrupo.add(colorAzul);
		
		// Color Plata
		colorPlata.setForeground(SystemColor.controlDkShadow);
		colorPlata.setFont(new Font("Tahoma", Font.BOLD, 11));
		colorPlata.setBounds(6, 42, 109, 23);
		colorPanel.add(colorPlata);
		colorGrupo.add(colorPlata);
		
		// Color Rojo
		colorRojo.setForeground(new Color(165, 42, 42));
		colorRojo.setFont(new Font("Tahoma", Font.BOLD, 11));
		colorRojo.setBounds(6, 68, 109, 23);
		colorPanel.add(colorRojo);
		colorGrupo.add(colorRojo);
		
		// Etiqueta marca
		marcaEtiqueta.setBounds(201, 57, 46, 14);
		panelContenedor.add(marcaEtiqueta);
		marcaComboBox.addItemListener(new ItemListener() {
			// Sincroniza los modelos disponibles acorde a la marca elegida
			public void itemStateChanged(ItemEvent e) {
				modeloComboBox.setModel(new DefaultComboBoxModel(getModelo(marcaComboBox)));
			}
		});
		
		// ComboBox marca
		marcaComboBox.setModel(new DefaultComboBoxModel(Marca.values()));
		marcaComboBox.setBounds(201, 76, 80, 27);
		panelContenedor.add(marcaComboBox);
		
		// Etiqueta modelo
		modeloEtiqueta.setBounds(201, 114, 46, 14);
		panelContenedor.add(modeloEtiqueta);
		
		// ComboBox modelo
		modeloComboBox.setModel(new DefaultComboBoxModel(Modelo.values()));
		modeloComboBox.setBounds(201, 138, 80, 27);
		panelContenedor.add(modeloComboBox);
		{
			// Panel de botones
			botonesPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(botonesPanel, BorderLayout.SOUTH);
			{
				// Botón OK
				botonOK.setActionCommand("OK");
				botonesPanel.add(botonOK);
				getRootPane().setDefaultButton(botonOK);
			}
			{
				// Botón Salir
				// Añadimos una acción al botón Salir
				botonSalir.addActionListener(new ActionListener() {
					// Cierra la ventana
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				botonSalir.setActionCommand("Cancel");
				botonesPanel.add(botonSalir);
			}
		}
	}
	
	/**
	 * Genera la lista contenida en el ComboBox de modelo,
	 * con todos los modelos disponibles seg&uacute;n la
	 * marca seleccionada.
	 * 
	 * @param marcaComboBox ComboBox de marca (marcas disponibles).
	 * @return Modelos disponibles seg&uacute;n la marca seleccionada.
	 */
	private Object[] getModelo(JComboBox<Marca> marcaComboBox) {
		Marca marca = (Marca) marcaComboBox.getSelectedItem();
		ArrayList<Modelo> listaModelos = new ArrayList<Modelo>();
		for (Modelo modelo : Modelo.values()) {
			if (modelo.getMarca() == marca) {
				listaModelos.add(modelo);
			}
		}
		return listaModelos.toArray();
	}
	
}

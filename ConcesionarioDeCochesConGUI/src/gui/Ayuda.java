package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Contiene informaci&oacute;n que puede servir de ayuda para el manejo del programa.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Ayuda extends JDialog {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 7496760684131528000L;
	
	/**
	 * Panel contenedor que contiene los elementos de la ventana.
	 */
	private final JPanel contentPanel = new JPanel();

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public Ayuda() {
		setResizable(false);
		setModal(true);
		setTitle("Ayuda");
		setBounds(100, 100, 533, 570);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Etiqueta Alta
		JLabel lblAlta = new JLabel("Alta");
		lblAlta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlta.setForeground(new Color(102, 51, 102));
		lblAlta.setBounds(39, 26, 70, 20);
		contentPanel.add(lblAlta);
		
		// Etiqueta Baja
		JLabel lblBaja = new JLabel("Baja");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBaja.setForeground(new Color(102, 51, 102));
		lblBaja.setBounds(39, 156, 46, 14);
		contentPanel.add(lblBaja);
		
		// Etiqueta Buscar por matrícula
		JLabel lblBuscarPorMatrcula = new JLabel("Buscar por matr\u00EDcula");
		lblBuscarPorMatrcula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscarPorMatrcula.setForeground(new Color(102, 51, 102));
		lblBuscarPorMatrcula.setBounds(39, 231, 165, 14);
		contentPanel.add(lblBuscarPorMatrcula);
		
		// Etiqueta Buscar por color
		JLabel lblBuscarPorColor = new JLabel("Buscar por color");
		lblBuscarPorColor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscarPorColor.setForeground(new Color(102, 51, 102));
		lblBuscarPorColor.setBounds(39, 294, 141, 14);
		contentPanel.add(lblBuscarPorColor);
		
		// Etiqueta Mostrar Stock
		JLabel lblMostrarStock = new JLabel("Mostrar stock");
		lblMostrarStock.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMostrarStock.setForeground(new Color(102, 51, 102));
		lblMostrarStock.setBounds(39, 349, 200, 14);
		contentPanel.add(lblMostrarStock);
		
		// Etiqueta Stock Total
		JLabel lblStockTotal = new JLabel("Stock total");
		lblStockTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStockTotal.setForeground(new Color(102, 51, 102));
		lblStockTotal.setBounds(39, 405, 121, 14);
		contentPanel.add(lblStockTotal);
		
		// Panel de texto para Añadir Coche
		JTextPane txtpnAadeUnCoche = new JTextPane();
		txtpnAadeUnCoche.setBackground(SystemColor.control);
		txtpnAadeUnCoche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnAadeUnCoche.setText("A\u00F1ade un coche al concesionario, seleccionando cu\u00E1l ser\u00E1 su color, su modelo, \r\nsu marca y su matr\u00EDcula. Para poder a\u00F1adirlo la matr\u00EDcula deber ser v\u00E1lida.\r\n\r\nLa matr\u00EDcula ser\u00E1 \u00FAnica, por lo que no podr\u00E1 haber otro coche con la misma matr\u00EDcula. \r\nPara que sea v\u00E1lida deber\u00E1 constar de cuatro d\u00EDgitos, seguidos de tres letras de la A a la Z. Entre los d\u00EDgitos y las letr\u00E1s podr\u00E1 haber un gui\u00F3n.");
		txtpnAadeUnCoche.setBounds(39, 58, 452, 88);
		contentPanel.add(txtpnAadeUnCoche);
		
		// Panel de texto para Eliminar Coche
		JTextPane txtpnEliminaUnCoche = new JTextPane();
		txtpnEliminaUnCoche.setBackground(SystemColor.control);
		txtpnEliminaUnCoche.setForeground(Color.BLACK);
		txtpnEliminaUnCoche.setText("Elimina un coche del concesionario cuando coincide la matr\u00EDcula introducida con uno existente.");
		txtpnEliminaUnCoche.setBounds(39, 182, 452, 34);
		contentPanel.add(txtpnEliminaUnCoche);
		
		// Panel de texto para Buscar un coche
		JTextPane txtpnBuscaUnCoche = new JTextPane();
		txtpnBuscaUnCoche.setBackground(SystemColor.control);
		txtpnBuscaUnCoche.setForeground(Color.BLACK);
		txtpnBuscaUnCoche.setText("Busca un coche cuya matr\u00EDcula coincida con la introducida y lo muestra.");
		txtpnBuscaUnCoche.setBounds(39, 257, 452, 27);
		contentPanel.add(txtpnBuscaUnCoche);
		
		// Panel de texto para Buscar coches de un color
		JTextPane txtpnBuscaTodosLos = new JTextPane();
		txtpnBuscaTodosLos.setBackground(SystemColor.control);
		txtpnBuscaTodosLos.setForeground(Color.BLACK);
		txtpnBuscaTodosLos.setText("Busca todos los coches que tengan el color elegido y los muestra.");
		txtpnBuscaTodosLos.setBounds(39, 319, 452, 20);
		contentPanel.add(txtpnBuscaTodosLos);
		
		// Panel de texto para Mostrar todos los coches
		JTextPane txtpnMuestraTodosLos = new JTextPane();
		txtpnMuestraTodosLos.setBackground(SystemColor.control);
		txtpnMuestraTodosLos.setForeground(Color.BLACK);
		txtpnMuestraTodosLos.setText("Muestra todos los coches existentes en el concesionario.");
		txtpnMuestraTodosLos.setBounds(39, 368, 452, 27);
		contentPanel.add(txtpnMuestraTodosLos);
		
		// Panel de texto para Mostrar cantidad de coches
		JTextPane txtpnMuestraLaCantidad = new JTextPane();
		txtpnMuestraLaCantidad.setBackground(SystemColor.control);
		txtpnMuestraLaCantidad.setForeground(Color.BLACK);
		txtpnMuestraLaCantidad.setText("Muestra la cantidad total de coches que hay en el concesionario.");
		txtpnMuestraLaCantidad.setBounds(39, 429, 452, 27);
		contentPanel.add(txtpnMuestraLaCantidad);
		{
			// Botón OK
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				// Se sale de la ventana
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			okButton.setBounds(223, 483, 70, 27);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
	}
}

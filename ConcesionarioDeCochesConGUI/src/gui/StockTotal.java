package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import concesionario.General;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockTotal extends JDialog {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\

	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 1531130519545859953L;
	
	/**
	 * Panel que contiene los elementos de la ventana.
	 */
	private final JPanel panelContenedor = new JPanel();
	
	/**
	 * Campo de de texto paa el Stock del concesionario.
	 */
	private JTextPane stockPanelTexto = new JTextPane();
	
	/**
	 * Bot&oacute;n Ok
	 */
	private JButton botonOK = new JButton("OK");

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			StockTotal dialog = new StockTotal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *Crea el di&aacute;logo.
	 */
	public StockTotal() {
		setResizable(false);
		setModal(true);
		int cantidadCoches = General.concesionario.size();
		
		setTitle("Stock disponible");
		setBounds(100, 100, 396, 197);
		getContentPane().setLayout(new BorderLayout());
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelContenedor, BorderLayout.CENTER);
		panelContenedor.setLayout(null);
		stockPanelTexto.setBounds(54, 49, 272, 39);
		stockPanelTexto.setBackground(SystemColor.control);
		stockPanelTexto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stockPanelTexto.setText("En el concesionario hay " +cantidadCoches+ " coches.");
		panelContenedor.add(stockPanelTexto);
		{
			botonOK.setBounds(159, 119, 61, 29);
			// Botón OK
			// Añade una acción al botón OK
			botonOK.addActionListener(new ActionListener() {
				// Se sale de la ventana
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			botonOK.setActionCommand("OK");
			panelContenedor.add(botonOK);
		}
	}
}

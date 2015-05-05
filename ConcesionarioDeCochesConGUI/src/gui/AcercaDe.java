package gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Contiene informaci&oacute;n sobre el programa.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class AcercaDe extends JDialog {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de la versi&oacute;n.
	 */
	private static final long serialVersionUID = -8366563078223223981L;
	
	/**
	 * Panel contenedor de los elementos de la ventana.
	 */
	private final JPanel contentPanel = new JPanel();

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			AcercaDe dialog = new AcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public AcercaDe() {
		setModal(true);
		setResizable(false);
		setTitle("Acerca de");
		setBounds(100, 100, 437, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			// Panel de desplazamiento
			JScrollPane PanelDesplazamiento = new JScrollPane();
			PanelDesplazamiento.setBounds(56, 164, 308, 156);
			contentPanel.add(PanelDesplazamiento);
			{
				// Área de texto
				JTextArea informacionTexto = new JTextArea();
				informacionTexto.setBackground(SystemColor.control);
				informacionTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
				informacionTexto.setText("Este programa servir\u00E1 para la gesti\u00F3n\r\nde un concesionario, de modo que\r\npodamos dar de alta o de baja diversos\r\ncoches; as\u00ED como mostrar todos los\r\nexistentes hasta el momento, o buscar\r\nuno concreto por matr\u00EDcula o buscar\r\nlos que hubiese de un determinado color.\r\n\r\nLos coches dispondr\u00E1n de una matr\u00EDcula\r\nunequ\u00EDvoca, de modo que no podr\u00E1n\r\ndarse de alta coches con la misma\r\nmatr\u00EDcula o nula. Para dar de baja un\r\ncoche, se buscar\u00E1 de acuerdo a su\r\nmatr\u00EDcula.\r\n\r\nLos coches tambi\u00E9n dispondr\u00E1n de un\r\nmodelo, una marca y un color a elegir.");
				PanelDesplazamiento.setViewportView(informacionTexto);
			}
		}
		
		// Panel de texto para el nombre del autor
		JTextPane NombreAutorTexto = new JTextPane();
		NombreAutorTexto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		NombreAutorTexto.setBackground(SystemColor.control);
		NombreAutorTexto.setEditable(false);
		NombreAutorTexto.setForeground(new Color(51, 51, 153));
		NombreAutorTexto.setText("Estela Mu\u00F1oz Cord\u00F3n");
		NombreAutorTexto.setBounds(119, 88, 141, 20);
		contentPanel.add(NombreAutorTexto);
		
		// Panel de texto para indicar el autor
		JTextPane autorTexto = new JTextPane();
		autorTexto.setBackground(SystemColor.control);
		autorTexto.setEditable(false);
		autorTexto.setText("Autor:");
		autorTexto.setBounds(62, 88, 47, 20);
		contentPanel.add(autorTexto);
		
		// Panel de texto para la Fecha de creación
		JTextPane FechaCreacionTexto = new JTextPane();
		FechaCreacionTexto.setBackground(SystemColor.control);
		FechaCreacionTexto.setEditable(false);
		FechaCreacionTexto.setText("Fecha de creación:  "+getFecha()); //Donde pone la fecha de creación
		FechaCreacionTexto.setBounds(229, 11, 182, 20);
		contentPanel.add(FechaCreacionTexto);
		{
			// Panel de texto para el email
			JTextPane emailTexto = new JTextPane();
			emailTexto.setBackground(SystemColor.control);
			emailTexto.setEditable(false);
			emailTexto.setText("e-mail");
			emailTexto.setBounds(62, 119, 47, 20);
			contentPanel.add(emailTexto);
		}
		{
			// Panel de texto para la dirección del FaceBook
			JTextPane facebookTexto = new JTextPane();
			facebookTexto.setBackground(SystemColor.control);
			facebookTexto.setForeground(new Color(51, 51, 153));
			facebookTexto.setText("https://www.facebook.com/estela.munoz.733");
			facebookTexto.setEditable(false);
			facebookTexto.setBounds(119, 119, 278, 20);
			contentPanel.add(facebookTexto);
		}
		{
			// Panel de texto para el nombre del programa
			JTextPane txtpnMiconcesionarioV = new JTextPane();
			txtpnMiconcesionarioV.setBackground(SystemColor.control);
			txtpnMiconcesionarioV.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtpnMiconcesionarioV.setForeground(new Color(102, 51, 102));
			txtpnMiconcesionarioV.setEditable(false);
			txtpnMiconcesionarioV.setText("MiConcesionario v1.0");
			txtpnMiconcesionarioV.setBounds(119, 52, 169, 25);
			contentPanel.add(txtpnMiconcesionarioV);
		}
		
		// Botón OK
		Button botonOK = new Button("OK");
		botonOK.addActionListener(new ActionListener() {
			// Sale de la ventana
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		botonOK.setBounds(175, 343, 70, 22);
		contentPanel.add(botonOK);
	}
	
	/**
	 * Devuelve la fecha actual
	 * 
	 * @return fecha actual
	 */
	private static String getFecha(){
		Calendar c = Calendar.getInstance();
		String dia=Integer.toString(c.get(Calendar.DATE));
		String mes= Integer.toString(c.get(Calendar.MONTH));
		String anno= Integer.toString(c.get(Calendar.YEAR));
		return  dia + "/" + mes +"/"+ anno;
		
	}
}

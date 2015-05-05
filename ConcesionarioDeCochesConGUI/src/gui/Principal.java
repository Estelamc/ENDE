package gui;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import concesionario.Concesionario;
import concesionario.Fichero;
import concesionario.FicheroCorruptoException;
import concesionario.General;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

/**
 * Ventana principal que gestiona el programa.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Principal {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Marco principal que contiene todos los elementos de la ventana.
	 */
	private JFrame ventanaPrincipal;
	
	/**
	 * Ventana para gestionar archivos.
	 */
	private JFileChooser ventanaSeleccion = new JFileChooser();
	
	/**
	 * Filtro para seleccionar archivos de tipo objeto.
	 */
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos OBJ", "obj");
		
	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\

	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.ventanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la apliaci&oacute;n.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Inicializa los contenidos del marco principal.
	 */
	private void initialize() {
		
		ventanaSeleccion.setFileFilter(filtro);
		
		// Marco principal
		ventanaPrincipal = new JFrame();
		ventanaPrincipal.setResizable(false);
		ventanaPrincipal.setTitle("MiConcesionario - ");
		ventanaPrincipal.setBounds(100, 100, 450, 300);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Barra de menú
		JMenuBar menuBarra = new JMenuBar();
		ventanaPrincipal.setJMenuBar(menuBarra);
		
		// Menu Ficheros
		JMenu menuFicheros = new JMenu("Ficheros");
		menuFicheros.setMnemonic('F');
		menuBarra.add(menuFicheros);
		
		// Menú Abrir
		JMenuItem menuAbrir = new JMenuItem("Abrir");
		menuAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuAbrir.addActionListener(new ActionListener() {
			private JPanel panelContenedor;

			/**
			 * Abre un archivo (guardado anteriormente)
			 */
			public void actionPerformed(ActionEvent e) {
					try{
						General.concesionario = (Concesionario) Fichero.abrirArchivo(Fichero.archivo);
						ventanaPrincipal.setTitle("MiConcesionario - " + Fichero.archivo.getName()); // La ventana tiene el nombre del archivo
						JOptionPane.showMessageDialog(panelContenedor, "Archivo abierto con éxito.", "Abierto", JOptionPane.INFORMATION_MESSAGE);
					}catch (ClassNotFoundException | IOException | FicheroCorruptoException e1){
						JOptionPane.showMessageDialog(panelContenedor, "No se pudo abrir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
		});
		
		// ----------------------------------- Menú Ficheros ----------------------------------- \\
		
		// Menú Nuevo
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			// Añade una acción al menú Nuevo -- Crea un archivo nuevo
			public void actionPerformed(ActionEvent arg0) {
				
				ventanaPrincipal.setTitle("MiConcesionario - " + Fichero.archivo.getName()); // La ventana tiene el nombre del archivo
			}
		});
		menuFicheros.add(mntmNuevo);
		menuFicheros.add(menuAbrir);
		
		// Menú Guardar
		JMenuItem menuGuardar = new JMenuItem("Guardar");
		menuGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		menuGuardar.addActionListener(new ActionListener() {
			private JPanel panelContenedor;
			// Guarda el concesionario
			public void actionPerformed(ActionEvent e) {
				try {
					Fichero.guardarArchivo(Fichero.archivo, General.concesionario);
					JOptionPane.showMessageDialog(panelContenedor, "Archivo guardado con éxito.", "Acción realiazada con éxito", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(panelContenedor, "No se pudo guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		menuFicheros.add(menuGuardar);
		
		// Menú Guardar Como
		JMenuItem menuGuardarComo = new JMenuItem("Guardar como...");
		menuGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		//menuGuardarComo.addActionListener(new ActionListener() {
			/**
			 * Guarda el archivo actual c&oacute;mo indiquemos, por si
			 * no queremos guardarlo encima del que ten&iacute;amos 
			 * anteriormete y queremos tener otro archivo nuevo
			 */
		/*	public void actionPerformed(ActionEvent e) throws FileNotFoundException, IOException {
				String nombre = Teclado.leerCadena("Introduce el nombre para el fichero");
				try (ObjectOutputStream on = new ObjectOutputStream(new FileOutputStream(Teclado.leerCadena(nombre)))) 
				{
					on.writeObject(concesionario);
				}
			
			}*/
	//	});
		menuFicheros.add(menuGuardarComo);
		
		// Separador
		JSeparator separator = new JSeparator();
		menuFicheros.add(separator);
		
		// Menú Salir
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuSalir.addActionListener(new ActionListener() {
			/**
			 * Sale de la aplicaci&oacute;n
			 */
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuFicheros.add(menuSalir);
		
		
		// ----------------------------------- Menú Coche ----------------------------------- \\
		
		// Menú Coche
		JMenu menuCoche = new JMenu("Coche");
		menuCoche.setMnemonic('C');
		menuBarra.add(menuCoche);
		
		//Menú Alta
		JMenuItem menuAlta = new JMenuItem("Alta");
		menuAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuAlta.addActionListener(new ActionListener() {
			// Abre la ventana de Alta
			public void actionPerformed(ActionEvent e) {
				Alta alta = new Alta();
				alta.setVisible(true);
			}
		});
		menuCoche.add(menuAlta);
		
		// Menú Baja
		JMenuItem menuBaja = new JMenuItem("Baja");
		menuBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		menuBaja.addActionListener(new ActionListener() {
			// Abre la ventana de Baja
			public void actionPerformed(ActionEvent e) {
				Baja baja = new Baja();
				baja.setVisible(true);
			}
		});
		menuCoche.add(menuBaja);
		
		// Menú Buscar
		JMenuItem menuBuscar = new JMenuItem("Buscar por la matr\u00EDcula");
		menuBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuBuscar.addActionListener(new ActionListener() {
			// Abre la ventana de Buscar por Matrícula
			public void actionPerformed(ActionEvent e) {
				BuscarPorMatricula buscar = new BuscarPorMatricula();
				buscar.setVisible(true);
			}
		});
		menuCoche.add(menuBuscar);
		
		// Menú Buscar por Color
		JMenuItem menuBuscarColor = new JMenuItem("Buscar por el color");
		menuBuscarColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuBuscarColor.addActionListener(new ActionListener() {
			// Abre la ventana de Buscar coche por el color
			public void actionPerformed(ActionEvent e) {
				BuscarPorColor buscarColor = new BuscarPorColor();
				buscarColor.setVisible(true);
			}
		});
		menuCoche.add(menuBuscarColor);
		
		// Menú Mostrar
		JMenuItem menuMostrar = new JMenuItem("Mostrar Stock");
		menuMostrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		menuMostrar.addActionListener(new ActionListener() {
			// Abre la ventana Mostrar Concesionario
			public void actionPerformed(ActionEvent e) {
				MostrarStock mostrar = new MostrarStock();
				mostrar.setVisible(true);
			}
		});
		menuCoche.add(menuMostrar);
		
		// Menú Stock
		JMenuItem menuStock = new JMenuItem("Stock Total");
		menuStock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuStock.addActionListener(new ActionListener() {
			// Abre la ventana de Stock total disponible
			public void actionPerformed(ActionEvent e) {
				StockTotal stock = new StockTotal();
				stock.setVisible(true);
			}
		});
		menuCoche.add(menuStock);
		
		// ----------------------------------- Menú Ayuda ----------------------------------- \\
		
		// Menú Ayuda
		JMenu menuAyuda = new JMenu("Ayuda");
		menuAyuda.setMnemonic('A');
		menuBarra.add(menuAyuda);
		
		// Menú Ver ayuda
		JMenuItem menuVerAyuda = new JMenuItem("Ver Ayuda");
		menuVerAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuVerAyuda.addActionListener(new ActionListener() {
			// Abre la ventana Ayuda
			public void actionPerformed(ActionEvent e) {
				Ayuda ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		menuAyuda.add(menuVerAyuda);
		
		// Menú Acerca de
		JMenuItem menuAcercaDe = new JMenuItem("Acerca de...");
		menuAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		menuAcercaDe.addActionListener(new ActionListener() {
			// Abre la ventana Acerca de
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		menuAyuda.add(menuAcercaDe);
		ventanaPrincipal.getContentPane().setLayout(null);
		
		// PARA AÑADIR UNA IMAGEN a la ventana
		ImageIcon icon = createImageIcon("imagenes/car.jpg","Mi Concesionario");
		JLabel imagen = new JLabel("", icon, JLabel.CENTER);
		imagen.setBounds(46, 30, 342, 169);
		ventanaPrincipal.getContentPane().add(imagen);		
	}
	
	/**
	 * Pone una imagen en la ventana
	 * 
	 * @param path Imagen a a&ntilde;adir
	 * @param description Texto explicativo de la imagen
	 * @return La imagen
	 */
	private ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + path);
            return null;
        }
    }
}

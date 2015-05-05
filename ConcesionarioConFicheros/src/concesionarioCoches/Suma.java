package concesionarioCoches;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Suma extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField sumando2;
	private JTextField sumando1;
	private JTextField resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Suma dialog = new Suma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Suma() {
		setTitle("Suma");
		setBounds(100, 100, 393, 157);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSumando1 = new JLabel("sumando1");
			lblSumando1.setBounds(25, 27, 58, 14);
			contentPanel.add(lblSumando1);
		}
		{
			sumando1 = new JTextField();
			sumando1.setBounds(88, 24, 86, 20);
			contentPanel.add(sumando1);
			sumando1.setColumns(10);
		}
		{
			sumando2 = new JTextField();
			sumando2.setBounds(88, 55, 86, 20);
			contentPanel.add(sumando2);
			sumando2.setColumns(10);
		}
		{
			JLabel lblSumando2 = new JLabel("sumando2");
			lblSumando2.setBounds(25, 58, 55, 14);
			contentPanel.add(lblSumando2);
		}
		
		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setBounds(276, 41, 86, 20);
		contentPanel.add(resultado);
		resultado.setColumns(10);
		
		JLabel lblResultado = new JLabel("resultado");
		lblResultado.setBounds(220, 44, 46, 14);
		contentPanel.add(lblResultado);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sumar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int a=Integer.parseInt(sumando1.getText());
						int b=Integer.parseInt(sumando2.getText());
						resultado.setText(Integer.toString(a+b));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

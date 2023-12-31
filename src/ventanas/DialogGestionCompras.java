package ventanas;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogGestionCompras extends JDialog {
	private JTextField txtCodigoCompras;
	private JTextField txtNombreCompras;
	private JTextField txtDescripCompras;
	private JTextField txtPrecioCompras;
        private JTable tbListaCompras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogGestionCompras dialog = new DialogGestionCompras();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogGestionCompras() {
            setTitle("GESTION DE COMPRAS");
		setBounds(100, 100, 633, 350);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 55, 239, 240);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCodigoCompras = new JTextField();
		txtCodigoCompras.setBounds(132, 24, 86, 20);
		panel.add(txtCodigoCompras);
		txtCodigoCompras.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(10, 27, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Articulo");
		lblNewLabel_4.setBounds(10, 68, 112, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion");
		lblNewLabel_5.setBounds(10, 106, 112, 14);
		panel.add(lblNewLabel_5);
                
                JLabel lblNewLabel_6 = new JLabel("Precio");
		lblNewLabel_6.setBounds(10, 140, 112, 14);
		panel.add(lblNewLabel_6);
		
		txtNombreCompras = new JTextField();
		txtNombreCompras.setBounds(132, 65, 86, 20);
		panel.add(txtNombreCompras);
		txtNombreCompras.setColumns(10);
		
		txtDescripCompras = new JTextField();
		txtDescripCompras.setBounds(132, 103, 86, 20);
		panel.add(txtDescripCompras);
		txtDescripCompras.setColumns(10);
                
                txtPrecioCompras = new JTextField();
		txtPrecioCompras.setBounds(132, 137, 86, 20);
		panel.add(txtPrecioCompras);
		txtPrecioCompras.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.setCodigoCompras(txtCodigoCompras.getText());
				objetoCompras.setNombreCompras(txtNombreCompras.getText());
				objetoCompras.setDescripCompras(txtDescripCompras.getText());
                                objetoCompras.setPrecioCompras(txtPrecioCompras.getText());
				objetoCompras.agregarRegistrosCompras();
			}
		});
		btnGuardar.setBounds(10, 180, 99, 23);
		panel.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.EditarCompras(tbListaCompras);
			}
		});
		btnEditar.setBounds(109, 180, 112, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.EliminarCompras(tbListaCompras, txtCodigoCompras);
			}
		});
		btnEliminar.setBounds(10, 205, 208, 29);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(275, 54, 338, 240);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 318, 200);
		panel_1.add(scrollPane);
		
		tbListaCompras = new JTable();
		scrollPane.setViewportView(tbListaCompras);
		
		JButton btnCrearArchivoCompras = new JButton("Crear Archivo Compras");
		btnCrearArchivoCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras= new clases.Compras();
				objetoCompras.crearArchivoCompras();
			}
		});
		btnCrearArchivoCompras.setBounds(10, 21, 239, 23);
		getContentPane().add(btnCrearArchivoCompras);
		
		JButton btnMostrarCompras = new JButton("Mostrar Compras");
		btnMostrarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.MostrarTotalCompras(tbListaCompras);
			}
		});
		btnMostrarCompras.setBounds(275, 21, 158, 23);
		getContentPane().add(btnMostrarCompras);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				
				objetoCompras.seleccionarCompras(tbListaCompras);
				txtCodigoCompras.setText(objetoCompras.getCodigoCompras());
				txtNombreCompras.setText(objetoCompras.getNombreCompras());
				txtDescripCompras.setText(objetoCompras.getDescripCompras());
                                txtPrecioCompras.setText(objetoCompras.getPrecioCompras());
			}
		});
		btnSeleccionar.setBounds(443, 20, 160, 23);
		getContentPane().add(btnSeleccionar);
	}
}


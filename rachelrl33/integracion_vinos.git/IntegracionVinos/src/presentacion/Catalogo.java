package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Vino;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Catalogo extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCatlogo;
	private JPanel panel_1;
	private JLabel lblCaractersticas;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblCosecha;
	private JTextField txtCosecha;
	private JLabel lblTipo;
	private JTextField txtTipo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblStock;
	private JTextField txtStock;
	private JButton btnGuardarCambios;
	private JLabel lblCochesDisponibles;
	private JButton button;
	private JButton button_1;
	private JScrollPane scrollPane;
	private JLabel lblWarning;

	private static CustomListModel modeloLista;
	private JList listCoches;
	private JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Catalogo frame = new Catalogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Catalogo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Catalogo.class.getResource("/presentacion/glass-with-wine.png")));
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{34, 0, 41, 38, 34, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{86, 0, 0, 0, 0, 0, 0, 0, 120, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Catalogo.class.getResource("/presentacion/logoVinos.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblCatlogo = new JLabel("  CATÁLOGO");
		lblCatlogo.setForeground(new Color(128, 0, 128));
		lblCatlogo.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		GridBagConstraints gbc_lblCatlogo = new GridBagConstraints();
		gbc_lblCatlogo.gridwidth = 2;
		gbc_lblCatlogo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCatlogo.gridx = 2;
		gbc_lblCatlogo.gridy = 0;
		contentPane.add(lblCatlogo, gbc_lblCatlogo);
		
		lblCochesDisponibles = new JLabel("Vinos disponibles");
		lblCochesDisponibles.setIcon(new ImageIcon(Catalogo.class.getResource("/presentacion/glass-with-wine.png")));
		lblCochesDisponibles.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		GridBagConstraints gbc_lblCochesDisponibles = new GridBagConstraints();
		gbc_lblCochesDisponibles.anchor = GridBagConstraints.WEST;
		gbc_lblCochesDisponibles.insets = new Insets(0, 0, 5, 5);
		gbc_lblCochesDisponibles.gridx = 1;
		gbc_lblCochesDisponibles.gridy = 1;
		contentPane.add(lblCochesDisponibles, gbc_lblCochesDisponibles);
		
		button = new JButton("");
		button.addActionListener(new ButtonActionListener());
		button.setIcon(new ImageIcon(Catalogo.class.getResource("/presentacion/add.png")));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 1;
		contentPane.add(button, gbc_button);
		
		button_1 = new JButton("");
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setIcon(new ImageIcon(Catalogo.class.getResource("/presentacion/rubbish-bin.png")));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 1;
		contentPane.add(button_1, gbc_button_1);
		
		lblWarning = new JLabel("Rellene los campos");
		lblWarning.setVisible(false);
		lblWarning.setIcon(new ImageIcon(Catalogo.class.getResource("/presentacion/warning.png")));
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		GridBagConstraints gbc_lblWarning = new GridBagConstraints();
		gbc_lblWarning.anchor = GridBagConstraints.SOUTH;
		gbc_lblWarning.gridwidth = 6;
		gbc_lblWarning.insets = new Insets(0, 0, 5, 0);
		gbc_lblWarning.gridx = 5;
		gbc_lblWarning.gridy = 1;
		contentPane.add(lblWarning, gbc_lblWarning);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 7;
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 5;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{40, 99, 40, 105, 34, 0};
		gbl_panel_1.rowHeights = new int[]{46, 36, 39, 0, 39, 0, 0, 39, 52, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblCaractersticas = new JLabel("CARACTERÍSTICAS");
		lblCaractersticas.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		GridBagConstraints gbc_lblCaractersticas = new GridBagConstraints();
		gbc_lblCaractersticas.anchor = GridBagConstraints.SOUTH;
		gbc_lblCaractersticas.gridwidth = 3;
		gbc_lblCaractersticas.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaractersticas.gridx = 1;
		gbc_lblCaractersticas.gridy = 0;
		panel_1.add(lblCaractersticas, gbc_lblCaractersticas);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setEnabled(false);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		panel_1.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.NORTH;
		gbc_txtNombre.gridwidth = 3;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 2;
		panel_1.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblCosecha = new JLabel("Cosecha");
		lblCosecha.setEnabled(false);
		GridBagConstraints gbc_lblCosecha = new GridBagConstraints();
		gbc_lblCosecha.anchor = GridBagConstraints.WEST;
		gbc_lblCosecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosecha.gridx = 1;
		gbc_lblCosecha.gridy = 3;
		panel_1.add(lblCosecha, gbc_lblCosecha);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setEnabled(false);
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.anchor = GridBagConstraints.WEST;
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.gridx = 3;
		gbc_lblTipo.gridy = 3;
		panel_1.add(lblTipo, gbc_lblTipo);
		
		txtCosecha = new JTextField();
		txtCosecha.setEnabled(false);
		GridBagConstraints gbc_txtCosecha = new GridBagConstraints();
		gbc_txtCosecha.anchor = GridBagConstraints.NORTH;
		gbc_txtCosecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtCosecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCosecha.gridx = 1;
		gbc_txtCosecha.gridy = 4;
		panel_1.add(txtCosecha, gbc_txtCosecha);
		txtCosecha.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setEnabled(false);
		GridBagConstraints gbc_txtTipo = new GridBagConstraints();
		gbc_txtTipo.anchor = GridBagConstraints.NORTH;
		gbc_txtTipo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTipo.gridx = 3;
		gbc_txtTipo.gridy = 4;
		panel_1.add(txtTipo, gbc_txtTipo);
		txtTipo.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setEnabled(false);
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.WEST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 5;
		panel_1.add(lblPrecio, gbc_lblPrecio);
		
		lblStock = new JLabel("Stock");
		lblStock.setEnabled(false);
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.anchor = GridBagConstraints.WEST;
		gbc_lblStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblStock.gridx = 3;
		gbc_lblStock.gridy = 5;
		panel_1.add(lblStock, gbc_lblStock);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridx = 1;
		gbc_txtPrecio.gridy = 6;
		panel_1.add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setEnabled(false);
		GridBagConstraints gbc_txtStock = new GridBagConstraints();
		gbc_txtStock.insets = new Insets(0, 0, 5, 5);
		gbc_txtStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStock.gridx = 3;
		gbc_txtStock.gridy = 6;
		panel_1.add(txtStock, gbc_txtStock);
		txtStock.setColumns(10);
		
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.setIcon(new ImageIcon(Catalogo.class.getResource("/presentacion/diskette.png")));
		GridBagConstraints gbc_btnGuardarCambios = new GridBagConstraints();
		gbc_btnGuardarCambios.anchor = GridBagConstraints.NORTH;
		gbc_btnGuardarCambios.gridwidth = 3;
		gbc_btnGuardarCambios.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardarCambios.gridx = 1;
		gbc_btnGuardarCambios.gridy = 8;
		panel_1.add(btnGuardarCambios, gbc_btnGuardarCambios);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		list = new JList();
		list.setBackground(SystemColor.control);
		scrollPane.setViewportView(list);

		list.addListSelectionListener(new listCoches_ListSelectionListener());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		modeloLista = new CustomListModel();
		list.setModel(modeloLista);
		
		Vino u1 = new Vino("Protos Rivera del Duero", "Reverva Tinto", "2010", "200", "2");
		Vino u2 = new Vino("Tempus vivendi", "Crianza Blanco", "2015", "50", "5"); 
		
		modeloLista.addVino(u1);
		modeloLista.addVino(u2);

	}
	
	
	
	
	
	//--------------------------------------------
	//                 OYENTES 
	//--------------------------------------------
	
	

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblWarning.setText("Rellenar los campos");
			lblWarning.setVisible(true);
			lblCosecha.setEnabled(true);
			lblNombre.setEnabled(true);
			txtNombre.setEnabled(true);
			txtNombre.setEditable(true);
			txtCosecha.setEnabled(true);
			txtCosecha.setEditable(true);
			txtTipo.setEnabled(true);
			txtTipo.setEditable(true);
			lblTipo.setEnabled(true);
			txtStock.setEnabled(true);
			txtStock.setEditable(true);
			lblStock.setEnabled(true);
			txtPrecio.setEnabled(true);
			txtPrecio.setEditable(true);
			lblPrecio.setEnabled(true);
			
			
			txtNombre.setText("");
			txtTipo.setText("");
			txtCosecha.setText("");
			txtPrecio.setText("");
			txtStock.setText("");
			

		}
	}
	
	
	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Seguro que quieres eliminar este coche?", "Eliminar", JOptionPane.OK_CANCEL_OPTION);
			if (opcion == 0) { 
				
				//Eliminar el nodo de la lista
				int index = list.getSelectedIndex();
				modeloLista.eliminarVino(index);
				
				lblWarning.setVisible(false);
				txtNombre.setText("");
				txtNombre.setEditable(false);
				txtNombre.setEnabled(false);
				lblNombre.setEnabled(false);
				
				txtTipo.setText("");
				txtTipo.setEditable(false);
				txtTipo.setEnabled(false);
				lblTipo.setEnabled(false);
				
				txtCosecha.setText("");
				txtCosecha.setEditable(false);
				txtCosecha.setEnabled(false);
				lblCosecha.setEnabled(false);
				
				txtPrecio.setText("");
				txtPrecio.setEditable(false);
				txtPrecio.setEnabled(false);
				lblPrecio.setEnabled(false);
				
				txtStock.setText("");
				txtStock.setEditable(false);
				txtStock.setEnabled(false);
				lblStock.setEnabled(false);
			}
		}
	}
	
	//SELECCIONDE USUARIOS EN LA LISTA
		private class listCoches_ListSelectionListener implements ListSelectionListener {
			public void valueChanged(ListSelectionEvent arg0) {

				
				int selection = list.getSelectedIndex();
				if (selection!=-1) {
					Vino u= modeloLista.getVino(selection);
					lblWarning.setText("Los campos son editables");
					lblWarning.setVisible(true);
					txtNombre.setText(u.getNombre());
					txtNombre.setEditable(false);
					txtNombre.setEnabled(true);
					lblNombre.setEnabled(true);
					
					txtTipo.setText(u.getTipo());
					txtTipo.setEditable(true);
					txtTipo.setEnabled(true);
					lblTipo.setEnabled(true);
					
					txtCosecha.setText(u.getCosecha());
					txtCosecha.setEditable(true);
					txtCosecha.setEnabled(true);
					lblCosecha.setEnabled(true);
					
					txtPrecio.setText(u.getPrecio());
					txtPrecio.setEditable(true);
					txtPrecio.setEnabled(true);
					lblPrecio.setEnabled(true);
					
					txtStock.setText(u.getStock());
					txtStock.setEditable(true);
					txtStock.setEnabled(true);
					lblStock.setEnabled(true);
				}

			}
		}

	
	
}

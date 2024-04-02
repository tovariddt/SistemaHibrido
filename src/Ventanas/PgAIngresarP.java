package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;

public class PgAIngresarP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgAIngresarP frame = new PgAIngresarP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JTextField textField1;
	    
	    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    public JPanel contentPane1;
	    public JTextField Nombre;
	    public JTextField Fecha;
	    public JTextField Descripcion;
	    public JTextField Personal;
	    public JTextField Total;
	    public JTextField Unidad;
	    public JTextField Monto;
	    public JTextField ID;
	    public JTextField Cantidad;
	    public JTextField IDU;

	/**
	 * Create the frame.
	 */
	public PgAIngresarP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1000, 700);
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	
	
	//////////////////////////////////////////////////////////
	//La locacion de las imgenes se tienen que establecer en cada dispositivo 

	JMenu MenuIngresar = new JMenu("Ingresar");
	MenuIngresar.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1370848050_document-new.png"));
	MenuIngresar.setFont(new Font("Lao MN", Font.PLAIN, 30));
	menuBar.add(MenuIngresar);
	
	
	
	JMenu SubMenuGastosI = new JMenu("Gastos");
	SubMenuGastosI.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1395460082_reports.png"));
	SubMenuGastosI.setFont(new Font("Lao MN", Font.PLAIN, 25));
	MenuIngresar.add(SubMenuGastosI);
	
	JMenuItem IngresarPagos = new JMenuItem("Pagos");
	IngresarPagos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			PgAIngresarP objPgAIngresarP = new PgAIngresarP();
			objPgAIngresarP.setVisible(true);
			dispose();
		}
	});
	IngresarPagos.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
	IngresarPagos.setFont(new Font("Lao MN", Font.PLAIN, 25));
	SubMenuGastosI.add(IngresarPagos);
	
	JMenuItem IngresarTareas = new JMenuItem("Tareas");
	IngresarTareas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PgAIngresarT objPgAIngresarT = new PgAIngresarT();
			objPgAIngresarT.setVisible(true);
			dispose();
		}
	});
	IngresarTareas.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
	IngresarTareas.setFont(new Font("Lao MN", Font.PLAIN, 25));
	SubMenuGastosI.add(IngresarTareas);
	
	JMenuItem IngresarCompra = new JMenuItem("Compras");
	IngresarCompra.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PgAIngresarC objPgAIngresarC = new PgAIngresarC();
			objPgAIngresarC.setVisible(true);
			dispose();
		}
	});
	IngresarCompra.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/facultad_presupuesto.png"));
	IngresarCompra.setFont(new Font("Lao MN", Font.PLAIN, 25));
	SubMenuGastosI.add(IngresarCompra);
	
	JMenuItem IngresarVentas = new JMenuItem("Ventas");
	IngresarVentas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PgAIngresarV objPgAIngresarV = new PgAIngresarV();
			objPgAIngresarV.setVisible(true);
			dispose();
		}
	});
	IngresarVentas.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1396300544_bookmark-new.png"));
	IngresarVentas.setFont(new Font("Lao MN", Font.PLAIN, 25));
	MenuIngresar.add(IngresarVentas);
	

	
	///////////////////////////////////////////////////////////////// 
	
	JMenu MenuConsultar = new JMenu("Consultar");
	MenuConsultar.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1395357293_search.png"));
	MenuConsultar.setFont(new Font("Lao MN", Font.PLAIN, 30));
	menuBar.add(MenuConsultar);
	
	JMenuItem ConsultarInsumos = new JMenuItem("Insumos");
	ConsultarInsumos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PgAConsultarI objPgAConsultarI = new PgAConsultarI();
			objPgAConsultarI.setVisible(true);
			dispose();
		}
	});
	ConsultarInsumos.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1397492835_Package-Download.png"));
	ConsultarInsumos.setFont(new Font("Lao MN", Font.PLAIN, 25));
	MenuConsultar.add(ConsultarInsumos);
	
	JMenu SubMenuGastosC = new JMenu("Gastos");
	SubMenuGastosC.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1395460082_reports.png"));
	SubMenuGastosC.setFont(new Font("Lao MN", Font.PLAIN, 25));
	MenuConsultar.add(SubMenuGastosC);
	
	JMenuItem ConsultarPagos = new JMenuItem("Pagos");
	ConsultarPagos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PgAConsultarP objPgAConsultarP = new PgAConsultarP();
			objPgAConsultarP.setVisible(true);
			dispose();
		}
	});
	ConsultarPagos.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
	ConsultarPagos.setFont(new Font("Lao MN", Font.PLAIN, 25));
	SubMenuGastosC.add(ConsultarPagos);
	
	JMenuItem ConsultarTareas = new JMenuItem("Tareas");
	ConsultarTareas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PgAConsultarT objPgAConsultarT = new PgAConsultarT();
			objPgAConsultarT.setVisible(true);
			dispose();
		}
	});
	ConsultarTareas.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
	ConsultarTareas.setFont(new Font("Lao MN", Font.PLAIN, 25));
	SubMenuGastosC.add(ConsultarTareas);
	
	
	JMenuItem ConsultarVentas = new JMenuItem("Ventas");
	ConsultarVentas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PgAConsultarV objPgAConsultarV = new PgAConsultarV();
			objPgAConsultarV.setVisible(true);
			dispose();
		}
	});
	ConsultarVentas.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1396300544_bookmark-new.png"));
	ConsultarVentas.setFont(new Font("Lao MN", Font.PLAIN, 25));
	MenuConsultar.add(ConsultarVentas);			
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblIngresarInsumos = new JLabel("Ingresar Pagos");
		lblIngresarInsumos.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblIngresarInsumos.setBounds(38, 6, 233, 63);
		layeredPane.add(lblIngresarInsumos);
		
		Nombre = new JTextField();
		Nombre.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Nombre.setColumns(10);
		Nombre.setBounds(185, 81, 222, 41);
		layeredPane.add(Nombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre.setBounds(38, 81, 124, 41);
		layeredPane.add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("Fecha de Pagos");
		lblNombre_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1.setBounds(465, 81, 253, 41);
		layeredPane.add(lblNombre_1);
		
		Fecha = new JTextField();
		  Fecha.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		  Fecha.setText(dtf2.format(LocalDateTime.now()));
		Fecha.setColumns(10);
		Fecha.setBounds(695, 81, 177, 41);
		layeredPane.add(Fecha);
		
		JLabel lblNombre_1_2 = new JLabel("Descripción");
		lblNombre_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2.setBounds(28, 244, 177, 41);
		layeredPane.add(lblNombre_1_2);
		
		Descripcion = new JTextField();
		Descripcion.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Descripcion.setColumns(10);
		Descripcion.setBounds(217, 164, 746, 183);
		layeredPane.add(Descripcion);
		
		JLabel lblNombre_1_3 = new JLabel("Personal");
		lblNombre_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_3.setBounds(16, 379, 135, 41);
		layeredPane.add(lblNombre_1_3);
		
		Personal = new JTextField();
		Personal.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Personal.setColumns(10);
		Personal.setBounds(163, 385, 222, 41);
		layeredPane.add(Personal);
		
		JLabel lblNombre_1_2_1 = new JLabel("Total");
		lblNombre_1_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2_1.setBounds(421, 457, 124, 41);
		layeredPane.add(lblNombre_1_2_1);
		
		Total = new JTextField();
		Total.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Total.setColumns(10);
		Total.setBounds(504, 457, 222, 41);
		layeredPane.add(Total);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//////Esto es el constructor para realizar la conexion entre la base de datos y java
				
							ConectarPosgres conn = new ConectarPosgres();
							try {
								PreparedStatement ps = conn.conexion.prepareStatement("INSERT INTO public.\"Gastos_General\"(\n"
										+ "	\"ID_Gastos\", \"Nombre_Gasto\", \"Fecha_Gasto\", \"Tipo_Gasto\", \"Total_Gasto\", \"ID_Usuario\", \"ID_Insumo\")\n"
										+ "	VALUES ("+ID.getText()+",'"+Nombre.getText()+"' ,'"+Fecha.getText()+"' , 'Pago', '"+Total.getText()+"',"+IDU.getText()+", null);"
										
										+ "INSERT INTO public.\"Gasto_Pagos\"(\n"
										+ "	\"ID_Gastos\", \"Fecha_Pagos\", \"Descripción_Pagos\", \"Personal_Pagos\", \"Monto_Pagos\", \"Unidad_Pagos\", \"Cantidad_Pagos\")\n"
										+ "	VALUES ("+ID.getText()+", '"+Fecha.getText()+"', '"+Descripcion.getText()+"', '"+Personal.getText()+"', '$"+Monto.getText()+"', '"+Unidad.getText()+"', "+Cantidad.getText()+");"
											
										+ "INSERT INTO public.\"Ganancias\"(\n"
												+ "	\"Fecha_Ganancia\", \"ID_Gastos\", \"ID_Venta\",\"ID_Ganancias\")\n"
												+ "	VALUES ('"+Fecha.getText()+"',"+ID.getText()+", null, DEFAULT);");
								
						
								int x =  ps.executeUpdate();
								
								//Al momento de resivir la instrucion se genera 2 caminos uno donde indique , que si se logro el proceso y otro donde diga que no se logro 
											
								if (x > 0) {
								
									 JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
									
								}
										
										
							} catch (SQLException e1) {
								e1.printStackTrace();
						 JOptionPane.showMessageDialog(null, "Operación no ha sido realizada correctamente");
							}
							
						}
				
			
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnNewButton.setBounds(358, 519, 274, 73);
		layeredPane.add(btnNewButton);
		
		JLabel lblNombre_1_2_1_1 = new JLabel("Monto");
		lblNombre_1_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2_1_1.setBounds(695, 385, 100, 41);
		layeredPane.add(lblNombre_1_2_1_1);
		
		Unidad = new JTextField();
		Unidad.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Unidad.setColumns(10);
		Unidad.setBounds(548, 385, 118, 41);
		layeredPane.add(Unidad);
		
		Monto = new JTextField();
		Monto.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Monto.setColumns(10);
		Monto.setBounds(807, 385, 123, 41);
		layeredPane.add(Monto);
		
		JLabel lblNombre_1_2_1_1_1 = new JLabel("Unidad");
		lblNombre_1_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2_1_1_1.setBounds(410, 385, 135, 41);
		layeredPane.add(lblNombre_1_2_1_1_1);
		
		ID = new JTextField();
		ID.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		ID.setColumns(10);
		ID.setBounds(848, 20, 118, 41);
		layeredPane.add(ID);
		
		JLabel lblIdDePago = new JLabel("ID de Gasto");
		lblIdDePago.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblIdDePago.setBounds(670, 6, 183, 63);
		layeredPane.add(lblIdDePago);
		
		JLabel lblNombre_1_2_1_2 = new JLabel("Cantidad");
		lblNombre_1_2_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2_1_2.setBounds(28, 460, 134, 41);
		layeredPane.add(lblNombre_1_2_1_2);
		
		Cantidad = new JTextField();
		Cantidad.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Cantidad.setColumns(10);
		Cantidad.setBounds(163, 460, 222, 41);
		layeredPane.add(Cantidad);
		
	   /////Agregue un calculo rapido para que no se tenga que calcular el total manualmente
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String Nm = Monto.getText();      
				    String Nc = Cantidad.getText();     
				Double RTotal=(Double.parseDouble(Nc))*(Double.parseDouble(Nm));
				Total.setText(String.valueOf(RTotal));

			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_1.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/calculadora_m.png"));
		btnNewButton_1.setBounds(738, 457, 46, 44);
		layeredPane.add(btnNewButton_1);
		
		JLabel lblIdUsuario = new JLabel("ID Usuario");
		lblIdUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblIdUsuario.setBounds(346, 6, 183, 63);
		layeredPane.add(lblIdUsuario);
		
		IDU = new JTextField();
		IDU.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		IDU.setColumns(10);
		IDU.setBounds(499, 20, 118, 41);
		layeredPane.add(IDU);
	}
}
package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PgIngresarV extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgIngresarV frame = new PgIngresarV();
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
	    public JTextField Cantidad;
	    public JTextField Total;
	    public JTextField Unidad;
	    public JTextField Monto;
	    public JTextField ID;

	/**
	 * Create the frame.
	 */
	public PgIngresarV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1000, 700);
				

JMenuBar menuBar = new JMenuBar();
setJMenuBar(menuBar);

JButton OpcionesB = new JButton("Principal");
OpcionesB.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Pg1 objPg1 = new Pg1();
		objPg1.setVisible(true);
		dispose();
	}
});
//La locacion de las imgenes se tienen que establecer en cada dispositivo 
OpcionesB.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/cerrar.png"));
OpcionesB.setFont(new Font("Lao MN", Font.PLAIN, 30));
menuBar.add(OpcionesB);



//////////////////////////////////////////////////////////
//La locacion de las imgenes se tienen que establecer en cada dispositivo 

		JMenu MenuIngresar = new JMenu("Ingresar");
		MenuIngresar.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1370848050_document-new.png"));
		MenuIngresar.setFont(new Font("Lao MN", Font.PLAIN, 30));
		menuBar.add(MenuIngresar);
		
		JMenuItem IngresarUsuarios = new JMenuItem("Usuarios");
		IngresarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgIngresarU objPgIngresarU = new PgIngresarU();
				objPgIngresarU.setVisible(true);
				dispose();
			}
		});
		IngresarUsuarios.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1370848217_testimonials.png"));
		IngresarUsuarios.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuIngresar.add(IngresarUsuarios);
		
		JMenuItem IngresarInsumos = new JMenuItem("Insumos");
		IngresarInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgIngresarI objPgIngresarI = new PgIngresarI();
				objPgIngresarI.setVisible(true);
				dispose();
			}
		});
		IngresarInsumos.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1397492835_Package-Download.png"));
		IngresarInsumos.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuIngresar.add(IngresarInsumos);
		
		JMenu SubMenuGastosI = new JMenu("Gastos");
		SubMenuGastosI.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1395460082_reports.png"));
		SubMenuGastosI.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuIngresar.add(SubMenuGastosI);
		
		JMenuItem IngresarPagos = new JMenuItem("Pagos");
		IngresarPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PgIngresarP objPgIngresarP = new PgIngresarP();
				objPgIngresarP.setVisible(true);
				dispose();
			}
		});
		IngresarPagos.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
		IngresarPagos.setFont(new Font("Lao MN", Font.PLAIN, 25));
		SubMenuGastosI.add(IngresarPagos);
		
		JMenuItem IngresarTareas = new JMenuItem("Tareas");
		IngresarTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgIngresarT objPgIngresarT = new PgIngresarT();
				objPgIngresarT.setVisible(true);
				dispose();
			}
		});
		IngresarTareas.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
		IngresarTareas.setFont(new Font("Lao MN", Font.PLAIN, 25));
		SubMenuGastosI.add(IngresarTareas);
		
		JMenuItem IngresarCompra = new JMenuItem("Compras");
		IngresarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgIngresarC objPgIngresarC = new PgIngresarC();
				objPgIngresarC.setVisible(true);
				dispose();
			}
		});
		IngresarCompra.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/facultad_presupuesto.png"));
		IngresarCompra.setFont(new Font("Lao MN", Font.PLAIN, 25));
		SubMenuGastosI.add(IngresarCompra);
		
		JMenuItem IngresarVentas = new JMenuItem("Ventas");
		IngresarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgIngresarV objPgIngresarV = new PgIngresarV();
				objPgIngresarV.setVisible(true);
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
		
		JMenuItem ConsultarUsuarios = new JMenuItem("Usuarios");
		ConsultarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgConsultarU objPgConsultarU = new PgConsultarU();
				objPgConsultarU.setVisible(true);
				dispose();
			}
		});
		ConsultarUsuarios.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1370848217_testimonials.png"));
		ConsultarUsuarios.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuConsultar.add(ConsultarUsuarios);
		
		JMenuItem ConsultarInsumos = new JMenuItem("Insumos");
		ConsultarInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgConsultarI objPgConsultarI = new PgConsultarI();
				objPgConsultarI.setVisible(true);
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
				PgConsultarP objPgConsultarP = new PgConsultarP();
				objPgConsultarP.setVisible(true);
				dispose();
			}
		});
		ConsultarPagos.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
		ConsultarPagos.setFont(new Font("Lao MN", Font.PLAIN, 25));
		SubMenuGastosC.add(ConsultarPagos);
		
		JMenuItem ConsultarTareas = new JMenuItem("Tareas");
		ConsultarTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgConsultarT objPgConsultarT = new PgConsultarT();
				objPgConsultarT.setVisible(true);
				dispose();
			}
		});
		ConsultarTareas.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
		ConsultarTareas.setFont(new Font("Lao MN", Font.PLAIN, 25));
		SubMenuGastosC.add(ConsultarTareas);
		
		
		JMenuItem ConsultarVentas = new JMenuItem("Ventas");
		ConsultarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgConsultarV objPgConsultarV = new PgConsultarV();
				objPgConsultarV.setVisible(true);
				dispose();
			}
		});
		ConsultarVentas.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1396300544_bookmark-new.png"));
		ConsultarVentas.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuConsultar.add(ConsultarVentas);
		
		JMenuItem ConsultarGanancias = new JMenuItem("Gastos.G");
		ConsultarGanancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgConsultarG objPgConsultarG = new PgConsultarG();
				objPgConsultarG.setVisible(true);
				dispose();
			}
		});
		ConsultarGanancias.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/administrativo_facultad.png"));
		ConsultarGanancias.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuConsultar.add(ConsultarGanancias);
		
		
///////////////////////////////////////////////////////////////// 
		
		JMenu MenuReportes = new JMenu("Reportes");
		MenuReportes.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1395548747_document-print.png"));
		MenuReportes.setFont(new Font("Lao MN", Font.PLAIN, 30));
		menuBar.add(MenuReportes);
		
		JMenuItem ReportesUsuarios = new JMenuItem("Usuarios");
		ReportesUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgReporteU objPgReporteU = new PgReporteU();
				objPgReporteU.setVisible(true);
				dispose();
			}
		});
		ReportesUsuarios.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1370848217_testimonials.png"));
		ReportesUsuarios.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuReportes.add(ReportesUsuarios);
		
		JMenuItem ReportesInsumos = new JMenuItem("Insumos");
		ReportesInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgReporteI objPgReporteI = new PgReporteI();
				objPgReporteI.setVisible(true);
				dispose();
			}
		});
		ReportesInsumos.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1397492835_Package-Download.png"));
		ReportesInsumos.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuReportes.add(ReportesInsumos);
		
		JMenu SubMenuGastosR= new JMenu("Gastos");
		SubMenuGastosR.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1395460082_reports.png"));
		SubMenuGastosR.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuReportes.add(SubMenuGastosR);
		
		JMenuItem ReportesPagos = new JMenuItem("Pagos");
		ReportesPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgReporteP objPgReporteP = new PgReporteP();
				objPgReporteP.setVisible(true);
				dispose();
			}
		});
		ReportesPagos.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
		ReportesPagos.setFont(new Font("Lao MN", Font.PLAIN, 25));
		SubMenuGastosR.add(ReportesPagos);
		
		JMenuItem ReportesTareas = new JMenuItem("Tareas");
		ReportesTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgReporteT objPgReporteT = new PgReporteT();
				objPgReporteT.setVisible(true);
				dispose();
			}
		});
		ReportesTareas.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/añadirm.png"));
		ReportesTareas.setFont(new Font("Lao MN", Font.PLAIN, 25));
		SubMenuGastosR.add(ReportesTareas);
		
		
		JMenuItem ReportesVentas = new JMenuItem("Ventas");
		ReportesVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgReporteV objPgReporteV = new PgReporteV();
				objPgReporteV.setVisible(true);
				dispose();
			}
		});
		ReportesVentas.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1396300544_bookmark-new.png"));
		ReportesVentas.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuReportes.add(ReportesVentas);
		
		JMenuItem ReportesGanancias = new JMenuItem("Gastos.G");
		ReportesGanancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PgReporteG objPgReporteG = new PgReporteG();
				objPgReporteG.setVisible(true);
				dispose();
			}
		});
		ReportesGanancias.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/administrativo_facultad.png"));
		ReportesGanancias.setFont(new Font("Lao MN", Font.PLAIN, 25));
		MenuReportes.add(ReportesGanancias);
		
	


		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		///////////////////////////////////////////////////////////
		
		JLabel lblIngresarInsumos = new JLabel("Ingresar Ventas");
		lblIngresarInsumos.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblIngresarInsumos.setBounds(26, 6, 233, 63);
		layeredPane.add(lblIngresarInsumos);
		
		Nombre = new JTextField();
		Nombre.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Nombre.setColumns(10);
		Nombre.setBounds(185, 108, 222, 41);
		layeredPane.add(Nombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre.setBounds(38, 108, 124, 41);
		layeredPane.add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("Fecha de Ventas");
		lblNombre_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1.setBounds(459, 108, 253, 41);
		layeredPane.add(lblNombre_1);
		
		Fecha = new JTextField();
		  Fecha.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		  Fecha.setText(dtf2.format(LocalDateTime.now()));
		Fecha.setColumns(10);
		Fecha.setBounds(701, 108, 173, 41);
		layeredPane.add(Fecha);
		
		JLabel lblNombre_1_3 = new JLabel("Cantidad");
		lblNombre_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_3.setBounds(38, 336, 135, 41);
		layeredPane.add(lblNombre_1_3);
		
		Cantidad = new JTextField();
		Cantidad.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Cantidad.setColumns(10);
		Cantidad.setBounds(201, 336, 222, 41);
		layeredPane.add(Cantidad);
		
		JLabel lblNombre_1_2_1 = new JLabel("Total");
		lblNombre_1_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2_1.setBounds(507, 336, 124, 41);
		layeredPane.add(lblNombre_1_2_1);
		
		Total = new JTextField();
		Total.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Total.setColumns(10);
		Total.setBounds(614, 336, 222, 41);
		layeredPane.add(Total);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//////Esto es el constructor para realizar la conexion entre la base de datos y java
				
				ConectarPosgres conn = new ConectarPosgres();
				try {
					PreparedStatement ps = conn.conexion.prepareStatement("INSERT INTO public.\"Venta\"(\n"
							+ "	\"ID_Venta\", \"Nombre_Venta\", \"Fecha_Venta\", \"Unidad_Venta\", \"Monto_Venta\", \"Total_Venta\", \"Cantidad_Venta\")\n"
							+ "	VALUES ("+ID.getText()+",'"+Nombre.getText()+"', '"+Fecha.getText()+"', '"+Unidad.getText()+"', '$"+Monto.getText()+"', '$"+Total.getText()+"', "+Cantidad.getText()+");"
									+ "INSERT INTO public.\"Ganancias\"(\n"
									+ "	\"Fecha_Ganancia\", \"ID_Gastos\", \"ID_Venta\",\"ID_Ganancias\")\n"
									+ "	VALUES ('"+Fecha.getText()+"', null, "+ID.getText()+",DEFAULT);");
					
			
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
		btnNewButton.setBounds(355, 469, 274, 73);
		layeredPane.add(btnNewButton);
		
		JLabel lblNombre_1_2_1_1 = new JLabel("Monto");
		lblNombre_1_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2_1_1.setBounds(502, 230, 100, 41);
		layeredPane.add(lblNombre_1_2_1_1);
		
		Unidad = new JTextField();
		Unidad.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Unidad.setColumns(10);
		Unidad.setBounds(186, 230, 221, 41);
		layeredPane.add(Unidad);
		
		Monto = new JTextField();
		Monto.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		Monto.setColumns(10);
		Monto.setBounds(637, 236, 179, 41);
		layeredPane.add(Monto);
		
		JLabel lblNombre_1_2_1_1_1 = new JLabel("Unidad");
		lblNombre_1_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2_1_1_1.setBounds(38, 230, 135, 41);
		layeredPane.add(lblNombre_1_2_1_1_1);
		
		JLabel lblIdDeVenta = new JLabel("ID de  Venta");
		lblIdDeVenta.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblIdDeVenta.setBounds(303, 6, 233, 63);
		layeredPane.add(lblIdDeVenta);
		
		ID = new JTextField();
		ID.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		ID.setColumns(10);
		ID.setBounds(559, 16, 222, 41);
		layeredPane.add(ID);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String Nm = Monto.getText();      
				    String Nc = Cantidad.getText();     
				Double RTotal=(Double.parseDouble(Nc))*(Double.parseDouble(Nm));
				Total.setText(String.valueOf(RTotal));
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/calculadora_m.png"));
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_1.setBounds(864, 333, 46, 44);
		layeredPane.add(btnNewButton_1);

}}


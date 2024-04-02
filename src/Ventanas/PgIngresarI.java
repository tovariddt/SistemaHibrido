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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ventanas.ConectarPosgres;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PgIngresarI extends JFrame {

	public JPanel contentPane;
	public JTextField Nombre;
	public JTextField Stock;
	public JTextField StockMinimo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgIngresarI frame = new PgIngresarI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	  private JTextField textField1;
	    
	    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    public JTextField FechaCompra;
	    public JTextField Medida;
	    public JTextField FechaCaducidad;
	    public JTextField Marca;
	    public JTextField PrecioCompra;
	    public JTextField ID;


	/**
	 * Create the frame.
	 */
	public PgIngresarI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1000, 700);
				

	//Esto es el menu 
		
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
		
		
			
			//Estas son las partes de donde se extrae a informacion todas deben ser publicas 
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblIngresarInsumos = new JLabel("Ingresar Insumos");
		lblIngresarInsumos.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblIngresarInsumos.setBounds(38, 6, 253, 63);
		layeredPane.add(lblIngresarInsumos);
		
		Nombre = new JTextField();
		Nombre.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		Nombre.setColumns(10);
		Nombre.setBounds(185, 81, 222, 41);
		layeredPane.add(Nombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre.setBounds(38, 81, 124, 41);
		layeredPane.add(lblNombre);
		
		JLabel lblS = new JLabel("Stock");
		lblS.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblS.setBounds(427, 81, 124, 41);
		layeredPane.add(lblS);
		
		Stock = new JTextField();
		Stock.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		Stock.setColumns(10);
		Stock.setBounds(521, 81, 111, 41);
		layeredPane.add(Stock);
		
		JLabel lblNombre_1_1 = new JLabel("Stock Minimo");
		lblNombre_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_1.setBounds(644, 81, 205, 41);
		layeredPane.add(lblNombre_1_1);
		
		StockMinimo = new JTextField();
		StockMinimo.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		StockMinimo.setColumns(10);
		StockMinimo.setBounds(861, 81, 111, 41);
		layeredPane.add(StockMinimo);
		
		JLabel lblNombre_1 = new JLabel("Fecha de Compra");
		lblNombre_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1.setBounds(38, 170, 253, 41);
		layeredPane.add(lblNombre_1);
		
		FechaCompra = new JTextField();
		  FechaCompra.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		  FechaCompra.setText(dtf2.format(LocalDateTime.now()));
		FechaCompra.setColumns(10);
		FechaCompra.setBounds(303, 170, 160, 41);
		layeredPane.add(FechaCompra);
		
		JLabel lblNombre_1_2 = new JLabel("Medida");
		lblNombre_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2.setBounds(489, 170, 124, 41);
		layeredPane.add(lblNombre_1_2);
		
		Medida = new JTextField();
		Medida.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		Medida.setColumns(10);
		Medida.setBounds(608, 172, 363, 41);
		layeredPane.add(Medida);
		
		JLabel lblNombre_1_3 = new JLabel("Fecha de Caducidad");
		lblNombre_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_3.setBounds(38, 282, 299, 41);
		layeredPane.add(lblNombre_1_3);
		
		FechaCaducidad = new JTextField();
		FechaCaducidad.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		FechaCaducidad.setText("YYYY-MM-DD");
		FechaCaducidad.setColumns(10);
		FechaCaducidad.setBounds(349, 282, 178, 41);
		layeredPane.add(FechaCaducidad);
		
		JLabel lblNombre_1_2_1 = new JLabel("Marca");
		lblNombre_1_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2_1.setBounds(38, 373, 124, 41);
		layeredPane.add(lblNombre_1_2_1);
		
		Marca = new JTextField();
		Marca.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		Marca.setColumns(10);
		Marca.setBounds(185, 373, 222, 41);
		layeredPane.add(Marca);
		
		JLabel lblNombre_1_2_1_1 = new JLabel("Precio de Compra");
		lblNombre_1_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNombre_1_2_1_1.setBounds(427, 373, 269, 41);
		layeredPane.add(lblNombre_1_2_1_1);
		
		PrecioCompra = new JTextField();
		PrecioCompra.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		PrecioCompra.setColumns(10);
		PrecioCompra.setBounds(735, 373, 222, 41);
		layeredPane.add(PrecioCompra);
		
		JButton btnNewButton = new JButton("Ingresar Insumos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//////Esto es el constructor para realizar la conexion entre la base de datos y java
				
				ConectarPosgres conn = new ConectarPosgres();
				try {
					PreparedStatement ps = conn.conexion.prepareStatement("INSERT INTO public.\"Insumo\"(\n"
							+ "	\"ID_Insumo\", \"Nombre_Insumo\", \"Stock_Insumo\", \"Stock_InsumoMinimo\")\n"
							+ "	VALUES ("+ID.getText()+", '"+Nombre.getText()+"', "+Stock.getText()+", "+StockMinimo.getText()+");\n"
							+ "INSERT INTO public.\"Detalle_Insumo\"(\n"
							+ "	\"ID_Insumo\", \"Fecha_Compra\", \"Medida_Insumo\", \"Marca_Insumo\", \"Fecha_Caducidad\", \"Precio_Compra\")\n"
							+ "	VALUES ("+ID.getText()+", '"+FechaCompra.getText()+"', '"+Medida.getText()+"', '"+Marca.getText()+"', '"+FechaCaducidad.getText()+"', '$"+PrecioCompra.getText()+"');");
					
			
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
		btnNewButton.setBounds(372, 480, 274, 73);
		layeredPane.add(btnNewButton);
		
		ID = new JTextField();
		ID.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		ID.setColumns(10);
		ID.setBounds(608, 19, 222, 41);
		layeredPane.add(ID);
		
		JLabel lblIdinsumo = new JLabel("ID del Insumo");
		lblIdinsumo.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblIdinsumo.setBounds(358, 17, 228, 41);
		layeredPane.add(lblIdinsumo);
	}
}

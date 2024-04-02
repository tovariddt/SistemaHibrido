package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Modelos.Gastos_Pagos;

public class PgReporteP extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Object[][] Gastos_Pagos= null;
	private ArrayList<Modelos.Gastos_Pagos> x = new ArrayList<Gastos_Pagos>();
	public JPanel contentPane;
	public Statement sentencia;
	public ResultSet resultado;
	String Cata;
	public JTextField FechaI;
	public JTextField FechaF;
	public  JTextField Fecha;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgReporteP frame = new PgReporteP();
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
	public PgReporteP() {
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
		
		DefaultTableModel modelo = new DefaultTableModel();
		  JTable table2 = new JTable( modelo);
		  table2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		  table2.setBackground(Color.WHITE);
		  table2.setColumnSelectionAllowed(true);
		  table2.setBounds(58, 570, 1325, -406);
		  layeredPane.add(table2);
		  JScrollPane Panel = new JScrollPane(table2);
		  Panel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		  Panel.setBounds(45, 71, 908, 305);
		  layeredPane.add(Panel);
		  		  
		  //////////////////////////////////////////////////////////////////////
		  
		   JTextField Fecha;
		    
		    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
		    
		    
		  Fecha = new JTextField();
		  Fecha.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		  Fecha.setText(dtf2.format(LocalDateTime.now()));
		  Fecha.setBounds(177, 17, 160, 42);
		  layeredPane.add(Fecha);
		  Fecha.setColumns(10);
		  
		  JLabel lblNewLabel = new JLabel("Fecha Actual");
		  lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		  lblNewLabel.setBounds(22, 17, 162, 42);
		  layeredPane.add(lblNewLabel);
		  
		  JButton btnNewButton_1 = new JButton("Consultar");
		  btnNewButton_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
			  	x.clear();

		  		ConectarPosgres conn = new ConectarPosgres();

			    try {
			    	sentencia = conn.conexion.createStatement();
			    
			        String sql = "SELECT \"ID_Gastos\", \"Fecha_Pagos\", \"Descripción_Pagos\", \"Personal_Pagos\", \"Monto_Pagos\", \"Unidad_Pagos\", \"Cantidad_Pagos\",\"Total_Gasto\"\n"
			        		+ "	FROM public.\"Gasto_Pagos\" NATURAL JOIN \"Gastos_General\";";
			        
			        resultado = sentencia.executeQuery(sql);
			      
			        
			        while (resultado.next()) {
			        	Gastos_Pagos gastos_pagos = new Gastos_Pagos();
			        	gastos_pagos.setID_Gastos((resultado.getString("ID_Gastos")));
			        	gastos_pagos.setFecha_Pagos((resultado.getString("Fecha_Pagos")));
			        	gastos_pagos.setDescripción_Pagos((resultado.getString("Descripción_Pagos")));
			        	gastos_pagos.setPersonal_Pagos((resultado.getString("Personal_Pagos")));
			        	gastos_pagos.setMonto_Pagos((resultado.getString("Monto_Pagos")));
			        	gastos_pagos.setUnidad_Pagos((resultado.getString("Unidad_Pagos")));
			        	gastos_pagos.setCantidad_Pagos((resultado.getString("Cantidad_Pagos")));
			        	gastos_pagos.setTotal_Gasto((resultado.getString("Cantidad_Pagos")));
			        		x.add(gastos_pagos); 
			        }

			        String titulos[]={ "ID del Gastos","Fecha del Pago", "Descripción del Pago", "Personal Pagado", "Monto de Pago","Unidad de Pagos","Cantidad de Pago" ,"Total del Gasto"};
			       
			  		  
			        String  matrizInfo[][]=new String[x.size()][8];

			        
  
			        
			  		  for (int i = 0; i < x.size(); i++) {
			  			  
			  		   matrizInfo[i][0]= x.get(i).getID_Gastos()+"";
			  		   matrizInfo[i][1]= x.get(i).getFecha_Pagos()+"";
			  		   matrizInfo[i][2]= x.get(i).getDescripción_Pagos()+"";
			  		   matrizInfo[i][3]= x.get(i).getPersonal_Pagos()+"";
			  		   matrizInfo[i][4]= x.get(i).getMonto_Pagos()+"";
			  		   matrizInfo[i][5]= x.get(i).getUnidad_Pagos()+"";
			  		   matrizInfo[i][6]= x.get(i).getCantidad_Pagos()+"";
			  		   matrizInfo[i][7]= x.get(i).getTotal_Gasto()+"";

			  		   

			  		  }

			        table2.setModel(new DefaultTableModel (matrizInfo,titulos));
 
			    } catch (Exception e1 ){
			        System.err.println("Error -> ");
			     
			    }
		
			
		}
		  		
		  });
		  btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  btnNewButton_1.setBounds(331, 388, 293, 42);
		  layeredPane.add(btnNewButton_1);
		  
		  JButton btnNewButton_1_1 = new JButton("Consultar con Fecha");
		  btnNewButton_1_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
			  	x.clear();

		  		ConectarPosgres conn = new ConectarPosgres();

			    try {
			    	sentencia = conn.conexion.createStatement();
			    
			        String sql = "SELECT \"ID_Gastos\", \"Fecha_Pagos\", \"Descripción_Pagos\", \"Personal_Pagos\", \"Monto_Pagos\", \"Unidad_Pagos\", \"Cantidad_Pagos\",\"Total_Gasto\""
			        		+ "	FROM public.\"Gasto_Pagos\"\n NATURAL JOIN \"Gastos_General\""
			        		+ "	Where \"Fecha_Pagos\">='"+FechaI.getText()+"' and \"Fecha_Pagos\"<='"+FechaF.getText()+"';";
			        
			        resultado = sentencia.executeQuery(sql);
			      
			        
			        while (resultado.next()) {
			        	Gastos_Pagos gastos_pagos = new Gastos_Pagos();
			        	gastos_pagos.setID_Gastos((resultado.getString("ID_Gastos")));
			        	gastos_pagos.setFecha_Pagos((resultado.getString("Fecha_Pagos")));
			        	gastos_pagos.setDescripción_Pagos((resultado.getString("Descripción_Pagos")));
			        	gastos_pagos.setPersonal_Pagos((resultado.getString("Personal_Pagos")));
			        	gastos_pagos.setMonto_Pagos((resultado.getString("Monto_Pagos")));
			        	gastos_pagos.setUnidad_Pagos((resultado.getString("Unidad_Pagos")));
			        	gastos_pagos.setCantidad_Pagos((resultado.getString("Cantidad_Pagos")));
			        	gastos_pagos.setTotal_Gasto((resultado.getString("Cantidad_Pagos")));

			        		x.add(gastos_pagos); 
			        }

			        String titulos[]={ "ID del Gastos","Fecha del Pago", "Descripción del Pago", "Personal Pagado", "Monto de Pago","Unidad de Pagos","Cantidad de Pago" ,"Total del Gasto"};
			       
			  		  
			        String  matrizInfo[][]=new String[x.size()][8];

			        
  
			        
			  		  for (int i = 0; i < x.size(); i++) {
			  			  
				  		   matrizInfo[i][0]= x.get(i).getID_Gastos()+"";
				  		   matrizInfo[i][1]= x.get(i).getFecha_Pagos()+"";
				  		   matrizInfo[i][2]= x.get(i).getDescripción_Pagos()+"";
				  		   matrizInfo[i][3]= x.get(i).getPersonal_Pagos()+"";
				  		   matrizInfo[i][4]= x.get(i).getMonto_Pagos()+"";
				  		   matrizInfo[i][5]= x.get(i).getUnidad_Pagos()+"";
				  		   matrizInfo[i][6]= x.get(i).getCantidad_Pagos()+"";
				  		   matrizInfo[i][7]= x.get(i).getTotal_Gasto()+"";

			  		  }

			        table2.setModel(new DefaultTableModel (matrizInfo,titulos));
 
			    } catch (Exception e1 ){
			        System.err.println("Error -> ");
			     
			    }
		
			
		}
		  		
		  		
		  	
		  });
		  btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  btnNewButton_1_1.setBounds(618, 454, 261, 36);
		  layeredPane.add(btnNewButton_1_1);
		  
		  JLabel lblUsuarios = new JLabel("Reporte de Pagos");
		  lblUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		  lblUsuarios.setBounds(349, 6, 261, 59);
		  layeredPane.add(lblUsuarios);
		  
		  FechaI = new JTextField();
		  FechaI.setText("0000-00-00");
		  FechaI.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  FechaI.setColumns(10);
		  FechaI.setBounds(174, 451, 139, 42);
		  layeredPane.add(FechaI);
		  
		  JLabel lblIdDelGasto = new JLabel("Fecha Inicial");
		  lblIdDelGasto.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblIdDelGasto.setBounds(45, 442, 139, 59);
		  layeredPane.add(lblIdDelGasto);
		  
		  FechaF = new JTextField();
		  FechaF.setText("0000-00-00");
		  FechaF.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  FechaF.setColumns(10);
		  FechaF.setBounds(449, 451, 150, 42);
		  layeredPane.add(FechaF);
		  
		  JLabel lblElemetoAModificar = new JLabel("Fecha Final");
		  lblElemetoAModificar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblElemetoAModificar.setBounds(331, 442, 116, 59);
		  layeredPane.add(lblElemetoAModificar);
		  
		  JButton btnNewButton_1_2 = new JButton("Imprimir Reporte");
		  btnNewButton_1_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		File file = new File("/Users/israeldaviddomingueztovar/Desktop/Reportes/ReportePagos"+Fecha.getText()+".pdf"); ;
		  		
			      Document document = new Document();

			
			
						try {
							
						
						  	FileOutputStream	fs = new FileOutputStream(file);
							
						
						  
						            PdfWriter.getInstance(document,fs);
						            
						            document.open();
						            
						            document.add(new Paragraph("Reporte de Pagos"));
						            
						            document.add(new Paragraph("                                                                "));
						            PdfPTable table = new PdfPTable(8);
						       
						            table.setHorizontalAlignment(Element.ALIGN_LEFT);
						            table.getDefaultCell().setBorder(2);
						            table.setTotalWidth(0);
						            

						            
						            table.addCell(new PdfPCell(new Paragraph("ID del Gastos")));
		                        	 table.addCell(new PdfPCell(new Paragraph("Fecha del Pago")));
		                        	 table.addCell(new PdfPCell(new Paragraph("Descripción del Pago")));
		                        	 table.addCell(new PdfPCell(new Paragraph("Personal Pagado")));
		                        	 table.addCell(new PdfPCell(new Paragraph("Monto de Pago")));
		                     
		                        	 table.addCell(new PdfPCell(new Paragraph("Unidad de Pagos")));
		                        	 table.addCell(new PdfPCell(new Paragraph("Cantidad de Pago")));
		                        	 table.addCell(new PdfPCell(new Paragraph("Total del Gasto")));

		                        	

		                         for (int i = 0; i<x.size(); i++){ 


		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getID_Gastos())));
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getFecha_Pagos())));
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getDescripción_Pagos())));
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getPersonal_Pagos())));
		                     
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getMonto_Pagos())));
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getUnidad_Pagos())));
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getCantidad_Pagos())));
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getTotal_Gasto())));

		                        	
						            	
		      			
								           
		                         }
						     
						         
						          
						          
						           
						          
						           
						      
						       
					      document.add(table);
			        } catch (DocumentException de) {
			            System.err.println(de.getMessage());
			        } catch (IOException ioe) {
			            System.err.println(ioe.getMessage());
			        }
			       
			        
			        document.close();
			       
			    
		  	}
		  });
		  btnNewButton_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  btnNewButton_1_2.setBounds(331, 526, 293, 42);
		  layeredPane.add(btnNewButton_1_2);
	}

}
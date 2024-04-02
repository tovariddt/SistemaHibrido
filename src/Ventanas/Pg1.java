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
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
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

import Modelos.Ganancias;
import java.awt.Component;

public class Pg1 extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Object[][] Ganancias= null;
	private ArrayList<Modelos.Ganancias> x = new ArrayList<Ganancias>();
	private ArrayList<Modelos.Ganancias> y = new ArrayList<Ganancias>();

	public JPanel contentPane;
	public Statement sentencia;
	public Statement sentencia1;
	public Statement sentencia2;
	public Statement sentencia3;
	public Double Stotal;

	public ResultSet resultado;
	public ResultSet resultado1;
	public ResultSet resultado2;
	public ResultSet resultado3;

	 public double Decimal;
	String Cata;
	public JTextField FechaI;
	public JTextField FechaF;
	public  JTextField Fecha;
	public JTable table1; 
	public Double Sventa;
	public  Double Sgasto;
	public JTextField TotalS;
	public JTextField Tgasto;
	public JTextField Tventa;
    public double sub1;
public    double sub2;
public String Cosa;				           

public String CTventa;				           

public String CTgasto;	

public String sSubCadena1;
public String sSubCadena2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pg1 frame = new Pg1();
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
	public Pg1() {
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
		  Panel.setBounds(99, 58, 854, 168);
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
		  
		  JButton btnNewButton_1_1 = new JButton("Consultar con Fecha");
		  btnNewButton_1_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
			  	x.clear();
			  	y.clear();


		  		ConectarPosgres conn = new ConectarPosgres();

			    try {
			    	sentencia = conn.conexion.createStatement();
			    
			        String sql = "SELECT \"ID_Ganancias\", \"ID_Gastos\", \"Nombre_Gasto\", \"Fecha_Ganancia\" ,\"Total_Gasto\"\n"
			        		+ "	FROM public.\"Ganancias\" Natural Join \"Gastos_General\""
			        		+ "	Where \"Fecha_Ganancia\">='"+FechaI.getText()+"' and \"Fecha_Ganancia\"<='"+FechaF.getText()+"';";
			        
			        resultado = sentencia.executeQuery(sql);
			      
			        
			        while (resultado.next()) {
			        	Ganancias gasto = new Ganancias();
			        	gasto.setID_Ganancias((resultado.getString("ID_Ganancias")));
			        	gasto.setID_Gastos((resultado.getString("ID_Gastos")));
			        	gasto.setNombre_Gasto((resultado.getString("Nombre_Gasto")));

			        	gasto.setFecha_Ganancias((resultado.getString("Fecha_Ganancia")));
			        	gasto.setTotal_Gasto((resultado.getString("Total_Gasto")));
			        		x.add(gasto); 
			        }

			        String titulos[]={ "ID de Ganancias","ID del Gastos", "Nombre del Gasto", "Fecha", "Total del Gasto" };
			       
			  		  
			        String  matrizInfo[][]=new String[x.size()][5];

			  		  for (int i = 0; i < x.size(); i++) {
			  			  
			  		   matrizInfo[i][0]= x.get(i).getID_Ganancias()+"";
			  		   matrizInfo[i][1]= x.get(i).getID_Gastos()+"";
			  		   matrizInfo[i][2]= x.get(i).getNombre_Gasto()+"";
			  		   matrizInfo[i][3]= x.get(i).getFecha_Ganancias()+"";
			  		   matrizInfo[i][4]= x.get(i).getTotal_Gasto()+"";
			  		   
			  		   

			  		  }

			        table2.setModel(new DefaultTableModel (matrizInfo,titulos));
 ///7
			    } catch (Exception e1 ){
			        System.err.println("Error -> ");
			     
			    }
			    
			    try {
			    	sentencia1 = conn.conexion.createStatement();
			    
			        String sql1 = "SELECT \"Fecha_Ganancia\", \"ID_Gastos\", \"ID_Venta\",\"Nombre_Venta\",\"Total_Venta\", \"ID_Ganancias\"\n"
			        		+ "	FROM public.\"Ganancias\" Natural Join \"Venta\""
			        		+ "	Where \"Fecha_Ganancia\">='"+FechaI.getText()+"' and \"Fecha_Ganancia\"<='"+FechaF.getText()+"';";
			        
			        resultado1 = sentencia1.executeQuery(sql1);
			      
			        
			        while (resultado1.next()) {
			        	Ganancias venta = new Ganancias();
			        	venta.setID_Ganancias((resultado1.getString("ID_Ganancias")));
			        	venta.setID_Venta((resultado1.getString("ID_Venta")));
			        	venta.setNombre_Venta((resultado1.getString("Nombre_Venta")));

			        	venta.setFecha_Ganancias((resultado1.getString("Fecha_Ganancia")));
			        	venta.setTotal_Venta((resultado1.getString("Total_Venta")));
			        		y.add(venta); 
			        }

			        String titulos1[]={ "ID de Ganancias","ID de la Venta", "Nombre de la Venta", "Fecha", "Total de la Venta" };
			       
			  		  
			        String  matrizInfo1[][]=new String[y.size()][5];

			  		  for (int i = 0; i < y.size(); i++) {
			  			  
			  		   matrizInfo1[i][0]= y.get(i).getID_Ganancias()+"";
			  		   matrizInfo1[i][1]= y.get(i).getID_Venta()+"";
			  		   matrizInfo1[i][2]= y.get(i).getNombre_Venta()+"";
			  		   matrizInfo1[i][3]= y.get(i).getFecha_Ganancias()+"";
			  		   matrizInfo1[i][4]= y.get(i).getTotal_Venta()+"";
			  		   
			  		   

			  		  }

			        table1.setModel(new DefaultTableModel (matrizInfo1,titulos1));
 
			    } catch (Exception e1 ){
			        System.err.println("Error -> ");
			     
			    }
			    
			    try {
			    sentencia2 = conn.conexion.createStatement();
			    
		        String sql2 = "SELECT SUM (\"Total_Venta\") as \"SVenta\" FROM public.\"Venta\" Where \"Fecha_Venta\">='"+FechaI.getText()+"' AND \"Fecha_Venta\"<='"+FechaF.getText()+"' ;";
		        
		        
		        
		        resultado2 = sentencia2.executeQuery(sql2);
		      
		        
		        while (resultado2.next()) {
		        	
		        	Tventa.setText(resultado2.getString("SVenta"));				           

		        }
			    } catch (Exception e1 ){
			        System.err.println("Error -> ");
			     
			    }
			    
			    try {
				    sentencia3 = conn.conexion.createStatement();
				    
			        String sql3 = "SELECT SUM (\"Total_Gasto\") as \"SGasto\" FROM public.\"Gastos_General\" Where \"Fecha_Gasto\">='"+FechaI.getText()+"' AND \"Fecha_Gasto\"<='"+FechaF.getText()+"' ;";
			        
			        
			        
			        resultado3 = sentencia3.executeQuery(sql3);
			      
			        
			        while (resultado3.next()) {
			        	
			        	Tgasto.setText(resultado3.getString("SGasto"));				           

			        }
				    } catch (Exception e1 ){
				        System.err.println("Error -> ");
				     
				    }
			    
			    String CTventa=Tventa.getText();				           

			    String CTgasto=Tgasto.getText();	
			    
			    String sSubCadena1 = CTventa.substring(1,CTventa.length());
			    String sSubCadena2 = CTgasto.substring(1,CTgasto.length());
			   
			    sSubCadena1 = sSubCadena1.replace(",", ""); 
			    sSubCadena2 = sSubCadena2.replace(",", ""); 


			     sub1 =Double.parseDouble(sSubCadena1);
			     sub2 =Double.parseDouble(sSubCadena2);
			    

			     
			

			     
			    if (sub1>sub2) 
			    { 
			      
				    Decimal = Double.parseDouble(sSubCadena1)-Double.parseDouble(sSubCadena2);
				    Cosa="Ganancia";				           

			    } 
			    else 
			    { 
				    Decimal = Double.parseDouble(sSubCadena2)-Double.parseDouble(sSubCadena1);
				    Cosa="Perdida";				           

			    }
			    TotalS.setText("La "+Cosa+" optenida entre las fechas "+FechaI.getText()+" a "+FechaF.getText()+" son $"+String.valueOf(Decimal)+"");				           
			    		           

		}  		 	
		  });
		  btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  btnNewButton_1_1.setBounds(606, 493, 261, 36);
		  layeredPane.add(btnNewButton_1_1);
		  
		  JLabel lblUsuarios = new JLabel("Ganancias o Perdidas");
		  lblUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		  lblUsuarios.setBounds(405, 0, 317, 59);
		  layeredPane.add(lblUsuarios);
		  
		  FechaI = new JTextField();
		  FechaI.setText("0000-00-00");
		  FechaI.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  FechaI.setColumns(10);
		  FechaI.setBounds(177, 490, 139, 42);
		  layeredPane.add(FechaI);
		  
		  JLabel lblIdDelGasto = new JLabel("Fecha Inicial");
		  lblIdDelGasto.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblIdDelGasto.setBounds(45, 481, 139, 59);
		  layeredPane.add(lblIdDelGasto);
		  
		  FechaF = new JTextField();
		  FechaF.setText("0000-00-00");
		  FechaF.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  FechaF.setColumns(10);
		  FechaF.setBounds(434, 490, 150, 42);
		  layeredPane.add(FechaF);
		  
		  JLabel lblElemetoAModificar = new JLabel("Fecha Final");
		  lblElemetoAModificar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblElemetoAModificar.setBounds(321, 481, 116, 59);
		  layeredPane.add(lblElemetoAModificar);
		  
		  JButton btnNewButton_1_2 = new JButton("Imprimir Reporte");
		  btnNewButton_1_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		File file = new File("/Users/israeldaviddomingueztovar/Desktop/Reportes/Reporte"+Cosa+""+Fecha.getText()+".pdf"); ;
		  		
			      Document document = new Document();

			
			
						try {
							
						
						  	FileOutputStream	fs = new FileOutputStream(file);
							
						
						  
						            PdfWriter.getInstance(document,fs);
						            
						            document.open();
						            
						            document.add(new Paragraph("Reporte de "+Cosa+" optenida entre las fechas "+FechaI.getText()+" a "+FechaF.getText()+" son $"+String.valueOf(Decimal)+""));
						            
						            document.add(new Paragraph("                                                                "));
						            document.add(new Paragraph("Reporte de Gastos"));
						            document.add(new Paragraph("                                                                "));


						            PdfPTable table = new PdfPTable(5);
						            table.setHorizontalAlignment(Element.ALIGN_LEFT);
						            table.getDefaultCell().setBorder(2);
						            table.setTotalWidth(0);
						            
						     
						  


						            
						            table.addCell(new PdfPCell(new Paragraph("ID de Ganancias")));
		                        	 table.addCell(new PdfPCell(new Paragraph("ID del Gastos")));
		                        	 table.addCell(new PdfPCell(new Paragraph("Nombre del Gasto")));
		                        	 table.addCell(new PdfPCell(new Paragraph("Fecha")));
		                        	 table.addCell(new PdfPCell(new Paragraph("Total del Gasto")));
		                        	
		                        	

		                         for (int i = 0; i<x.size(); i++){ 

		                        	 
		    			  		   

		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getID_Ganancias())));
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getID_Gastos())));
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getNombre_Gasto())));
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getFecha_Ganancias())));
		                     
		                        	 table.addCell(new PdfPCell(new Paragraph(x.get(i).getTotal_Gasto())));  
								           
		                         }
						           
							      document.add(table);

		                         
		                            document.add(new Paragraph("                                                                "));
						            document.add(new Paragraph("Reporte de Ventas"));
						            document.add(new Paragraph("                                                                "));


						            PdfPTable table1 = new PdfPTable(5);
						       
						            table1.setHorizontalAlignment(Element.ALIGN_LEFT);
						            table1.getDefaultCell().setBorder(2);
						            table1.setTotalWidth(0);
						            
						     
						  


						            
						            table1.addCell(new PdfPCell(new Paragraph("ID de Ganancias")));
		                        	 table1.addCell(new PdfPCell(new Paragraph("ID del Venta")));
		                        	 table1.addCell(new PdfPCell(new Paragraph("Nombre de la Venta")));
		                        	 table1.addCell(new PdfPCell(new Paragraph("Fecha")));
		                     
		                        	 table1.addCell(new PdfPCell(new Paragraph("Total de la Venta")));
		                        	
		                        	

		                         for (int a = 0; a<y.size(); a++){ 
		                        	 table1.addCell(new PdfPCell(new Paragraph(y.get(a).getID_Ganancias())));
		                        	 table1.addCell(new PdfPCell(new Paragraph(y.get(a).getID_Venta())));
		                        	 table1.addCell(new PdfPCell(new Paragraph(y.get(a).getNombre_Venta())));
		                        	 table1.addCell(new PdfPCell(new Paragraph(y.get(a).getFecha_Ganancias())));
		                     
		                        	 table1.addCell(new PdfPCell(new Paragraph(y.get(a).getTotal_Venta())));  
        
		                         }
								      
		               
							      document.add(table1);
							      
						            document.add(new Paragraph("                                                                "));


							      
						            document.add(new Paragraph("El toltal de las VENTAS fueron "+Tventa.getText()+" y el total de los GASTOS fueron "+Tgasto.getText()+""));

						          
						          
						           
						          
						           
						      
						       
			        } catch (DocumentException de) {
			            System.err.println(de.getMessage());
			        } catch (IOException ioe) {
			            System.err.println(ioe.getMessage());
			        }
			       
			        
			        document.close();
			       
			    
		  	}
		  });
		  btnNewButton_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  btnNewButton_1_2.setBounds(331, 545, 293, 42);
		  layeredPane.add(btnNewButton_1_2);
		  
		  JScrollPane Panel2 = new JScrollPane((Component) null);
		  Panel2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		  Panel2.setBounds(99, 224, 854, 168);
		  layeredPane.add(Panel2);
		  
		  table1 = new JTable();
		  table1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		  Panel2.setViewportView(table1);
		
		  JLabel lblNewLabel_1 = new JLabel("Gastos");
		  lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		  lblNewLabel_1.setBounds(6, 121, 90, 59);
		  layeredPane.add(lblNewLabel_1);
		  
		  JLabel lblNewLabel_1_1 = new JLabel("Ventas");
		  lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		  lblNewLabel_1_1.setBounds(6, 276, 90, 59);
		  layeredPane.add(lblNewLabel_1_1);
		  
		  JLabel lblNewLabel_1_1_1 = new JLabel("Resumen");
		  lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblNewLabel_1_1_1.setBounds(6, 376, 90, 59);
		  layeredPane.add(lblNewLabel_1_1_1);
		  
		  TotalS = new JTextField();
		  TotalS.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		  TotalS.setBounds(99, 387, 854, 42);
		  layeredPane.add(TotalS);
		  TotalS.setColumns(10);
		  
		  Tgasto = new JTextField();
		  Tgasto.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		  Tgasto.setColumns(10);
		  Tgasto.setBounds(714, 441, 100, 42);
		  layeredPane.add(Tgasto);
		  
		  Tventa = new JTextField();
		  Tventa.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		  Tventa.setColumns(10);
		  Tventa.setBounds(405, 441, 108, 42);
		  layeredPane.add(Tventa);
		  
		  JLabel lblNewLabel_2_1 = new JLabel("Gastos Optenidos");
		  lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		  lblNewLabel_2_1.setBounds(551, 451, 160, 22);
		  layeredPane.add(lblNewLabel_2_1);
		  
		  JLabel lblNewLabel_2_1_1 = new JLabel("Ventas Optenidas");
		  lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		  lblNewLabel_2_1_1.setBounds(241, 451, 172, 22);
		  layeredPane.add(lblNewLabel_2_1_1);
		  
	
	}
}
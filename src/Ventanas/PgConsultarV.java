package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Modelos.Venta;

public class PgConsultarV extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Object[][] Venta= null;
	private ArrayList<Modelos.Venta> x = new ArrayList<Venta>();
	public JPanel contentPane;
	public Statement sentencia;
	public ResultSet resultado;
	String Cata;
	private JTextField ID;
	private JTextField New;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgConsultarV frame = new PgConsultarV();
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
	public PgConsultarV() {
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
		  
		   JTextField textField;
		    
		    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy-MM-dd");
		 
			JComboBox<String> MOD = new JComboBox<String>();
			MOD.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			MOD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String Catalogo=(String) MOD.getSelectedItem();
					switch(Catalogo) {
					  case "Nombre":
						  Cata="\"Nombre_Venta\"";
					    break;
					  case "Fecha":
						  Cata="\"Fecha_Venta\"";
							
						    break;
					  case "Unidad":
						  Cata="\"Unidad_Venta\"";
						  break;
					  case "Monto":
						  Cata="\"Monto_Venta\"";
							
						    break;
					  case "Cantidad":
						  Cata="\"Cantidad_Venta\"";
						    break;
					  case "Total":
						  Cata="\"Total_Venta\"";
							
						   
					  default:}
				}
			});
			MOD.setBounds(370, 478, 202, 52);
			layeredPane.add(MOD);
			MOD.addItem("Nombre");
			MOD.addItem("Fecha");
			MOD.addItem("Unidad");
			MOD.addItem("Monto");
			MOD.addItem("Cantidad");
			MOD.addItem("Total");
	
	
		    
		    
		  textField = new JTextField();
		  textField.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		  textField.setText(dtf2.format(LocalDateTime.now()));
		  textField.setBounds(177, 17, 127, 42);
		  layeredPane.add(textField);
		  textField.setColumns(10);
		  
		  JLabel lblNewLabel = new JLabel("Fecha Actual");
		  lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		  lblNewLabel.setBounds(22, 17, 162, 42);
		  layeredPane.add(lblNewLabel);
		  
		  JButton btnNewButton_1 = new JButton("Modificar");
		  btnNewButton_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
				ConectarPosgres conn = new ConectarPosgres();
				try {
					PreparedStatement ps = conn.conexion.prepareStatement("UPDATE public.\"Venta\"\n"
							+ "	SET "+Cata+"='"+New.getText()+"'\n"
							+ "	WHERE \"ID_Venta\" = ' "+ID.getText()+"';");
					
			
					int x =  ps.executeUpdate();
								
					if (x > 0) {
					
						 JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
						
					}
							
							
				} catch (SQLException e1) {
					e1.printStackTrace();
			 JOptionPane.showMessageDialog(null, "Operación no ha sido realizada correctamente");
				}
		  		
		  	}
		  });
		  btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  btnNewButton_1.setBounds(595, 528, 128, 42);
		  layeredPane.add(btnNewButton_1);
		  
		  JButton btnNewButton_1_1 = new JButton("Consultar");
		  btnNewButton_1_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		ConectarPosgres conn = new ConectarPosgres();

			    try {
			    	sentencia = conn.conexion.createStatement();
			    
			        String sql = "SELECT \"ID_Venta\", \"Nombre_Venta\", \"Fecha_Venta\", \"Unidad_Venta\", \"Monto_Venta\", \"Cantidad_Venta\",\"Total_Venta\"\n"
			        		+ "	FROM public.\"Venta\";";
			        
			        resultado = sentencia.executeQuery(sql);
			      
			        
			        while (resultado.next()) {
			        	Venta venta = new Venta();
			        	venta.setID_Venta((resultado.getString("ID_Venta")));
			        	venta.setNombre_Venta((resultado.getString("Nombre_Venta")));
			        	venta.setFecha_Venta((resultado.getString("Fecha_Venta")));
			        	venta.setUnidad_Venta((resultado.getString("Unidad_Venta")));
			        	venta.setMonto_Venta((resultado.getString("Monto_Venta")));
			        	venta.setCantidad_Venta((resultado.getString("Cantidad_Venta")));
			        	venta.setTotal_Venta((resultado.getString("Total_Venta")));
			        	
		
			        
			        		x.add(venta); 
			        }

			        String titulos[]={ "ID de la Venta", "Nombre de la Venta","Fecha de la Venta", "Unidad de Venta","Monto de Venta","Cantidad_Venta","Total de Venta" };
			       
			  		  
			        String  matrizInfo[][]=new String[x.size()][7];

			        
  
			        
			  		  for (int i = 0; i < x.size(); i++) {
			  			  
			  		   matrizInfo[i][0]= x.get(i).getID_Venta()+"";
			  		   matrizInfo[i][1]= x.get(i).getNombre_Venta()+"";
			  		   matrizInfo[i][2]= x.get(i).getFecha_Venta()+"";
			  		   matrizInfo[i][3]= x.get(i).getUnidad_Venta()+"";
			  		   matrizInfo[i][4]= x.get(i).getMonto_Venta()+"";
			  		   matrizInfo[i][5]= x.get(i).getCantidad_Venta()+"";
			  		   matrizInfo[i][6]= x.get(i).getTotal_Venta()+"";

			  		  }
				  	x.clear();

			        table2.setModel(new DefaultTableModel (matrizInfo,titulos));
 
			    } catch (Exception e1 ){
			        System.err.println("Error -> ");
			     
			    }
		
			
		}
		  		
		  		
		  	
		  });
		  btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  btnNewButton_1_1.setBounds(392, 376, 138, 36);
		  layeredPane.add(btnNewButton_1_1);
		  
		  JLabel lblUsuarios = new JLabel("Consultar Venta");
		  lblUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		  lblUsuarios.setBounds(316, 6, 274, 59);
		  layeredPane.add(lblUsuarios);
		  
		  ID = new JTextField();
		  ID.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  ID.setColumns(10);
		  ID.setBounds(412, 424, 100, 42);
		  layeredPane.add(ID);
		  
		  JLabel lblIdDelGasto = new JLabel("ID del Gasto");
		  lblIdDelGasto.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblIdDelGasto.setBounds(265, 415, 138, 59);
		  layeredPane.add(lblIdDelGasto);
		  
		  New = new JTextField();
		  New.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  New.setColumns(10);
		  New.setBounds(370, 528, 202, 42);
		  layeredPane.add(New);
		  
		  JLabel lblElemetoAModificar = new JLabel("Elemeto a Modificar");
		  lblElemetoAModificar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblElemetoAModificar.setBounds(156, 473, 202, 59);
		  layeredPane.add(lblElemetoAModificar);
		  
		  JLabel lblNuevoElmento = new JLabel("Nuevo Elmento ");
		  lblNuevoElmento.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblNuevoElmento.setBounds(204, 519, 156, 59);
		  layeredPane.add(lblNuevoElmento);
	}

}


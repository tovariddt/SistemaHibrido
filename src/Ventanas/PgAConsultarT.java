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

import Modelos.Gastos_Tarea;

public class PgAConsultarT extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Object[][] Gastos_Tarea= null;
	private ArrayList<Modelos.Gastos_Tarea> x = new ArrayList<Gastos_Tarea>();
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
					PgAConsultarT frame = new PgAConsultarT();
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
	public PgAConsultarT() {
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
			    
			        String sql = "SELECT \"ID_Gastos\", \"Descripción_Tarea\", \"Fecha_Tarea\", \"Personal_Tarea\" ,\"Total_Gasto\"\n"
			        		+ "	FROM public.\"Gasto_Tarea\" natural Join \"Gastos_General\";";
			        
			        resultado = sentencia.executeQuery(sql);
			      
			        
			        while (resultado.next()) {
			        	Gastos_Tarea gastos_tarea = new Gastos_Tarea();
			        	gastos_tarea.setID_Gastos((resultado.getString("ID_Gastos")));
			        	gastos_tarea.setDescripcion_Tareas((resultado.getString("Descripción_Tarea")));
			        	gastos_tarea.setFecha_Tarea((resultado.getString("Fecha_Tarea")));
			        	gastos_tarea.setPersonal_Tarea((resultado.getString("Personal_Tarea")));
			        	gastos_tarea.setTotal_Gasto((resultado.getString("Total_Gasto")));
			        		x.add(gastos_tarea); 
			        }

			        String titulos[]={ "ID del Gastos", "Descripción de la Tarea","Fecha de Tarea" , "Personal Tarea","Total del Gasto"};
			       
			  		  
			        String  matrizInfo[][]=new String[x.size()][5];

			        
  
			        
			  		  for (int i = 0; i < x.size(); i++) {
			  			  
			  		   matrizInfo[i][0]= x.get(i).getID_Gastos()+"";
			  		   matrizInfo[i][1]= x.get(i).getDescripcion_Tareas()+"";
			  		   matrizInfo[i][2]= x.get(i).getFecha_Tarea()+"";
			  		   matrizInfo[i][3]= x.get(i).getPersonal_Tarea()+"";
			  		   matrizInfo[i][4]= x.get(i).getTotal_Gasto()+"";

			  		   

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
			    
			        String sql = "SELECT \"ID_Gastos\", \"Descripción_Tarea\", \"Fecha_Tarea\", \"Personal_Tarea\" ,\"Total_Gasto\"\n"
			        		+ "	FROM public.\"Gasto_Tarea\" natural Join \"Gastos_General\""
			        		+ "	Where \"Fecha_Tarea\">='"+FechaI.getText()+"' and \"Fecha_Tarea\"<='"+FechaF.getText()+"';";
			        
			        resultado = sentencia.executeQuery(sql);
			      
			        while (resultado.next()) {
			        	Gastos_Tarea gastos_tarea = new Gastos_Tarea();
			        	gastos_tarea.setID_Gastos((resultado.getString("ID_Gastos")));
			        	gastos_tarea.setDescripcion_Tareas((resultado.getString("Descripción_Tarea")));
			        	gastos_tarea.setFecha_Tarea((resultado.getString("Fecha_Tarea")));
			        	gastos_tarea.setPersonal_Tarea((resultado.getString("Personal_Tarea")));
			        	gastos_tarea.setTotal_Gasto((resultado.getString("Total_Gasto")));
			        		x.add(gastos_tarea); 
			        }

			        String titulos[]={ "ID del Gastos", "Descripción de la Tarea","Fecha de Tarea" , "Personal Tarea","Total del Gasto"};
			       
			  		  
			        String  matrizInfo[][]=new String[x.size()][5];

			        
  
			        
			  		  for (int i = 0; i < x.size(); i++) {
			  			  
			  		   matrizInfo[i][0]= x.get(i).getID_Gastos()+"";
			  		   matrizInfo[i][1]= x.get(i).getDescripcion_Tareas()+"";
			  		   matrizInfo[i][2]= x.get(i).getFecha_Tarea()+"";
			  		   matrizInfo[i][3]= x.get(i).getPersonal_Tarea()+"";
			  		   matrizInfo[i][4]= x.get(i).getTotal_Gasto()+"";


			  		  }

			        table2.setModel(new DefaultTableModel (matrizInfo,titulos));
 
			    } catch (Exception e1 ){
			        System.err.println("Error -> ");
			     
			    }
		
			
		}
		  		
		  		
		  	
		  });
		  btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  btnNewButton_1_1.setBounds(349, 525, 261, 36);
		  layeredPane.add(btnNewButton_1_1);
		  
		  JLabel lblUsuarios = new JLabel("Consultar Tareas");
		  lblUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		  lblUsuarios.setBounds(349, 6, 286, 59);
		  layeredPane.add(lblUsuarios);
		  
		  FechaI = new JTextField();
		  FechaI.setText("0000-00-00");
		  FechaI.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  FechaI.setColumns(10);
		  FechaI.setBounds(351, 451, 139, 42);
		  layeredPane.add(FechaI);
		  
		  JLabel lblIdDelGasto = new JLabel("Fecha Inicial");
		  lblIdDelGasto.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblIdDelGasto.setBounds(212, 442, 139, 59);
		  layeredPane.add(lblIdDelGasto);
		  
		  FechaF = new JTextField();
		  FechaF.setText("0000-00-00");
		  FechaF.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  FechaF.setColumns(10);
		  FechaF.setBounds(671, 451, 150, 42);
		  layeredPane.add(FechaF);
		  
		  JLabel lblElemetoAModificar = new JLabel("Fecha Final");
		  lblElemetoAModificar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		  lblElemetoAModificar.setBounds(553, 442, 116, 59);
		  layeredPane.add(lblElemetoAModificar);
	}

}
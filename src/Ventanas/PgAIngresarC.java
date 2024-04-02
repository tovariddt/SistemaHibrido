package Ventanas;

import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;

import Modelos.Insumo;

public class PgAIngresarC extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgAIngresarC frame = new PgAIngresarC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	  private JTextField textField1;
		public JTextField Cantidad;
	    
		public Statement sentencia;
		public ResultSet resultado;
		
	    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    public JTextField FechaCompra;
	    public JTextField Medida;
	    public JTextField FechaCaducidad;
	    public JTextField Marca;
	    public JTextField PrecioCompra;
	    public JTextField ID;
	    public JTextField Total;
	    public JTextField IDG;
	    public JTextField StockA;
	    public JTextField NombreIn;
	   public JTextField NCantidad;
	   public JTextField IDU;


	/**
	 * Create the frame.
	 */
		public PgAIngresarC() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
					

		//Esto es el menu 
			
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
			
			
				
				//Estas son las partes de donde se extrae a informacion todas deben ser publicas 
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JLayeredPane layeredPane = new JLayeredPane();
			contentPane.add(layeredPane, BorderLayout.CENTER);
			
			JLabel lblIngresarInsumos = new JLabel("Ingresar Compra");
			lblIngresarInsumos.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblIngresarInsumos.setBounds(38, 6, 253, 63);
			layeredPane.add(lblIngresarInsumos);
			
			JLabel lblS = new JLabel("Cantidad");
			lblS.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblS.setBounds(38, 373, 137, 41);
			layeredPane.add(lblS);
			
			Cantidad = new JTextField();
			Cantidad.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			Cantidad.setColumns(10);
			Cantidad.setBounds(194, 373, 111, 41);
			layeredPane.add(Cantidad);
			
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
			Medida.setBounds(608, 172, 307, 41);
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
			lblNombre_1_2_1.setBounds(569, 282, 124, 41);
			layeredPane.add(lblNombre_1_2_1);
			
			Marca = new JTextField();
			Marca.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			Marca.setColumns(10);
			Marca.setBounds(704, 284, 199, 41);
			layeredPane.add(Marca);
			
			JLabel lblNombre_1_2_1_1 = new JLabel("Precio de Compra");
			lblNombre_1_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNombre_1_2_1_1.setBounds(375, 373, 269, 41);
			layeredPane.add(lblNombre_1_2_1_1);
			
			PrecioCompra = new JTextField();
			PrecioCompra.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			PrecioCompra.setColumns(10);
			PrecioCompra.setBounds(642, 375, 111, 41);
			layeredPane.add(PrecioCompra);
			
			JButton btnNewButton = new JButton("Ingresar Compra");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
				
					
					//////Esto es el constructor para realizar la conexion entre la base de datos y java
					
					
					
					ConectarPosgres conn = new ConectarPosgres();
					try {
				        
						PreparedStatement ps = conn.conexion.prepareStatement("INSERT INTO public.\"Gastos_General\"(\n"
								+ "	\"ID_Gastos\", \"Nombre_Gasto\", \"Fecha_Gasto\", \"Tipo_Gasto\", \"Total_Gasto\", \"ID_Usuario\", \"ID_Insumo\")\n"
								+ "	VALUES ("+IDG.getText()+",'Compra de Insumo' , '"+FechaCompra.getText()+"','Compra','$"+Total.getText()+"', "+IDU.getText()+", "+ID.getText()+");"
								
								+ "INSERT INTO public.\"Detalle_Insumo\"(\n"
								+ "	\"ID_Insumo\", \"Fecha_Compra\", \"Medida_Insumo\", \"Marca_Insumo\", \"Fecha_Caducidad\", \"Precio_Compra\")\n"
								+ "	VALUES ("+ID.getText()+", '"+FechaCompra.getText()+"', '"+Medida.getText()+"', '"+Marca.getText()+"', '"+FechaCaducidad.getText()+"', '$"+PrecioCompra.getText()+"');"
										
								
								+ "UPDATE public.\"Insumo\" SET \"Stock_Insumo\"="+NCantidad.getText()+" WHERE \"ID_Insumo\"="+ID.getText()+";"
								
								+ "INSERT INTO public.\"Ganancias\"(\n"
								+ "	\"Fecha_Ganancia\", \"ID_Gastos\", \"ID_Venta\",\"ID_Ganancias\")\n"
								+ "	VALUES ('"+FechaCompra.getText()+"',"+IDG.getText()+", null, DEFAULT);"		);
									
						
						

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
			btnNewButton.setBounds(370, 505, 274, 73);
			layeredPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  String Nm =PrecioCompra.getText();      
					    String Nc = Cantidad.getText();     
					Double RTotal=(Double.parseDouble(Nc))*(Double.parseDouble(Nm));
					Total.setText(String.valueOf(RTotal));
					  String NS =StockA.getText();      
					int CTotal=(Integer.parseInt(Nc))+(Integer.parseInt(NS));
					NCantidad.setText(String.valueOf(CTotal));
					

				}
			});
			btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			btnNewButton_1.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/calculadora_m.png"));
			btnNewButton_1.setBounds(779, 436, 46, 44);
			layeredPane.add(btnNewButton_1);
			
			ID = new JTextField();
			ID.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			ID.setColumns(10);
			ID.setBounds(268, 105, 59, 41);
			layeredPane.add(ID);
			
			JLabel lblIdinsumo = new JLabel("ID del Insumo");
			lblIdinsumo.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblIdinsumo.setBounds(40, 103, 228, 41);
			layeredPane.add(lblIdinsumo);
			
			JLabel lblNombre_1_2_1_1_1 = new JLabel("Total");
			lblNombre_1_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNombre_1_2_1_1_1.setBounds(496, 439, 84, 41);
			layeredPane.add(lblNombre_1_2_1_1_1);
			
			Total = new JTextField();
			Total.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			Total.setColumns(10);
			Total.setBounds(608, 439, 165, 41);
			layeredPane.add(Total);
			
			IDG = new JTextField();
			IDG.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			IDG.setColumns(10);
			IDG.setBounds(879, 19, 84, 41);
			layeredPane.add(IDG);
			
			JLabel lblIdDelGasto = new JLabel("ID del Gasto");
			lblIdDelGasto.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblIdDelGasto.setBounds(690, 6, 193, 63);
			layeredPane.add(lblIdDelGasto);
			
			StockA = new JTextField();
			StockA.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			StockA.setColumns(10);
			StockA.setBounds(819, 105, 84, 41);
			layeredPane.add(StockA);
			
			JLabel lblStockActual = new JLabel("Nombre");
			lblStockActual.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblStockActual.setBounds(328, 103, 116, 41);
			layeredPane.add(lblStockActual);
			
			JButton btnNewButton_1_1 = new JButton("");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ConectarPosgres conn = new ConectarPosgres();
					
					


				    try {
				    	sentencia = conn.conexion.createStatement();
				    
				        String sql = "SELECT  \"Stock_Insumo\", \"Nombre_Insumo\"	FROM public.\"Insumo\" where \"ID_Insumo\"="+ID.getText()+";";
				        
				        
				        
				        resultado = sentencia.executeQuery(sql);
				      
				        
				        while (resultado.next()) {
				        	
				        	StockA.setText(resultado.getString("Stock_Insumo"));				           

				        	NombreIn.setText(resultado.getString("Nombre_Insumo"));				           
				        }
    
				       
     
				    } catch (Exception e1 ){
				        System.err.println("Error -> ");
				     
				    }
					
				}
			});
			btnNewButton_1_1.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1395456967_67.png"));
			btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			btnNewButton_1_1.setBounds(917, 105, 46, 44);
			layeredPane.add(btnNewButton_1_1);
			
			JLabel lblStockActual_1 = new JLabel("Stock Actual");
			lblStockActual_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblStockActual_1.setBounds(632, 103, 193, 41);
			layeredPane.add(lblStockActual_1);
			
			NombreIn = new JTextField();
			NombreIn.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			NombreIn.setColumns(10);
			NombreIn.setBounds(456, 105, 171, 41);
			layeredPane.add(NombreIn);
			
			NCantidad = new JTextField();
			NCantidad.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			NCantidad.setColumns(10);
			NCantidad.setBounds(297, 439, 166, 41);
			layeredPane.add(NCantidad);
			
			JLabel lblNuevaCantidad = new JLabel("Nueva Cantidad");
			lblNuevaCantidad.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNuevaCantidad.setBounds(38, 439, 247, 41);
			layeredPane.add(lblNuevaCantidad);
			
			JLabel lblIdUsuario = new JLabel("ID Usuario");
			lblIdUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblIdUsuario.setBounds(334, 6, 193, 63);
			layeredPane.add(lblIdUsuario);
			
			IDU = new JTextField();
			IDU.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			IDU.setColumns(10);
			IDU.setBounds(528, 19, 84, 41);
			layeredPane.add(IDU);
		


	}
}
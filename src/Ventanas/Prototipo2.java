package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Prototipo2 extends JFrame {

	public JPanel contentPane;
	public JTextField textU;
	public JTextField textC;
	public Statement sentencia;
	public ResultSet resultado;
	public String Con;
	public String Usu;
	public String Contraseña;
	public String Tipo;


	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prototipo2 frame = new Prototipo2();
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
	public Prototipo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(220, 60, 82, 25);
		layeredPane.add(lblNewLabel);
		
		textU = new JTextField();
		textU.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textU.setBounds(195, 97, 130, 26);
		layeredPane.add(textU);
		textU.setColumns(10);
		
		textC = new JTextField();
		textC.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textC.setBounds(195, 163, 130, 26);
		layeredPane.add(textC);
		textC.setColumns(10);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  Con=textC.getText();
		            Con = Con.replace(" ", ""); 
				  Usu=textU.getText();
		            Usu = Usu.replace(" ", ""); 

				
					ConectarPosgres conn = new ConectarPosgres();

				    try {
				    	sentencia = conn.conexion.createStatement();
				    
				        String sql = "SELECT \"Contraseña_Usuario\",\"Tipo_Usuario\" FROM public.\"Usuario\" where \"Nombre_Usuario\"='"+Usu+"';";
				        
				        
				        
				        resultado = sentencia.executeQuery(sql);
				      
				        
				        while (resultado.next()) {
				        	
				        	Contraseña=resultado.getString("Contraseña_Usuario");	
				            Contraseña = Contraseña.replace(" ", ""); 
				        	Tipo=resultado.getString("Tipo_Usuario");		
				            Tipo = Tipo.replace(" ", ""); 

				        }
				       
				        switch (Tipo) { 
			            case "Administrador":
					   		 if (Contraseña.equals(Con)) 
								{ 
									Pg1 objPg1 = new Pg1();
									objPg1.setVisible(true);
									dispose();}
			             break;
			            case "Auxiliar":
			            	if (Contraseña.equals(Con)) {
								PgAIngresarC objPgAIngresarC = new PgAIngresarC();
								objPgAIngresarC.setVisible(true);
								dispose();}
			             break;
			            default:	
			            	JFrame jFrame = new JFrame();
				        JOptionPane.showMessageDialog(jFrame, "La Contraseña y el Usuario esta equivocada");

			            	
						}

				    } catch (Exception e1 ){
				    	
				    	 JFrame jFrame = new JFrame();
					        JOptionPane.showMessageDialog(jFrame, "-La Contraseña y el Usuario esta equivocada-");
				     
				    
				    }
			}
		});
		btnNewButton.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/1384235266_gtk-leave-fullscreen.png"));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(138, 208, 117, 29);
		layeredPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(205, 135, 117, 16);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/GRANDE.png"));
		lblNewLabel_2.setBounds(23, 55, 130, 134);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/israeldaviddomingueztovar/eclipse-workspace/Proyecto ING/IMAGENES/ImgenFondo.jpg"));
		lblNewLabel_3.setBounds(6, 6, 438, 260);
		layeredPane.add(lblNewLabel_3);
		
	

			
		
	
	}
}


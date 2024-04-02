package Ventanas;

import java.sql.*;



	public  class ConectarPosgres {
	    
	    String cadenaConexion = "jdbc:postgresql://basededatospgt.postgres.database.azure.com:5432/SistemaSiap";
	    Connection conexion;
	    Statement sentencia;
	    ResultSet resultado;
	    
	    String usuario= "AdminT";
	    String contraseña= "David18230721";
	    private Connection conexion() {
	        try {
	            try {
	                Class.forName("org.postgresql.Driver");
	            } catch (ClassNotFoundException ex) {
	                javax.swing.JOptionPane.showMessageDialog(null, ex);
	            }
	            conexion = DriverManager.getConnection(cadenaConexion, usuario, contraseña);
	          
	            return conexion;            
	        } catch (java.sql.SQLException sqle) {
	        	
	            javax.swing.JOptionPane.showMessageDialog(null, ""+sqle);
	            return conexion;
	        }
	    }
	    
	    public 	 ConectarPosgres(){
	       
	         conexion();
	         
	    }
	    
	}

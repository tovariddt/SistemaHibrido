package Modelos;

public class GastosGeneral {
	String FechaGasto;
	public String getFecha_Gasto() {
		return FechaGasto;
	}
	public void setFecha_Gasto(String fechaGasto) {
		FechaGasto = fechaGasto;
	}
	public String getID_Gastos() {
		return ID_Gastos;
	}
	public void setID_Gastos(String iDGasto) {
		ID_Gastos= iDGasto;
	}
	public String getID_Insumo() {
		return ID_Insumo;
	}
	public void setID_Insumo(String iDInsumo) {
		ID_Insumo = iDInsumo;
	}
	public String getID_Usuario() {
		return ID_Usuario;
	}
	public void setID_Usuario(String iDUsuario) {
		ID_Usuario = iDUsuario;
	}
	public String getNombre_Gasto() {
		return Nombre_Gasto;
	}
	public void setNombre_Gasto(String nombreGasto) {
		Nombre_Gasto = nombreGasto;
	}
	public String getTipo_Gasto() {
		return Tipo_Gasto;
	}
	public void setTipo_Gasto(String tipoGasto) {
		Tipo_Gasto = tipoGasto;
	}
	public String getTotal_Gasto() {
		return Total_Gasto;
	}
	public void setTotal_Gasto(String totalGasto) {
		Total_Gasto = totalGasto;
	}
	String ID_Gastos;
	String ID_Insumo;
	String ID_Usuario;
	String Nombre_Gasto;
	String Tipo_Gasto;
	String Total_Gasto;
}

package Modelos;

public class Gastos_Pagos {
	public String getDescripción_Pagos() {
		return Descripción_Pagos;
	}
	public void setDescripción_Pagos(String descripción_Pagos) {
		Descripción_Pagos = descripción_Pagos;
	}
	public String getFecha_Pagos() {
		return Fecha_Pagos;
	}
	public void setFecha_Pagos(String fecha_Pagos) {
		Fecha_Pagos = fecha_Pagos;
	}
	public String getID_Gastos() {
		return ID_Gastos;
	}
	public void setID_Gastos(String iD_Gastos) {
		ID_Gastos = iD_Gastos;
	}
	public String getMonto_Pagos() {
		return Monto_Pagos;
	}
	public void setMonto_Pagos(String monto_Pagos) {
		Monto_Pagos = monto_Pagos;
	}
	public String getPersonal_Pagos() {
		return Personal_Pagos;
	}
	public void setPersonal_Pagos(String personal_Pagos) {
		Personal_Pagos = personal_Pagos;
	}
	public String getUnidad_Pagos() {
		return Unidad_Pagos;
	}
	public void setUnidad_Pagos(String unidad_Pagos) {
		Unidad_Pagos = unidad_Pagos;
	}
	String Descripción_Pagos;
	String Fecha_Pagos;
	String ID_Gastos;
	String Monto_Pagos;
	public String getTotal_Gasto() {
		return Total_Gasto;
	}
	public void setTotal_Gasto(String total_Gasto) {
		Total_Gasto = total_Gasto;
	}
	String Total_Gasto;
	String Personal_Pagos;
	String Unidad_Pagos;
    public String getCantidad_Pagos() {
		return Cantidad_Pagos;
	}
	public void setCantidad_Pagos(String cantidad_Pagos) {
		Cantidad_Pagos = cantidad_Pagos;
	}
	String Cantidad_Pagos;
}

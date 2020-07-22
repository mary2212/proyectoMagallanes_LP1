package entidad;

import java.sql.Date;

public class Pedido 
{
	private int idpedido;
	private Date fecharegistro;
	private Date fechaentrega;
	private String lugarentrega;
	private String estado;
	private Cliente cliente;
	private Ubigeo ubigeo;
	private Usuario usuario;
	
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public Date getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public Date getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
	public String getLugarentrega() {
		return lugarentrega;
	}
	public void setLugarentrega(String lugarentrega) {
		this.lugarentrega = lugarentrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Ubigeo getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

package com.eddie.ecommerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido implements ValueObject{

	private Integer idPedido=null;
	private String email=null;
	private Double total=null;
	private Date fecha_pedido=null;
	private List<LineaPedido>lineaspedido=null;
	
	private static final Double IVA=0.0d;
	
	public Pedido() {
		lineaspedido=new ArrayList<LineaPedido>();
	}

	public Integer getNumeroPedido() {
		return idPedido;
	}
	public void setNumeroPedido(Integer numeroPedido) {
		this.idPedido = numeroPedido;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public static Double getIva() {
		return IVA;
	}

	public List<LineaPedido> getLineaspedido() {
		return lineaspedido;
	}

	public void setLineaspedido(List<LineaPedido> lineaspedido) {
		this.lineaspedido = lineaspedido;
	}
	
	
}
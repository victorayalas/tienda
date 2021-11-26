/**
 * Clase TiendaProducto.java 24 de nov. de 2021
 * Copyright 2021
 * Todos los derechos reservados.
 */
package com.pichincha.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Mapeo de la entidad de TiendaProducto
 * 
 * @author Victor Ayala
 *
 */
@Entity
@Table(name = "apti_tiendas_productos", schema = "app_tienda")
public class TiendaProducto implements Serializable {

	private static final long serialVersionUID = -8578184352891194287L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tienda_producto")
	private Long idTiendaProducto;

	@ManyToOne
	@JoinColumn(name = "id_tienda", nullable = false)
	private Tienda tienda;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;

	@Column(name = "cantidad", nullable = false)
	private Long cantidad;

	/**
	 * Constructor
	 */
	public TiendaProducto() {
	}

	public Long getIdTiendaProducto() {
		return idTiendaProducto;
	}

	public void setIdTiendaProducto(Long idTiendaProducto) {
		this.idTiendaProducto = idTiendaProducto;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

}

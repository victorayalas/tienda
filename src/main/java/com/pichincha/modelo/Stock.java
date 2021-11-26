/**
 * Clase Stok.java 24 de nov. de 2021
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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Mapeo de la entidad de Stok
 * 
 * @author Victor Ayala
 *
 */
@Entity
@Table(name = "apti_stock", schema = "app_tienda")
public class Stock implements Serializable {

	private static final long serialVersionUID = -8578184352891194287L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_stock")
	private Long idStock;

	@ManyToOne
	@JoinColumn(name = "id_tienda", nullable = false)
	private Tienda tienda;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;

	@Column(name = "estado", nullable = false)
	private Boolean estado;

	/**
	 * Constructor
	 */
	public Stock() {
	}

	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}

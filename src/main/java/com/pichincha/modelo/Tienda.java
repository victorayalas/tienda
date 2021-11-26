/**
 * Clase Tiendas.java 24 de nov. de 2021
 * Copyright 2021
 * Todos los derechos reservados.
 */
package com.pichincha.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Mapeo de la entidad de Tiendas
 * 
 * @author Victor Ayala
 *
 */
@Entity
@Table(name = "apti_tiendas", schema = "app_tienda")
public class Tienda implements Serializable {

	private static final long serialVersionUID = 7023627153916883117L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tienda")
	private Long idTienda;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;

//	@OneToMany(mappedBy = "tienda", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
//			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
//	private List<TiendaProducto> tiendaProducto;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "apti_tiendas_productos", schema = "app_tienda", 
	joinColumns = @JoinColumn(name = "id_tienda", updatable = false, nullable = false), 
	inverseJoinColumns = @JoinColumn(name = "id_producto", updatable = false, nullable = false))
	private List<Producto> listaProducto;
	
	/**
	 * Constructor
	 */
	public Tienda() {
	}

	public Long getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

}

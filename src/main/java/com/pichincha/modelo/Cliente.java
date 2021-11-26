/**
 * Clase Clientes.java 24 de nov. de 2021
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
import javax.persistence.Table;

/**
 * Mapeo de la entidad de Clientes
 * 
 * @author Victor Ayala
 *
 */
@Entity
@Table(name = "apti_clientes", schema = "app_tienda")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -4953048558055407112L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "documento_identidad", nullable = false, length = 13)
	private String documentoIdentidad;

	/**
	 * Constructor
	 */
	public Cliente() {
	}

	public Cliente(Long idCliente, String nombre, String documentoIdentidad) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.documentoIdentidad = documentoIdentidad;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}
	
}

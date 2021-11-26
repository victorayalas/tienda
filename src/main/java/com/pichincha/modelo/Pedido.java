/**
 * Clase Pedidos.java 24 de nov. de 2021
 * Copyright 2021
 * Todos los derechos reservados.
 */
package com.pichincha.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * Mapeo de la entidad de Pedidos
 * 
 * @author Victor Ayala
 *
 */
@Entity
@Table(name = "apti_pedidos", schema = "app_tienda")
public class Pedido implements Serializable {

	private static final long serialVersionUID = -2014643050979512859L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@JsonSerialize(using = ToStringSerializer.class)
	@JoinColumn(name = "fecha", nullable = false)
	private LocalDateTime fecha;

	@OneToMany(mappedBy = "pedido", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetallePedido> detallePedido;

	/**
	 * Constructor
	 */
	public Pedido() {
	}
	
	

	public Pedido(Long idPedido, Cliente cliente, LocalDateTime fecha, List<DetallePedido> detallePedido) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.fecha = fecha;
		this.detallePedido = detallePedido;
	}



	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}



	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

}

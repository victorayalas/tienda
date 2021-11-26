package com.pichincha.servicio;

import java.util.List;

import com.pichincha.modelo.Pedido;

public interface IPedidoServicio {

	List<Pedido> recuperarPedidoxCliente(Long idCliente);

	Pedido registrar(Pedido pedido);

	void eliminar(Long idPedido);

	Pedido listarId(Long idPedido);
}

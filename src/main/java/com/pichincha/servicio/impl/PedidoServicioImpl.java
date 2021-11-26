package com.pichincha.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.dao.IPedidoDAO;
import com.pichincha.modelo.Pedido;
import com.pichincha.servicio.IPedidoServicio;

@Service
public class PedidoServicioImpl implements IPedidoServicio {

	@Autowired
	private IPedidoDAO dao;

	@Override
	public List<Pedido> recuperarPedidoxCliente(Long idCliente) {
		return dao.recuperarPedidoxCliente(idCliente);
	}

	@Override
	public Pedido registrar(Pedido pedido) {
		pedido.getDetallePedido().forEach(x -> x.setPedido(pedido));
		return dao.save(pedido);
	}

	@Override
	public void eliminar(Long idPedido) {
		dao.deleteById(idPedido);
	}

	@Override
	public Pedido listarId(Long idPedido) {
		Optional<Pedido> opt = dao.findById(idPedido);
		return opt.isPresent() ? opt.get() : new Pedido();
	}

}

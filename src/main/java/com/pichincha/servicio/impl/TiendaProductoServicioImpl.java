package com.pichincha.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.dao.ITiendaProductoDAO;
import com.pichincha.modelo.TiendaProducto;
import com.pichincha.servicio.ITiendaProductoServicio;

@Service
public class TiendaProductoServicioImpl implements ITiendaProductoServicio {

	@Autowired
	private ITiendaProductoDAO dao;

	@Override
	public TiendaProducto registrar(TiendaProducto tiendaProducto) {
		return dao.save(tiendaProducto);
	}

	@Override
	public List<TiendaProducto> listar() {
		return dao.findAll();
	}

}

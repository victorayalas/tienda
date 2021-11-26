package com.pichincha.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.dao.IProductoDAO;
import com.pichincha.modelo.Producto;
import com.pichincha.servicio.IProductoServicio;

@Service
public class ProductoServicioImpl implements IProductoServicio {

	@Autowired
	private IProductoDAO dao;

	@Override
	public Producto registrar(Producto producto) {
		return dao.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		return dao.save(producto);
	}

}

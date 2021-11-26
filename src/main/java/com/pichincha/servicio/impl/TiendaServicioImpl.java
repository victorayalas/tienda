package com.pichincha.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.dao.ITiendaDAO;
import com.pichincha.modelo.Tienda;
import com.pichincha.servicio.ITiendaServicio;

@Service
public class TiendaServicioImpl implements ITiendaServicio {

	@Autowired
	private ITiendaDAO dao;

	@Override
	public void registrar(Tienda tienda) {
		dao.save(tienda);
	}

	@Override
	public void modificar(Tienda tienda) {
		dao.save(tienda);
	}

	@Override
	public List<Tienda> buscarTiendaListaProducto() {
		return dao.buscarTiendaListaProducto();
	}

}

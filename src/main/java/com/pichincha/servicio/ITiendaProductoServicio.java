package com.pichincha.servicio;

import java.util.List;

import com.pichincha.modelo.TiendaProducto;

public interface ITiendaProductoServicio {

	TiendaProducto registrar(TiendaProducto tiendaProducto);

	List<TiendaProducto> listar();

}

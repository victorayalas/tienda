package com.pichincha.servicio;

import java.util.List;

import com.pichincha.modelo.Tienda;

public interface ITiendaServicio {

	void registrar(Tienda tienda);

	void modificar(Tienda tienda);

	List<Tienda> buscarTiendaListaProducto();


}

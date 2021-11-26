package com.pichincha.dto;

import java.util.List;

import com.pichincha.modelo.Producto;
import com.pichincha.modelo.Tienda;

public class TiendaListaProductoDTO {

	private Tienda tienda;

	private List<Producto> listaProducto;

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProductos(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
}

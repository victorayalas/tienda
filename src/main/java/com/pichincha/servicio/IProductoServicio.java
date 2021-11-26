package com.pichincha.servicio;

import com.pichincha.modelo.Producto;

public interface IProductoServicio {

	Producto registrar(Producto producto);

	Producto modificar(Producto producto);

}

package com.pichincha.servicio.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.dao.IProductoDAO;
import com.pichincha.modelo.Producto;

@SpringBootTest
public class ProductoServicioImplTest {
	@Autowired
	private IProductoDAO productoDAO;

	@Test
	public void registar() {

		Producto producto = new Producto();
		producto.setIdProducto(1L);
		producto.setNombre("Televicor Sony 70  Pulgadas");
		producto.setPrecio(1900f);
		productoDAO.save(producto);
		assertNotNull(productoDAO.findById(1L).get());
	}

}

package com.pichincha.servicio.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.dao.ITiendaDAO;
import com.pichincha.modelo.Producto;
import com.pichincha.modelo.Tienda;

@SpringBootTest
class TiendaServicioImplTest {

	@Autowired
	private ITiendaDAO tiendaDAO;

	@Test
	void registrar() {
		Tienda tienda = new Tienda();
		tienda.setDireccion("ALNORADA");
		tienda.setIdTienda(1L);
		tienda.setListaProducto(new ArrayList<Producto>());
		tienda.setNombre("ALBORADA");
		tiendaDAO.save(tienda);
		assertNotNull(tiendaDAO.findById(1L).get());
	}

}

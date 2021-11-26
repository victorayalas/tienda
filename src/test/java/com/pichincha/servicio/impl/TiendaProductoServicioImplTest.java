package com.pichincha.servicio.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.dao.ITiendaProductoDAO;
import com.pichincha.modelo.Producto;
import com.pichincha.modelo.Tienda;
import com.pichincha.modelo.TiendaProducto;

@SpringBootTest
class TiendaProductoServicioImplTest {

	@Mock
	private ITiendaProductoDAO tiendaProductoDAO;

	@InjectMocks
	private TiendaProductoServicioImpl tiendaProductoServicio;

	private TiendaProducto tiendaProducto;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		tiendaProducto = new TiendaProducto();
		tiendaProducto.setIdTiendaProducto((long) 1);
		tiendaProducto.setCantidad((long) 300);
		tiendaProducto.setProducto(new Producto());
		tiendaProducto.setTienda(new Tienda());

	}

	@Test
	void finAll() {
		when(tiendaProductoDAO.findAll()).thenReturn(Arrays.asList(tiendaProducto));
		assertNotNull(tiendaProductoServicio.listar());
	}

}

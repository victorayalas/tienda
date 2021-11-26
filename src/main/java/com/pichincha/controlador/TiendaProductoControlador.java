package com.pichincha.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.modelo.TiendaProducto;
import com.pichincha.servicio.ITiendaProductoServicio;

@RestController
@RequestMapping("/tienda_producto")
public class TiendaProductoControlador {

	@Autowired
	private ITiendaProductoServicio servicio;

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TiendaProducto> registrar(@RequestBody TiendaProducto tiendaProducto) {
		TiendaProducto tiePro = new TiendaProducto();
		try {
			tiePro = servicio.registrar(tiendaProducto);

		} catch (Exception e) {
			return new ResponseEntity<TiendaProducto>(tiePro, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<TiendaProducto>(tiePro, HttpStatus.OK);
	}

	@GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<TiendaProducto>> listar() {
		List<TiendaProducto> lista = new ArrayList<>();
		try {
			lista = servicio.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<TiendaProducto>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<TiendaProducto>>(lista, HttpStatus.OK);
	}
}

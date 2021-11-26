package com.pichincha.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.modelo.Producto;
import com.pichincha.servicio.IProductoServicio;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {

	@Autowired
	private IProductoServicio servicio;

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
		Producto pro = new Producto();
		try {
			pro = servicio.registrar(producto);

		} catch (Exception e) {
			return new ResponseEntity<Producto>(pro, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Producto>(pro, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> modificar(@RequestBody Producto producto) {
		Producto pro = new Producto();
		try {
			pro = servicio.modificar(producto);

		} catch (Exception e) {
			return new ResponseEntity<Producto>(pro, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Producto>(pro, HttpStatus.OK);
	}

}

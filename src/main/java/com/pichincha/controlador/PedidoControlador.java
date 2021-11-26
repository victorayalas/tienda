package com.pichincha.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.excepcion.ModeloNotFoundException;
import com.pichincha.modelo.Pedido;
import com.pichincha.servicio.IPedidoServicio;

@RestController
@RequestMapping("/pedidos")
public class PedidoControlador {

	@Autowired
	private IPedidoServicio servicio;

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido) {
		Pedido c = new Pedido();
		try {
			c = servicio.registrar(pedido);
		} catch (Exception e) {
			return new ResponseEntity<Pedido>(c, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Pedido>(c, HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable("id") Long id) {
		Pedido pedido = servicio.listarId(id);
		if (pedido == null) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			servicio.eliminar(id);
		}
	}

}

package com.pichincha.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.modelo.Tienda;
import com.pichincha.servicio.ITiendaServicio;

@RestController
@RequestMapping("/tienda")
public class TiendaControlador {

	@Autowired
	private ITiendaServicio servicio;

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Tienda tienda) {
		int resultado = 0;
		try {
			servicio.registrar(tienda);
			resultado = 1;
		} catch (Exception e) {
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Tienda tienda) {
		int resultado = 0;
		try {
			servicio.modificar(tienda);
			resultado = 1;
		} catch (Exception e) {
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<Tienda>> listar() {
		List<Tienda> lista = new ArrayList<>();
		try {
			lista = servicio.buscarTiendaListaProducto();
		} catch (Exception e) {
			return new ResponseEntity<List<Tienda>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Tienda>>(lista, HttpStatus.OK);
	}
}

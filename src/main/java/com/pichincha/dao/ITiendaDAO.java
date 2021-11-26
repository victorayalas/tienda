package com.pichincha.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pichincha.modelo.Tienda;

@Repository
public interface ITiendaDAO extends JpaRepository<Tienda, Long> {

	@Query("Select t from Tienda t group by t ")
	List<Tienda> buscarTiendaListaProducto();

}

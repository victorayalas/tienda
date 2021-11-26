package com.pichincha.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pichincha.modelo.Pedido;

@Repository
public interface IPedidoDAO extends JpaRepository<Pedido, Long> {

	@Query("from Pedido p where p.cliente.idCliente =:idCliente ")
	List<Pedido> recuperarPedidoxCliente(@Param("idCliente") Long idCliente);

}

package com.pichincha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.modelo.DetallePedido;

@Repository
public interface IDetallePedidoDAO extends JpaRepository<DetallePedido, Integer> {

}

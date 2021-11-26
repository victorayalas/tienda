package com.pichincha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.modelo.Producto;

@Repository
public interface IProductoDAO extends JpaRepository<Producto, Long> {

}

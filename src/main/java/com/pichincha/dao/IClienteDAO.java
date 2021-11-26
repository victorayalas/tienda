package com.pichincha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.modelo.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Integer> {

}

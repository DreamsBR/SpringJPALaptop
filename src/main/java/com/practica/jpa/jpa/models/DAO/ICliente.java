package com.practica.jpa.jpa.models.DAO;

import com.practica.jpa.jpa.models.entity.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ICliente extends CrudRepository<Cliente, Long>{
    
    
}

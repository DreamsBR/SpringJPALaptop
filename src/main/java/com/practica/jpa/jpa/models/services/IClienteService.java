package com.practica.jpa.jpa.models.services;

import java.util.List;

import com.practica.jpa.jpa.models.entity.Cliente;

public interface IClienteService {

    public List<Cliente> findAll();

    public void save(Cliente Cliente);

    public Cliente findById(Long id);

    public void delteById(Long id);
}

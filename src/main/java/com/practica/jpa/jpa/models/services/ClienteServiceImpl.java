package com.practica.jpa.jpa.models.services;

import java.util.List;

import com.practica.jpa.jpa.models.DAO.ICliente;
import com.practica.jpa.jpa.models.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired 
    private ICliente clientedao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clientedao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente Cliente) {
        clientedao.save(Cliente);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clientedao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delteById(Long id) {
        clientedao.deleteById(id);
        
    }
    
}

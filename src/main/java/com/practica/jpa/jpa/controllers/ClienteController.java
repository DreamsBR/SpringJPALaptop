package com.practica.jpa.jpa.controllers;

import java.util.Map;

import javax.validation.Valid;

// import com.practica.jpa.jpa.models.DAO.ICliente;
import com.practica.jpa.jpa.models.entity.Cliente;
import com.practica.jpa.jpa.models.services.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@Controller
// @SessionAttributes("cliente")
public class ClienteController {
    
    @Autowired
    @Qualifier("clienteServiceImpl")
    private IClienteService clienteService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String nuevo(Map<String, Object> model){
        Cliente clie = new Cliente();
        model.put("cliente", clie);
        model.put("titulo", "Formulario de cliente");
        return "form";
    }

    @Validated
    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String guardar(@Valid  Cliente cli, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario de Cliente");
            return "form";
        }
        clienteService.save(cli);
        // status.setComplete();
        return "redirect:listar";
    }
    
    @RequestMapping(value="/form/{id}")
    public String update(@PathVariable(value = "id") Long id, Map<String ,Object> model ) {
        Cliente cliente = null;
        if(id>0){
            cliente = clienteService.findById(id);
        }else{
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Editar Cliente");
        return "form" ;
    }
    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id")Long id){
        if(id>0){
            clienteService.delteById(id);
        }
        return "redirect:/listar";
    }
    
}

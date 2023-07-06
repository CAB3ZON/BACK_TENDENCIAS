/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavanderia.Lavanderia.controller;

import com.lavanderia.Lavanderia.model.Orden;
import com.lavanderia.Lavanderia.service.OrdenServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS ROG
 */
@RestController
@RequestMapping("/orden")
public class OrdenController {
     @Autowired
    OrdenServiceImpl ordenServiceImpl;

    @Operation(summary = "Se obtiene la lista de orden")
    @GetMapping("/listar")
    public ResponseEntity<List<Orden>> listaOrden() {
        return new ResponseEntity<>(ordenServiceImpl.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Orden")
    @PostMapping("/crear")
    public ResponseEntity<Orden> crearPersona(@RequestBody Orden u) {
        return new ResponseEntity<>(ordenServiceImpl.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Orden> actualizarPersona(@PathVariable Integer id, @RequestBody Orden u) {
        Orden orden = ordenServiceImpl.findById(id);
        if (orden != null) {
            try {
                orden.setEstado(u.getEstado());
                orden.setVenta(u.getVenta());
                orden.setTotalOrden(u.getTotalOrden());
                orden.setPersonaO(u.getPersonaO());
               
               
                
                return new ResponseEntity<>(ordenServiceImpl.save(orden), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Orden> eliminarOrden(@PathVariable Integer id) {
        ordenServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


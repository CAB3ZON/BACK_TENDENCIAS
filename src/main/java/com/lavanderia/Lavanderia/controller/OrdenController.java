/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavanderia.Lavanderia.controller;

import com.lavanderia.Lavanderia.model.Config_Empresa;
import com.lavanderia.Lavanderia.model.Orden;
import com.lavanderia.Lavanderia.model.Persona;
import com.lavanderia.Lavanderia.repository.OrdenRepository;
import com.lavanderia.Lavanderia.service.OrdenServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ASUS ROG
 */
@RestController
@RequestMapping("/orden")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdenController {
    @Autowired
    OrdenServiceImpl ordenServiceImpl;

    @Autowired
    OrdenRepository ordenRepository;

    @GetMapping("/listarnonull")
    public ResponseEntity<List<Orden>> listaOrdenNotNUll() {
        List<Orden> ordeneslistas = ordenRepository.listarOrdenNoNull();
        if (ordeneslistas != null) {
            return ResponseEntity.ok(ordeneslistas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/listarnull")
    public ResponseEntity<List<Orden>> listaOrdenNull() {
        List<Orden> ordeneslistas = ordenRepository.listarOrden();
        if (ordeneslistas != null) {
            return ResponseEntity.ok(ordeneslistas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/{cedula}")
    public ResponseEntity<List<Orden>> buscarPorCedula(@PathVariable String cedula) {
        List<Orden> ordenes = ordenRepository.buscarOrden(cedula);

        if (ordenes != null) {
            return ResponseEntity.ok(ordenes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/porid/{id}")
    public ResponseEntity<Orden> listaPersonaporID(@PathVariable Integer id) {
        Orden orden = ordenServiceImpl.findById(id);
        if (orden != null) {
            return ResponseEntity.ok(orden);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "Debe enviar los campos del Orden")
    @PostMapping("/crearyobtenerid")
    public ResponseEntity<Integer> crearOrden(@RequestBody Orden u) {
        Orden ordenCreada = ordenServiceImpl.save(u); // Guarda la Orden y obtiene la Orden creada con su ID generado
        int idOrden = ordenCreada.getIdOrden(); // Obtiene el ID de la Orden creada

        return new ResponseEntity<>(idOrden, HttpStatus.CREATED);
    }


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


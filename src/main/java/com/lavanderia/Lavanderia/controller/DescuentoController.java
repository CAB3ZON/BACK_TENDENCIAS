/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.controller;


import com.lavanderia.Lavanderia.model.Descuento;
import com.lavanderia.Lavanderia.service.DescuentoServicelmpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author USUARIO
 */
@RestController
@RequestMapping("/descuento")
public class DescuentoController {
    @Autowired
    DescuentoServicelmpl descuentoService;
    
    @Operation(summary = "Se obtiene la lista de los roles")
    @GetMapping("/listar")
    public ResponseEntity<List<Descuento>> listaRoles() {
        return new ResponseEntity<>(descuentoService.findByAll(), HttpStatus.OK);
    }
    
    @Operation(summary = "Debe enviar los campos del rol")
    @PostMapping("/crear")
    public ResponseEntity<Descuento> crearRol(@RequestBody Descuento r) {
        return new ResponseEntity<>(descuentoService.save(r), HttpStatus.CREATED);
    }
 
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Descuento> actualizarRol(@PathVariable Integer id, @RequestBody Descuento r) {
        Descuento new_rol = descuentoService.findById(id);
        if (new_rol != null) {
            try {
                new_rol.setNombre(r.getNombre());
                new_rol.setDescuento(r.getDescuento());
                
               
                return new ResponseEntity<>(descuentoService.save(new_rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Descuento> eliminarRol(@PathVariable Integer id) {
        descuentoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

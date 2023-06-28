/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.controller;

import com.lavanderia.Lavanderia.model.Servicio;
import com.lavanderia.Lavanderia.service.ServicioServicelmpl;
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
@RequestMapping("/servicio")
public class ServicioController {
    @Autowired
    ServicioServicelmpl servicioService;
    
     @Operation(summary = "Se obtiene la lista de los roles")
    @GetMapping("/listar")
    public ResponseEntity<List<Servicio>> listaRoles() {
        return new ResponseEntity<>(servicioService.findByAll(), HttpStatus.OK);
    }
    
    @Operation(summary = "Debe enviar los campos del rol")
    @PostMapping("/crear")
    public ResponseEntity<Servicio> crearRol(@RequestBody Servicio r) {
        return new ResponseEntity<>(servicioService.save(r), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Servicio> actualizarRol(@PathVariable Integer id, @RequestBody Servicio r) {
        Servicio new_rol = servicioService.findById(id);
        if (new_rol != null) {
            try {
                new_rol.setNombre(r.getNombre());
                new_rol.setDescripcion(r.getDescripcion());
                new_rol.setPrecio(r.getPrecio());
               
                return new ResponseEntity<>(servicioService.save(new_rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Servicio> eliminarRol(@PathVariable Integer id) {
        servicioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

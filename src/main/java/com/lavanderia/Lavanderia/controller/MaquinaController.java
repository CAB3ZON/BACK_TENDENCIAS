/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.controller;

import com.lavanderia.Lavanderia.model.Maquina;
import com.lavanderia.Lavanderia.service.MaquinaServicelmpl;
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
 * @author USUARIO
 */
@RestController
@RequestMapping("/maquina")
public class MaquinaController {
    @Autowired
    MaquinaServicelmpl maquinaService;


    @Operation(summary = "Se obtiene la lista de Personas")
    @GetMapping("/porid/{id}")
    public ResponseEntity<Maquina> listaPersonaporID(@PathVariable Integer id) {
        Maquina maquina = maquinaService.findById(id);
        if (maquina != null) {
            return ResponseEntity.ok(maquina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "Se obtiene la lista de Personas")
    @GetMapping("/listar")
    public ResponseEntity<List<Maquina>> listaPersona() {
        return new ResponseEntity<>(maquinaService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del persona")
    @PostMapping("/crear")
    public ResponseEntity<Maquina> crearPersona(@RequestBody Maquina u) {
        return new ResponseEntity<>(maquinaService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Maquina> actualizarPersona(@PathVariable Integer id, @RequestBody Maquina u) {
        Maquina new_maquina = maquinaService.findById(id);
        if (new_maquina != null) {
            try {
                new_maquina.setPrecio(u.getPrecio());
                new_maquina.setTamano(u.getTamano());
                   

                return new ResponseEntity<>(maquinaService.save(new_maquina), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Maquina> eliminarPersona(@PathVariable Integer id) {
        maquinaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.controller;

import com.lavanderia.Lavanderia.model.Item;
import com.lavanderia.Lavanderia.service.ItemServicelmpl;
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
@RequestMapping("/item")
public class ItemController {
     @Autowired
     ItemServicelmpl itemMaquinaService;
     
     @Operation(summary = "Se obtiene la lista de items")
    @GetMapping("/listar")
    public ResponseEntity<List<Item>> listaPersona() {
        return new ResponseEntity<>(itemMaquinaService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del item_maquina")
    @PostMapping("/crear")
    public ResponseEntity<Item> crearPersona(@RequestBody Item u) {
        return new ResponseEntity<>(itemMaquinaService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Item> actualizarPersona(@PathVariable Integer id, @RequestBody Item u) {
        Item new_maquina = itemMaquinaService.findById(id);
        if (new_maquina != null) {
            try {
                new_maquina.setCantidad(u.getCantidad());
                new_maquina.setMaquina(u.getMaquina());
                new_maquina.setPrecio_total(u.getPrecio_total());
             
                return new ResponseEntity<>(itemMaquinaService.save(new_maquina), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Item> eliminarPersona(@PathVariable Integer id) {
        itemMaquinaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
     
     
}

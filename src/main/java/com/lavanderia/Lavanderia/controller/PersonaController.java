/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.controller;


import com.lavanderia.Lavanderia.model.Persona;
import com.lavanderia.Lavanderia.model.Servicio;
import com.lavanderia.Lavanderia.repository.PersonaRepository;
import com.lavanderia.Lavanderia.service.PersonaServicelmpl;
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
@RequestMapping("/persona")
public class PersonaController {
     @Autowired
    PersonaServicelmpl personaService;
     
     @Autowired
     PersonaRepository personaRepository;
     
     
     @GetMapping("/personas/{cedula}")
    public ResponseEntity<Persona> buscarPorCedula(@PathVariable String cedula) {
        Persona persona = personaRepository.buscarPorCedula(cedula);
        
        if (persona != null) {
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
     
     
     
    @Operation(summary = "Se obtiene los servicios por ID")
    @GetMapping("/porid/{id}")
    public ResponseEntity<Persona> listaPersonaporID(@PathVariable Integer id) {
        Persona maquina = personaService.findById(id);
        if (maquina != null) {
            return ResponseEntity.ok(maquina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
     

    @Operation(summary = "Se obtiene la lista de Personas")
    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listaPersona() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del persona")
    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona u) {
        return new ResponseEntity<>(personaService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona u) {
        Persona persona = personaService.findById(id);
        if (persona != null) {
            try {
                persona.setNombrePer(u.getNombrePer());
                persona.setCorreo(u.getCorreo());
                persona.setIdentificacion(u.getIdentificacion());
                persona.setDireccion(u.getDireccion());
                persona.setTelefono(u.getTelefono());
                
                return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Integer id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

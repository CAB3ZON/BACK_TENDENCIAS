/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.controller;

import com.lavanderia.Lavanderia.model.Config_Empresa;
import com.lavanderia.Lavanderia.model.Maquina;
import com.lavanderia.Lavanderia.service.Config_EmpresaServicelmpl;
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
@RequestMapping("/configEmpresa")
public class Config_EmpresaController {
     @Autowired
     Config_EmpresaServicelmpl config_EmpresaService;

    @GetMapping("/porid/{id}")
    public ResponseEntity<Config_Empresa> listaPersonaporID(@PathVariable Integer id) {
        Config_Empresa empresa = config_EmpresaService.findById(id);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
     
     @Operation(summary = "Se obtiene la lista de Personas")
    @GetMapping("/listar")
    public ResponseEntity<List<Config_Empresa>> listaPersona() {
        return new ResponseEntity<>(config_EmpresaService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del persona")
    @PostMapping("/crear")
    public ResponseEntity<Config_Empresa> crearPersona(@RequestBody Config_Empresa u) {
        return new ResponseEntity<>(config_EmpresaService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Config_Empresa> actualizarPersona(@PathVariable Integer id, @RequestBody Config_Empresa u) {
        Config_Empresa persona = config_EmpresaService.findById(id);
        if (persona != null) {
            try {
                persona.setNombreEmpresa(u.getNombreEmpresa());
                persona.setRuc(u.getRuc());
                persona.setTelefono(u.getTelefono());
                persona.setUbicacion(u.getUbicacion());
                persona.setIva(u.getIva());
                return new ResponseEntity<>(config_EmpresaService.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Config_Empresa> eliminarPersona(@PathVariable Integer id) {
        config_EmpresaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
     
     
     
}

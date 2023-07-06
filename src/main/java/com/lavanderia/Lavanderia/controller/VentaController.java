/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavanderia.Lavanderia.controller;

import com.lavanderia.Lavanderia.model.Venta;
import com.lavanderia.Lavanderia.service.VentaServicelmpl;
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
 * @author ASUS ROG
 */
@RestController
@RequestMapping("/venta")
public class VentaController {
  @Autowired
    VentaServicelmpl ventaServicelmpl;

    @Operation(summary = "Se obtiene la lista de venta")
    @GetMapping("/listar")
    public ResponseEntity<List<Venta>> listaOrden() {
        return new ResponseEntity<>(ventaServicelmpl.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del venta")
    @PostMapping("/crear")
    public ResponseEntity<Venta> crearPersona(@RequestBody Venta u) {
        return new ResponseEntity<>(ventaServicelmpl.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Venta> actualizarPersona(@PathVariable Integer id, @RequestBody Venta u) {
        Venta venta = ventaServicelmpl.findById(id);
        if (venta != null) {
            try {
                venta.setFecha(u.getFecha());
                venta.setTipoPago(u.getTipoPago());
                venta.setSubtotal(u.getSubtotal());
                venta.setDescuento(u.getDescuento());
                venta.setIva(u.getIva());
                venta.setTotal(u.getTotal());
                venta.setPersonaf(u.getPersonaf());
                venta.setConfigEmpresa(u.getConfigEmpresa());
               
               
                
                return new ResponseEntity<>(ventaServicelmpl.save(venta), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Venta> eliminarOrden(@PathVariable Integer id) {
        ventaServicelmpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



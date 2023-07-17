/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.service;

import com.lavanderia.Lavanderia.model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.lavanderia.Lavanderia.repository.VentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
@Service
    public class VentaServicelmpl extends GenericServiceImpl<Venta, Integer> implements GenericService<Venta, Integer> {
@Autowired
VentaRepository facturaRepository;
    @Override
    public CrudRepository<Venta, Integer> getDao() {
    return facturaRepository;
            }

 
//    public List<Venta> buscarVentaPorFecha(LocalDate fechaBusqueda, List<Venta> listaVentas) {
//        List<Venta> ventasEncontradas = new ArrayList<>();
//
//    for (Venta ventas : listaVentas) {
//        if (ventas.getFecha().equals(fechaBusqueda)) {
//            ventasEncontradas.add(ventas);
//        }
//    }
//
//    return ventasEncontradas;
//  
//}
}
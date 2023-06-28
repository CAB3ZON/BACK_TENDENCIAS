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
    
}

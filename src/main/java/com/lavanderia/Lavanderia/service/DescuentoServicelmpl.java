/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.service;

import com.lavanderia.Lavanderia.model.Descuento;
import com.lavanderia.Lavanderia.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class DescuentoServicelmpl extends GenericServiceImpl<Descuento,Integer> implements GenericService<Descuento,Integer> {
@Autowired
DescuentoRepository descuentoRepository;
    @Override
    public CrudRepository<Descuento, Integer> getDao() {
return descuentoRepository;
        }
    
}

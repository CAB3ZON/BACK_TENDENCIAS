/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.service;

import com.lavanderia.Lavanderia.model.Servicio;
import com.lavanderia.Lavanderia.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServicioServicelmpl extends GenericServiceImpl<Servicio, Integer> implements GenericService<Servicio, Integer> {
@Autowired
ServicioRepository servicioRepository;
    @Override
    public CrudRepository<Servicio, Integer> getDao() {
return servicioRepository;
    }
    
}

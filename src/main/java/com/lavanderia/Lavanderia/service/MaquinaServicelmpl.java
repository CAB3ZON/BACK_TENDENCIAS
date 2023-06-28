/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.service;

import com.lavanderia.Lavanderia.model.Maquina;
import com.lavanderia.Lavanderia.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class MaquinaServicelmpl extends GenericServiceImpl<Maquina,Integer> implements GenericService<Maquina,Integer> {
@Autowired
MaquinaRepository maquinaRepository;
    @Override
    public CrudRepository<Maquina, Integer> getDao() {
return maquinaRepository;
    }
    
}

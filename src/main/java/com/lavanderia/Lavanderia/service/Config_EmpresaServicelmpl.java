/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.service;

import com.lavanderia.Lavanderia.model.Config_Empresa;
import com.lavanderia.Lavanderia.repository.Config_EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;



/**
 *
 * @author USUARIO
 */
@Service
public class Config_EmpresaServicelmpl extends GenericServiceImpl<Config_Empresa,Integer> implements GenericService<Config_Empresa,Integer> {
@Autowired
Config_EmpresaRepository config_EmpresaRepository;
    @Override
    public CrudRepository<Config_Empresa, Integer> getDao() {
        return config_EmpresaRepository;
    }


    
}

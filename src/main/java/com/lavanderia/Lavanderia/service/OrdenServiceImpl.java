package com.lavanderia.Lavanderia.service;


import com.lavanderia.Lavanderia.model.Orden;
import com.lavanderia.Lavanderia.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS ROG
 */
public class OrdenServiceImpl extends GenericServiceImpl<Orden,Integer> implements GenericService<Orden,Integer>{
@Autowired
OrdenRepository ordenRepository;

    @Override
    public OrdenRepository getDao() {
        return ordenRepository; 
   

    }
    

    }

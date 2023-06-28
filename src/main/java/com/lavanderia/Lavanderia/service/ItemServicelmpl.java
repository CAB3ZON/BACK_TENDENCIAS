/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.service;

import com.lavanderia.Lavanderia.model.Config_Empresa;
import com.lavanderia.Lavanderia.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.lavanderia.Lavanderia.repository.ItemRepository;

/**
 *
 * @author USUARIO
 */
@Service
public class ItemServicelmpl extends GenericServiceImpl<Item,Integer> implements GenericService<Item,Integer>{
@Autowired
ItemRepository itemMaquinaRepository;
    @Override
    public CrudRepository<Item, Integer> getDao() {
return itemMaquinaRepository;
    }
    
}

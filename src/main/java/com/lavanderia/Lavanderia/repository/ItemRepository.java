/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lavanderia.Lavanderia.repository;

import com.lavanderia.Lavanderia.model.Venta;
import com.lavanderia.Lavanderia.model.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
     @Query(value = "Select * from usuario u where u.nombre = :nombre", nativeQuery = true)
    public Item buscarITem_Maquina(String nombre); 
    
    @Query(value = "SELECT * FROM item WHERE id_orden IS NULL", nativeQuery = true)
    List<Item> itemssinorden();
}

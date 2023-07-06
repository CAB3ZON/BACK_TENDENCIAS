/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavanderia.Lavanderia.repository;

import com.lavanderia.Lavanderia.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ASUS ROG
 */
public interface OrdenRepository extends JpaRepository<Orden,Integer>{
    @Query(value = "Select * from orden u where u.nombre_per = :nombre_ord", nativeQuery = true)
    public Orden buscarOrden(String nombre);
}

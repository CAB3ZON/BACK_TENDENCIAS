/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lavanderia.Lavanderia.repository;

import com.lavanderia.Lavanderia.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface VentaRepository extends JpaRepository<Venta, Integer>{
    @Query(value = "Select * from usuario u where u.nombre = :nombre", nativeQuery = true)
    public Venta buscarConfig_Empresa(String nombre); 
}

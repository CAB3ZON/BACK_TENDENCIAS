/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavanderia.Lavanderia.repository;

import com.lavanderia.Lavanderia.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ASUS ROG
 */
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
    @Query(value = "SELECT orden.*, persona.id_persona AS persona_id_persona, persona.identificacion FROM orden JOIN persona ON orden.id_persona = persona.id_persona WHERE persona.identificacion = :identificacion", nativeQuery = true)
    public List<Orden> buscarOrden(@Param("identificacion") String cedula);

    @Query(value = "SELECT * FROM `orden` WHERE `id_venta` IS NULL", nativeQuery = true)
    public List<Orden> listarOrden();

    @Query(value = " SELECT * FROM `orden` WHERE `id_venta` IS NOT NULL", nativeQuery = true)
    public List<Orden> listarOrdenNoNull();
}
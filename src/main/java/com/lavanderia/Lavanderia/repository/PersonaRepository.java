/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lavanderia.Lavanderia.repository;


import com.lavanderia.Lavanderia.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author USUARIO
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
   @Query(value = "SELECT * FROM persona", nativeQuery = true)
    public Persona buscarPorCedula(@Param("identificacion") String cedula);
    
}

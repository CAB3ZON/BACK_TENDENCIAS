/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lavanderia.Lavanderia.repository;


import com.lavanderia.Lavanderia.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    @Query(value = "Select * from persona u where u.nombre_per = :nombre_per", nativeQuery = true)
    public Persona buscarPersona(String nombre);
}

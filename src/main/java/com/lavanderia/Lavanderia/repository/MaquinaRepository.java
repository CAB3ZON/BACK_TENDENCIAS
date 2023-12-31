/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lavanderia.Lavanderia.repository;

import com.lavanderia.Lavanderia.model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface MaquinaRepository  extends JpaRepository<Maquina, Integer>{
     @Query(value = "Select * from usuario u where u.nombre = :nombre", nativeQuery = true)
    public Maquina buscarMaquina(String nombre);
}

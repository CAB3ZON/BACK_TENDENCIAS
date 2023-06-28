/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lavanderia.Lavanderia.repository;

import com.lavanderia.Lavanderia.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface RolRepository extends JpaRepository<Rol, Integer>{
    @Query(value = "Select * from rol r where r.nombre_del_rol = :nombre_del_rol", nativeQuery = true)
    public Rol buscarRol(String nombre_del_rol);
}

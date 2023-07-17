/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lavanderia.Lavanderia.repository;

import com.lavanderia.Lavanderia.model.Venta;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author USUARIO
 */
public interface VentaRepository extends JpaRepository<Venta, Integer>{
@Query(value = "SELECT * FROM venta WHERE fecha = :fecha", nativeQuery = true)
public List<Venta> buscarfecha(String fecha);

    

   

}

////}   @Query(value = "SELECT * from usuario u where u.nombre = :nombre", nativeQuery = true)
//    public Venta buscarConfig_Empresa(String nombre); 

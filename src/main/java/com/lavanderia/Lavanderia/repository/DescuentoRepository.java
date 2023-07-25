/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lavanderia.Lavanderia.repository;

import com.lavanderia.Lavanderia.model.Descuento;
import com.lavanderia.Lavanderia.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USUARIO
 */
public interface DescuentoRepository extends JpaRepository<Descuento, Integer> {
       
}

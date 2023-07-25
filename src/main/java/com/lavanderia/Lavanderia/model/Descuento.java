/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Descuento {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDes")
    private int idDes;
     
     @Column(name = "nombre")
    private String nombre;
     
     @Column(name = "descuento")
    private double descuento;
}

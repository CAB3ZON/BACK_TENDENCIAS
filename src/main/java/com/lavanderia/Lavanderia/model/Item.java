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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Item {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private int id_item;    
 
 @Column(name = "cantidad")
    private int cantidad;
 
 @Column(name = "precio_total")
    private double precio_total;
 
 @ManyToOne
    @JoinColumn(name="id_service",referencedColumnName = "id_service")
    private Servicio servicio;
 
 
 @ManyToOne
    @JoinColumn(name="id_maq",referencedColumnName = "id_maq")
    private Maquina maquina;
 
 
 @ManyToOne
    @JoinColumn(name="id_orden",referencedColumnName = "id_orden")
    private Orden orden;
}

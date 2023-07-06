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
    @Column(name = "idItem")
    private int idItem;    
 
 @Column(name = "cantidad")
    private int cantidad;
 
 @Column(name = "precioTotal")
    private double precioTotal;
 
 @ManyToOne
    @JoinColumn(name="idService",referencedColumnName = "idService")
    private Servicio servicio;
 
 
 @ManyToOne
    @JoinColumn(name="idMaq",referencedColumnName = "idMaq")
    private Maquina maquina;
 
 
 @ManyToOne
    @JoinColumn(name="idOrden",referencedColumnName = "idOrden")
    private Orden orden;
}

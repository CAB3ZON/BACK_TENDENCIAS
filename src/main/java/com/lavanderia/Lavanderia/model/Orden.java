/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrden")
    private int idOrden;
    
    @Column(name = "estado")
    private int estado;
    
    
    @Column(name = "totalOrden")
    private double totalOrden;
    
    
    @ManyToOne
    @JoinColumn(name="idVenta",referencedColumnName = "idVenta")
    private Venta venta;
  
    
    @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName = "idPersona")
    private Persona personaO;
    
    @JsonIgnore
    @OneToMany(mappedBy="orden")
    private List<Item> listaItem;
    
}

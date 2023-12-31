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
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Venta {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private int idVenta;
      
    @Column(name = "fecha")
    private String fecha;  
    
    @Column(name = "tipoPago")
    private String tipoPago;
    
    @Column(name = "subtotal")
    private double subtotal;
    
    @Column(name = "descuento")
    private double descuento;
    
    @Column(name = "iva")
    private double iva;
    
    @Column(name = "total")
    private double total;
   
    
     @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName = "idPersona")
    private Persona personaf;
    
    @ManyToOne
    @JoinColumn(name="idConfig",referencedColumnName = "idConfig")
    private Config_Empresa configEmpresa;
    
    @JsonIgnore
    @OneToMany(mappedBy="venta")
    private List<Orden> listaOrden;
    
    
    
}   

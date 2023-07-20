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
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Config_Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConfig")
    private int idConfig;

    
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    
    @Column(name = "ruc")
    private String ruc;
    
    @Column(name = "ubicacion")
    private String ubicacion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "iva")
    private double iva;
    @JsonIgnore
    @OneToMany(mappedBy="configEmpresa")
    private List<Venta> listaFacturaC;
    
}

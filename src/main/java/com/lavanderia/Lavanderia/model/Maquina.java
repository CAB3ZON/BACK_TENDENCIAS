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
public class Maquina {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_maq")
    private int id_maq;
      
      @Column(name = "tamaño")
    private String tamaño;
      
       @Column(name = "precio")
    private double precio;
       
       
        @JsonIgnore
    @OneToMany(mappedBy="maquina")
    private List<Item> lista_itemM;
}

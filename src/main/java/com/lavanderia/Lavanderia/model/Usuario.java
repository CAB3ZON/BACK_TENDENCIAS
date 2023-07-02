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
 * @author 59398
 */

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;

    //@Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    //@NotBlank(message = "El usuario no puede estar en blanco")
    @Column(name = "username")
    private String username;
    
    //@NotBlank(message = "La clave no puede estar en blanco")
    @Column(name = "clave")
    private String clave;

    //@Email(message = "Debe ingresar una dirección de correo válida")
    //@Column(name = "email")
    //private String email;
    
    //@Column(name = "estado")
    //private int estado;
    
    @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName = "idPersona")
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name="id_rol",referencedColumnName = "id_rol")
    private Rol roles;
    
    
}

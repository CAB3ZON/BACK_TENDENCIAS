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
public class Rol {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private int idRol;
    
   // @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    //@NotBlank(message = "El rol no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;
    
   // @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
   // @NotBlank(message = "El usuario no puede estar en blanco")
    @Column(name = "descripcion")
    private String descripcion;
    
   // @NotBlank(message = "El rol no puede estar en blanco")
    @Column(name = "estado")
    private int estado;
    
    @JsonIgnore
    @OneToMany(mappedBy = "roles")
    private List<Usuario> listaUsuario;
}

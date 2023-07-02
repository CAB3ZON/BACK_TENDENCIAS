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
public class Persona {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private int idPersona;

   // @Size(min = 3, max = 10, message = "El nombre debe tener entre 3 y 10 caracteres")
   // @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombrePer")
    private String nombrePer;

   // @Size(min = 3, max = 10, message = "El apellido debe tener entre 3 y 10 caracteres")
    //@NotBlank(message = "El apellido no puede estar en blanco")
    //@Column(name = "apellido_per")
    //private String apellido_per;

   // @Email(message = "Debe ingresar una dirección de correo válida")
    @Column(name = "correo")
    private String correo;

   // @NotBlank(message = "La cedula no puede estar en blanco")
    @Column(name = "identificacion")
    private String identificacion;

   // @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion")
    private String direccion;


    @Column(name = "telefono")
    private String telefono;
    
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Usuario> listaUsuario;
    
    
    @JsonIgnore
    @OneToMany(mappedBy="personaf")
    private List<Venta> listaFactura;
    
    @JsonIgnore
    @OneToMany(mappedBy="personaO")
    private List<Orden> listaOrden;
    
     
}

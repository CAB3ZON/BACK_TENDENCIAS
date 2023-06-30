/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavanderia.Lavanderia.service;


import com.lavanderia.Lavanderia.model.Usuario;
import com.lavanderia.Lavanderia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 59398
 */
@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements GenericService<Usuario, Integer> {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return usuarioRepository;
    }

    public Usuario autenticarUsuario(String username, String clave) {
    // Aquí puedes realizar la lógica de autenticación consultando la base de datos
    // Supongamos que estás utilizando JPA para interactuar con la base de datos

    // Realizar una consulta para obtener el usuario por nombre de usuario
    Usuario usuario = usuarioRepository.findByUsername(username);

    if (usuario != null && usuario.getClave().equals(clave)) {
        return usuario; // El usuario se ha autenticado correctamente
    }

    return null; // Las credenciales de inicio de sesión no son válidas
}

}

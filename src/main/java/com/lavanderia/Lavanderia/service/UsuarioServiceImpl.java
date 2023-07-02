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
    
    Usuario usuario = usuarioRepository.findByUsername(username);

    if (usuario != null && usuario.getClave().equals(clave)) {
        return usuario; 
    }

    return null; 
}

}

package com.co.crud.service;

import com.co.crud.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario registrar(Usuario datosUsuario);
    Usuario editar(Usuario editUsuario);
    void eliminar(Integer idUsuario);
    List<Usuario> consultar (String nomUsuario);
    Boolean existeNombre(String nombreUsu);
}

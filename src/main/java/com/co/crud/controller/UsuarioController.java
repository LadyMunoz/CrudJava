package com.co.crud.controller;

import com.co.crud.model.Usuario;
import com.co.crud.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario registrar(@Valid @RequestBody Usuario datosUsuario)
    {
        return usuarioService.registrar(datosUsuario);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario editar(@RequestBody Usuario editUsuario)
    {
        return usuarioService.editar(editUsuario);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id)
    {
        usuarioService.eliminar(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> consultar(@RequestBody Usuario nomUsuario)
    {
        return usuarioService.consultar(nomUsuario.getNombre());
    }
}


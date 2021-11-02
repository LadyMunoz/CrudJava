package com.co.crud.service.impl;

import com.co.crud.dao.IUsuarioDAO;
import com.co.crud.exception.GenericException;
import com.co.crud.model.Usuario;
import com.co.crud.service.IUsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioDAO usuarioDAO;
    @Override
    public Usuario registrar(Usuario datosUsuario) {
        if(StringUtils.isBlank(datosUsuario.getNombre()))
        {
            throw new GenericException("El nombre de usuario es obligatorio");
        }
        else if (existeNombre(datosUsuario.getNombre()) == true){
            throw new GenericException("El nombre de usuario ya existe");
        }
        else if (datosUsuario.getActivo() == null)
        {
            throw new GenericException("El estado del usuario es obligatorio");
        }
        else if (datosUsuario.getIdRol() == null || datosUsuario.getIdRol().getIdRol() == null) {
            throw new GenericException("El rol del usuario es obligatorio");
        }
        else
        {
            return usuarioDAO.save(datosUsuario);
        }

    }

    @Override
    public Usuario editar(Usuario editUsuario) {

        if(StringUtils.isBlank(editUsuario.getNombre())) {
            throw new GenericException("El nombre de usuario es obligatorio");
        }
        else if (editUsuario.getActivo() == null){
            throw new GenericException("El estado del usuario es obligatorio");
        }
        else if (editUsuario.getIdRol() == null || editUsuario.getIdRol().getIdRol() == null) {
            throw new GenericException("El rol del usuario es obligatorio");
        }
        else
        {
            return usuarioDAO.save(editUsuario);
        }
    }

    @Override
    public void eliminar(Integer idUsuario) {
        usuarioDAO.deleteById(idUsuario);
    }

    @Override
    public List<Usuario> consultar(String nomUsuario) {
        if(StringUtils.isBlank(nomUsuario)) {
            return usuarioDAO.findAll();
        }
        else {
            return usuarioDAO.buscarxNombre("%" + nomUsuario + "%");
        }
    }

    @Override
    public Boolean existeNombre(String nombreUsu)
    {
        String nomUsuConsul;
        nomUsuConsul =  usuarioDAO.validarNombre(nombreUsu);
        if (StringUtils.isBlank(nomUsuConsul)) {
            return false;
        }
        else{
            return true;
        }

    }
}

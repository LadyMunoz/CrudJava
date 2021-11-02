package com.co.crud.dao;

import com.co.crud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsuarioDAO extends JpaRepository<Usuario,Integer> {
    @Query(value = "Select nombre from usuario where nombre = :nombreUsu", nativeQuery = true)
    String validarNombre(@Param("nombreUsu") String nombreUsu);

    @Query(value = "Select * from usuario where nombre like :nombreUsu", nativeQuery = true)
    List<Usuario> buscarxNombre(@Param("nombreUsu") String nombreUsu);

}


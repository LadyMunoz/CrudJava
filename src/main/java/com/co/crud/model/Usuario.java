package com.co.crud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false, foreignKey = @ForeignKey(name = "rol_usuario"))
    private Rol idRol;

    @Column(name="Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name="Activo", nullable = false)
    private Character activo;

}

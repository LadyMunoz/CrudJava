package com.co.crud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="Rol")
public class Rol {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name="Nombre" , nullable = false, length = 50)
    private String nombre;
}

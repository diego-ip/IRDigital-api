package com.irdigital.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento", columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_probable_muerte", columnDefinition = "DATE")
    private LocalDate fechaProbableMuerte;

    @Transient
    private Integer edad;

    @PostLoad
    private void posLoad(){
        this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}

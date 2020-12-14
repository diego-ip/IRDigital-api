package com.irdigital.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ClienteModel {

    @ApiModelProperty(example = "1")
    private Integer id;

    @ApiModelProperty(example = "Diego")
    private String nombre;

    @ApiModelProperty(example = "Mendoza")
    private String apellidoPaterno;

    @ApiModelProperty(example = "Gomez")
    private String apellidoMaterno;

    @ApiModelProperty(example = "1991-06-12")
    private LocalDate fechaNacimiento;

    @ApiModelProperty(example = "29")
    private Integer edad;

    @ApiModelProperty(example = "2050-07-28")
    private LocalDate fechaProbableMuerte;
}

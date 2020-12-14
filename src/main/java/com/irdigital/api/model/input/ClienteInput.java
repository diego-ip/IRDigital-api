package com.irdigital.api.model.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
public class ClienteInput {

    @ApiModelProperty(example = "Diego", required = true)
    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;

    @ApiModelProperty(example = "Mendoza", required = true)
    @NotBlank(message = "el apellido paterno es obligatorio")
    private String apellidoPaterno;

    @ApiModelProperty(example = "Gomez", required = true)
    @NotBlank(message = "el apellido materno es obligatorio")
    private String apellidoMaterno;

    @ApiModelProperty(example = "1991-06-12", required = true)
    @NotNull(message = "la fecha de nacimiento es obligatorio")
    private LocalDate fechaNacimiento;
}

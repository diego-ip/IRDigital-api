package com.irdigital.api.config.exceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel("Problema")
@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problem {

    @ApiModelProperty(example = "400", position = 1)
    private Integer status;

    @ApiModelProperty(example = "2019-12-01T18:09:02.70844Z", position = 5)
    private OffsetDateTime timestamp;


    @ApiModelProperty(example = "Datos inválidos", position = 15)
    private String title;

    @ApiModelProperty(example = "Uno o más campos no son válidos. Complete correctamente y vuelva a intentarlo",
            position = 20)
    private String detail;

    @ApiModelProperty(example = "Uno o más campos no son válidos. Complete correctamente y vuelva a intentarlo",
            position = 25)
    private String userMessage;

    @ApiModelProperty(value = "Lista de objetos o campos que generaron el error (opcional)",
            position = 30)
    private List<Object> objects;

    @ApiModel("ObjetoProblema")
    @Getter
    @Builder
    public static class Object {

        @ApiModelProperty(example = "nombre")
        private String name;

        @ApiModelProperty(example = "el nombre es obligatorio")
        private String userMessage;

    }

}

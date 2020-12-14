package com.irdigital.api.config.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    DADOS_INVALIDOS("Dados inválidos"),
    ACESSO_DENEGADO( "Acesso denegado"),
    ERROR_DE_SISTEMA( "Error del sistema"),
    PARAMETRO_INVALIDO( "Parametro inválido"),
    MENSAGE_INCOMPRENSIBLE( "Mensage incomprensible"),
    RECURSO_NO_ENCONTRADO( "Recurso no encontrado"),
    ENTIDAD_EN_USO("Entidad en uso"),
    ERROR_NEGOCIO( "Error de regla de negocio");

    private String title;


    ProblemType( String title) {
        this.title = title;
    }

}

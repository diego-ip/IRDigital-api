package com.irdigital.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteKpi {

    @ApiModelProperty(example = "25.7")
    private Double promedioEdad;
    @ApiModelProperty(example = "7.75656")
    private Double desviacionEstandarEdad;

}

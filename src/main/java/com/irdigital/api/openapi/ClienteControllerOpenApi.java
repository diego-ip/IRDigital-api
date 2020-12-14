package com.irdigital.api.openapi;

import com.irdigital.api.model.ClienteKpi;
import com.irdigital.api.model.ClienteModel;
import com.irdigital.api.model.input.ClienteInput;

import io.swagger.annotations.*;
import java.util.List;

@Api(tags = "Clientes")
public interface ClienteControllerOpenApi {

    @ApiOperation("registrar un cliente")
    @ApiResponses({
            @ApiResponse(code = 201, message = "cliente registrado"),
    })
    ClienteModel save(@ApiParam(name = "cuerpo", value = "representación de un nuevo cliente", required = true) ClienteInput clienteInput);

    @ApiOperation("Lista de clientes")
    List<ClienteModel> findAll();

    @ApiOperation("KPI de clientes")
    ClienteKpi getKpi();
}

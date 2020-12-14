package com.irdigital.api.controller;

import com.irdigital.api.domain.Cliente;
import com.irdigital.api.mapper.ClienteInputMapper;
import com.irdigital.api.mapper.ClienteModelMapper;
import com.irdigital.api.model.ClienteKpi;
import com.irdigital.api.model.ClienteModel;
import com.irdigital.api.model.input.ClienteInput;
import com.irdigital.api.openapi.ClienteControllerOpenApi;
import com.irdigital.api.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController implements ClienteControllerOpenApi {

    private final ClienteServiceImpl clienteService;
    private final ClienteInputMapper clienteInputMapper;
    private final ClienteModelMapper clienteModelMapper;


    @Autowired
    public ClienteController(ClienteServiceImpl clienteService, ClienteInputMapper clienteInputMapper, ClienteModelMapper clienteModelMapper) {
        this.clienteService = clienteService;
        this.clienteInputMapper = clienteInputMapper;
        this.clienteModelMapper = clienteModelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ClienteModel save(@RequestBody @Valid ClienteInput clienteInput) {

        final Cliente cliente = this.clienteInputMapper.toDomainObject(clienteInput);
        Cliente clienteSave = this.clienteService.save(cliente);
        ClienteModel clienteModel = this.clienteModelMapper.toModel(clienteSave);
        return clienteModel;
    }

    @GetMapping
    @Override
    public List<ClienteModel> findAll() {

        List<Cliente> clientes = this.clienteService.findAll();
        List<ClienteModel> clienteModels = this.clienteModelMapper.toCollectionModel(clientes);
        return clienteModels;
    }

    @GetMapping(path = "/kpideclientes")
    @Override
    public ClienteKpi getKpi() {
        ClienteKpi clienteKpi = this.clienteService.getKpi();
        return clienteKpi;
    }


}

package com.irdigital.api.mapper;

import com.irdigital.api.domain.Cliente;
import com.irdigital.api.model.input.ClienteInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class ClienteInputMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ClienteInputMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Cliente toDomainObject(ClienteInput clienteInput) {
        return modelMapper.map(clienteInput, Cliente.class);
    }

}

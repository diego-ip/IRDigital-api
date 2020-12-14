package com.irdigital.api.mapper;

import com.irdigital.api.domain.Cliente;
import com.irdigital.api.model.ClienteModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteModelMapper  {

    private final ModelMapper modelMapper;

    @Autowired
    public ClienteModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ClienteModel toModel(Cliente cliente) {
        return  modelMapper.map(cliente, ClienteModel.class);
    }

    public List<ClienteModel>  toCollectionModel(List<Cliente> entities) {
        List<ClienteModel> collect = entities.stream().map(el -> toModel(el)).collect(Collectors.toList());
        return  collect;
    }

}

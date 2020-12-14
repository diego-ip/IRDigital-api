package com.irdigital.api.service;

import com.irdigital.api.domain.Cliente;
import com.irdigital.api.model.ClienteKpi;

import java.util.List;

public interface ClienteService {

    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    ClienteKpi getKpi();
}

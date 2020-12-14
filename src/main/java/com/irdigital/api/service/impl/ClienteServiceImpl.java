package com.irdigital.api.service.impl;

import com.irdigital.api.domain.Cliente;
import com.irdigital.api.model.ClienteKpi;
import com.irdigital.api.repository.ClienteRepository;
import com.irdigital.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepo;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, JdbcTemplate jdbcTemplate) {
        this.clienteRepo = clienteRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Cliente save(Cliente cliente) {
        int age = Period.between(cliente.getFechaNacimiento(), LocalDate.now()).getYears();
        int edadProbableMuerte;

        // fecha promedio de muerte peru  = 76
        int edadPromedioMuerte = 76;

        if (edadPromedioMuerte > age) {
            edadProbableMuerte = edadPromedioMuerte + ThreadLocalRandom.current().nextInt(0, 5 );
        } else {
            edadProbableMuerte =  age + ThreadLocalRandom.current().nextInt(1, 6);
        }

        LocalDate fechaProbableMuerte = cliente.getFechaNacimiento().plusYears(edadProbableMuerte);
        cliente.setFechaProbableMuerte(fechaProbableMuerte);

        Cliente clienteSave = this.clienteRepo.saveAndFlush(cliente);
        clienteSave.setEdad(age);
        return clienteSave;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = this.clienteRepo.findAll();
        return clientes;
    }

    @Override
    public ClienteKpi getKpi() {
        final String QUERY_KPI =
                "select avg(date_part('year', age(fecha_nacimiento)))        as prom_age, " +
                        "       stddev_pop(date_part('year', age(fecha_nacimiento))) as stddev_age " +
                        "from cliente;";

        ClienteKpi clienteKpi = this.jdbcTemplate.queryForObject(QUERY_KPI, (rs, i) -> {
            ClienteKpi clienteKpiTemp = new ClienteKpi();
            clienteKpiTemp.setPromedioEdad(rs.getDouble("prom_age"));
            clienteKpiTemp.setDesviacionEstandarEdad(rs.getDouble("stddev_age"));
            return clienteKpiTemp;
        });

        return clienteKpi;
    }

}

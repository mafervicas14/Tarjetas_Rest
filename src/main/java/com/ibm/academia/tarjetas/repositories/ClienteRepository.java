package com.ibm.academia.tarjetas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ibm.academia.tarjetas.models.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>
{

}

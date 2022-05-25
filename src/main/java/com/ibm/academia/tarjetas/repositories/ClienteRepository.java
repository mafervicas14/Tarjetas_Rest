package com.ibm.academia.tarjetas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.tarjetas.models.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>
{
	
}

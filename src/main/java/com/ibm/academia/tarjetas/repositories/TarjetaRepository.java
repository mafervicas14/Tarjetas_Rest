package com.ibm.academia.tarjetas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ibm.academia.tarjetas.models.entities.Tarjeta;

public interface TarjetaRepository extends CrudRepository<Tarjeta, Long>
{

}

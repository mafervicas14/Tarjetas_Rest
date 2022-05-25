package com.ibm.academia.tarjetas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ibm.academia.tarjetas.enums.Preferencias;
import com.ibm.academia.tarjetas.models.entities.Cliente;
import com.ibm.academia.tarjetas.models.entities.Tarjeta;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Long>
{
	List<Tarjeta> findByPreferencias(Preferencias preferencias);
}

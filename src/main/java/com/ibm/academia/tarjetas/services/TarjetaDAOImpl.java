package com.ibm.academia.tarjetas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.tarjetas.models.entities.Tarjeta;
import com.ibm.academia.tarjetas.repositories.TarjetaRepository;

@Service
public class TarjetaDAOImpl extends GenericoDAOImpl<Tarjeta, TarjetaRepository> implements TarjetaDAO
{

	@Autowired
	public TarjetaDAOImpl(TarjetaRepository repository) {
		super(repository);
	}

}

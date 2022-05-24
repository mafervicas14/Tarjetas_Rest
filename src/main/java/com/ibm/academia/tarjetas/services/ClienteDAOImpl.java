package com.ibm.academia.tarjetas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.tarjetas.models.entities.Cliente;
import com.ibm.academia.tarjetas.repositories.ClienteRepository;

@Service
public class ClienteDAOImpl extends GenericoDAOImpl<Cliente, ClienteRepository> implements ClienteDAO
{

	@Autowired
	public ClienteDAOImpl(ClienteRepository repository) {
		super(repository);
	}

}

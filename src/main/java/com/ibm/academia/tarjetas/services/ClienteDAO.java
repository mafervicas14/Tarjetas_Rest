package com.ibm.academia.tarjetas.services;

import com.ibm.academia.tarjetas.models.entities.Cliente;
import com.ibm.academia.tarjetas.models.entities.Tarjeta;

public interface ClienteDAO extends GenericoDAO<Cliente>
{
	 public Cliente asociarClienteConTarjeta(Cliente cliente, Tarjeta tarjeta);
	 
}

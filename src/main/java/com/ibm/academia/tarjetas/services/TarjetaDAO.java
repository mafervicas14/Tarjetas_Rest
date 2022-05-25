package com.ibm.academia.tarjetas.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ibm.academia.tarjetas.enums.Preferencias;
import com.ibm.academia.tarjetas.models.entities.Cliente;
import com.ibm.academia.tarjetas.models.entities.Tarjeta;

public interface TarjetaDAO extends GenericoDAO<Tarjeta>
{
	
	
	public List<Tarjeta> findByPreferencias(Preferencias preferencias);
	public ResponseEntity<?> tarjetasAceptadas(Cliente cliente);

}

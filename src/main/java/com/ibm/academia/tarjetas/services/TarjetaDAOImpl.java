package com.ibm.academia.tarjetas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.academia.tarjetas.enums.NombreTarjetas;
import com.ibm.academia.tarjetas.enums.Preferencias;
import com.ibm.academia.tarjetas.exceptions.BadRequestException;
import com.ibm.academia.tarjetas.exceptions.NotFoundException;
import com.ibm.academia.tarjetas.models.entities.Cliente;
import com.ibm.academia.tarjetas.models.entities.Tarjeta;
import com.ibm.academia.tarjetas.repositories.TarjetaRepository;

@Service
public class TarjetaDAOImpl extends GenericoDAOImpl<Tarjeta, TarjetaRepository> implements TarjetaDAO
{

	
	@Autowired
	public TarjetaDAOImpl(TarjetaRepository repository) {
		super(repository);
	}

	@Override
	public List<Tarjeta> findByPreferencias(Preferencias preferencias) {
		return repository.findByPreferencias(preferencias);
	}

	@Override
	public ResponseEntity<?> tarjetasAceptadas(Cliente cliente) {
		Preferencias clientePreferencias = cliente.getPreferencias();
		List<Tarjeta> tarjetasPorPreferencias = findByPreferencias(clientePreferencias);
		System.out.println(tarjetasPorPreferencias.toString());
		List<NombreTarjetas> tarjetasDisponibles = new ArrayList<>();
		
		Integer clienteEdad = cliente.getEdad();
		Double clienteSalario = cliente.getSalarioMensual();
		
		if(!tarjetasPorPreferencias.isEmpty()) {
			for(Tarjeta tarjeta:tarjetasPorPreferencias) {
				System.out.println("Tarjetas que recorre" + tarjeta.toString());
				if(tarjeta.getEdadMaxima() >= clienteEdad &&  tarjeta.getEdadMinima() <= clienteEdad){
					{
						if(tarjeta.getSalarioMaximo() >= clienteSalario && tarjeta.getSalarioMinimo() <= clienteSalario) 
						{
							tarjetasDisponibles.add(tarjeta.getNombreTarjeta());
							
						}
					}
				}
			} return new ResponseEntity<List<NombreTarjetas>>(tarjetasDisponibles, HttpStatus.OK);
			
		} else {
			throw new BadRequestException("Error al tratar de buscar la preferencia");
		}
		
	}

}

package com.ibm.academia.tarjetas.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.tarjetas.exceptions.BadRequestException;
import com.ibm.academia.tarjetas.exceptions.NotFoundException;
import com.ibm.academia.tarjetas.models.entities.Cliente;
import com.ibm.academia.tarjetas.models.entities.Tarjeta;
import com.ibm.academia.tarjetas.services.ClienteDAO;
import com.ibm.academia.tarjetas.services.TarjetaDAO;

@RestController
@RequestMapping("/tarjetas")
public class TarjetasController 
{
	
	@Autowired
	private TarjetaDAO tarjetaDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	/**
	 * Endpoint para crear un Objeto de tipo Tarjeta
	 * @param tarjeta traé toda la información del cliente
	 * @return el estado Http y la información de la tarjeta
	 * @author Equipo7
	 */
	@PostMapping()
    public ResponseEntity<?> crearTarjeta(@RequestBody Tarjeta tarjeta)
    {
        Tarjeta tarjetaGuardada= tarjetaDAO.guardar(tarjeta);
        return new ResponseEntity<Tarjeta>(tarjetaGuardada, HttpStatus.CREATED);
    }
	
	/**
	 * Endpoint para listar todos los objetos de tipo Tarjeta
	 * @return lista de tarjetas
	 * @BadRequestException En caso de que no existan Tarjetas (Lista vacía)
	 * @author Equipo7
	 */
	@GetMapping("/lista/tarjetas")
    public List<Tarjeta> buscarTodas()
    {
        List<Tarjeta> tarjetas = (List<Tarjeta>) tarjetaDAO.buscarTodos();
        if(tarjetas.isEmpty())
            throw  new BadRequestException("No existen clientes");
        return tarjetas;
    }
	
	@GetMapping("/buscarTarjetas/clienteId/{clienteId}")
	public ResponseEntity<?> asginarTarjetaEntity (@PathVariable Long clienteId)
	{
		Optional<Cliente> oCliente = clienteDAO.buscarPorId(clienteId);
		
		if(!oCliente.isPresent())
			throw new NotFoundException(String.format("El cliente con el Id: %d no existe", clienteId));
		return tarjetaDAO.tarjetasAceptadas(oCliente.get());
		
	}

}

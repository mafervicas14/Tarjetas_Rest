package com.ibm.academia.tarjetas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.tarjetas.exceptions.BadRequestException;
import com.ibm.academia.tarjetas.models.entities.Cliente;
import com.ibm.academia.tarjetas.services.ClienteDAO;

@RestController
@RequestMapping("/cliente")
public class ClienteController 
{
	@Autowired
	private ClienteDAO clienteDAO;
	
	/**
	 * Endpoint para crear un Objeto de tipo Cliente
	 * @param cliente traé toda la información del cliente
	 * @return el estado Http y la información del cliente
	 * @author Equipo7
	 */
	@PostMapping()
    public ResponseEntity<?> crearAula(@Valid @RequestBody Cliente cliente,  BindingResult result)
    {
		 Map<String, Object> validaciones = new HashMap<String, Object>();
	        if(result.hasErrors())
	        {
	            List<String> listaErrores = result.getFieldErrors()
	                    .stream()
	                    .map(errores -> "Campo: '" + errores.getField() + "'" + errores.getDefaultMessage())
	                    .collect(Collectors.toList());
	            validaciones.put("Lista Errores", listaErrores);
	            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
	        }
	        
        Cliente clienteGuardado= clienteDAO.guardar(cliente);
        return new ResponseEntity<Cliente>(clienteGuardado, HttpStatus.CREATED);
    }
	
	
	/**
	 * Endpoint para listar todos los objetos de tipo Cliente
	 * @return lista de clientes 
	 * @BadRequestException En caso de que no existan Clientes (Lista vacía)
	 * @author Equipo7
	 */
	@GetMapping("/lista/clientes")
    public List<Cliente> buscarTodas()
    {
        List<Cliente> clientes = (List<Cliente>) clienteDAO.buscarTodos();
        if(clientes.isEmpty())
            throw  new BadRequestException("No existen clientes");
        return clientes;
    }
	
}

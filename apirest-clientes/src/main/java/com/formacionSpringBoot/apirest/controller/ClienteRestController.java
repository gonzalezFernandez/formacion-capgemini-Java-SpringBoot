package com.formacionSpringBoot.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionSpringBoot.apirest.entity.Cliente;
import com.formacionSpringBoot.apirest.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private ClienteService servicio;
	
	@GetMapping({"/clientes","/todos"})
	public List<Cliente> index(){
		return servicio.findAll();
	}
	
//	@GetMapping("clientes/{id}")
//	public Cliente findClienteById(@PathVariable Long id) {
//		return servicio.findById(id);
//	}
	
	@GetMapping("clientes/{id}")
	public ResponseEntity<?>  findClienteById(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String, Object> response=new HashMap<>();
		
		try {
			cliente = servicio.findById(id);
		}catch (DataAccessException e) {//MUY ESPECÍFICO, EXCEPCIONES SOBRE EL DAO
			response.put("mensaje", "Error al rellenar la consulta a base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(cliente ==null) {
		response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	
	
	}
	
	
	
//	@PostMapping("/cliente")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Cliente saveCliente(@RequestBody Cliente cliente) {
//		return servicio.save(cliente);
//	}
	
	
	@PostMapping("/cliente")
	public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente){
		Cliente clienteNew = null;
		
		Map<String, Object>response = new HashMap<>();
		
		try {
			clienteNew = servicio.save(cliente);
			
			
		}catch (DataAccessException e) {//MUY ESPECÍFICO, EXCEPCIONES SOBRE EL DAO
			response.put("mensaje", "Error al rellenar la consulta a base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("cliente", clienteNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		
	}
	
	
	
//	@PutMapping("/cliente/{id}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
//		
//		Cliente clienteUpdate = servicio.findById(id);
//		
//		clienteUpdate.setNombre(cliente.getNombre());
//		clienteUpdate.setApellido(cliente.getApellido());
//		clienteUpdate.setEmail(cliente.getEmail());
//		clienteUpdate.setTelefono(cliente.getTelefono());
//		clienteUpdate.setCreatedAt(cliente.getCreatedAt());
//		
//		return servicio.save(clienteUpdate);
//		
//	}
	
	@PutMapping("/cliente/{id}")
	public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		
		Cliente clienteActual = servicio.findById(id);
		
		Map<String, Object> response = new HashMap<>();
		
		if(clienteActual == null) {
			response.put("mensaje", "Error: no se pudo editar el cliente con ID: "+id.toString()+" no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		clienteActual.setTelefono(cliente.getTelefono());
		clienteActual.setCreatedAt(cliente.getCreatedAt());
		
		servicio.save(clienteActual);
		
		}catch (DataAccessException e) {//MUY ESPECÍFICO, EXCEPCIONES SOBRE EL DAO
			response.put("mensaje", "Error al rellenar la consulta a base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido actualizadocon éxito!");
		response.put("cliente", clienteActual);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		
	}
	
	@DeleteMapping("/cliente/{id}")
	public void deleteCliente(@PathVariable Long id) {
		servicio.delete(id);
	}
	
	//@DeleteMapping

	
}

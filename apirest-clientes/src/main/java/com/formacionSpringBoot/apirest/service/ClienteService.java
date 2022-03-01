package com.formacionSpringBoot.apirest.service;

import java.util.List;

import com.formacionSpringBoot.apirest.entity.Cliente;

public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
}

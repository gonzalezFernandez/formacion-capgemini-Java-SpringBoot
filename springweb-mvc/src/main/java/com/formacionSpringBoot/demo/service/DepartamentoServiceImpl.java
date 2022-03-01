package com.formacionSpringBoot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionSpringBoot.demo.dao.DepartamentoDao;
import com.formacionSpringBoot.demo.entity.Departamento;



@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	private DepartamentoDao repositorio;
	
	@Override
	public List<Departamento> listarTodosLosDepartamentos() {
		return repositorio.findAll();
	}

	@Override
	public Departamento guardarDepartamento(Departamento departamento) {
		return repositorio.save(departamento);
	}

	@Override
	public Departamento obtenerDepartamento(Long id) {
		
		return repositorio.findById(id).get();
	}

	@Override
	public void eliminarDepartamento(Long id) {
		
		repositorio.deleteById(id);
		
	}

}

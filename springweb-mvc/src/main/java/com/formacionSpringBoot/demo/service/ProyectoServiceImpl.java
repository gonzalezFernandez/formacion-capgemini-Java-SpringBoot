package com.formacionSpringBoot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionSpringBoot.demo.dao.ProyectoDao;
import com.formacionSpringBoot.demo.entity.Proyecto;



@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	@Autowired
	private ProyectoDao repositorio;
	
	@Override
	public List<Proyecto> listarTodosLosProyectos() {
		return repositorio.findAll();
	}

	@Override
	public Proyecto guardarProyecto(Proyecto proyecto) {
		return repositorio.save(proyecto);
	}

	@Override
	public Proyecto obtenerProyecto(Long id) {
		
		return repositorio.findById(id).get();
	}

	@Override
	public void eliminarProyecto(Long id) {
		
		repositorio.deleteById(id);
		
	}

}

package com.formacionSpringBoot.demo.service;

import java.util.List;

import com.formacionSpringBoot.demo.entity.Proyecto;



public interface ProyectoService {
	
	public List<Proyecto> listarTodosLosProyectos();
	
	public Proyecto guardarProyecto(Proyecto proyecto);
	
	public Proyecto obtenerProyecto(Long id);
	
	public void eliminarProyecto(Long id);

}

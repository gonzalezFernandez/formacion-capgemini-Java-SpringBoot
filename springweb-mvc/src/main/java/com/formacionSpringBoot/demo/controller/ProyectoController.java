package com.formacionSpringBoot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacionSpringBoot.demo.entity.Proyecto;
import com.formacionSpringBoot.demo.service.ProyectoService;



@Controller
public class ProyectoController {
	
	@Autowired
	private ProyectoService servicio;
	
	@GetMapping("/proyectos")
	public String mostrarProyectos(Model modelo) {
		
		modelo.addAttribute("dato",servicio.listarTodosLosProyectos());
		return "proyectos";
	}
	
	@GetMapping("proyecto/nuevo")
	public String crearProyectoTemplate(Model modelo) {
		Proyecto proy= new Proyecto();
		modelo.addAttribute("keyProyecto",proy);
		
		return "nuevo_proyecto";
	}
	
	@PostMapping("/proyecto")
	public String guardarProyecto(@ModelAttribute("KeyProyecto") Proyecto proyecto) {
		servicio.guardarProyecto(proyecto);
		return "redirect:/proyectos";
	}
	
	@GetMapping("/proyecto/editar/{id}")
	public String editarProyectoTemplate(@PathVariable Long id,Model modelo) {
		modelo.addAttribute("keyProyecto",servicio.obtenerProyecto(id));
		
		return "editar_proyecto";
	}
	
	@PostMapping("/proyecto/{id}")
	public String actualizarProyecto(@PathVariable Long id,@ModelAttribute("keyProyecto") Proyecto proyecto) {
		
		Proyecto proyectoExistente = servicio.obtenerProyecto(id);
		
		proyectoExistente.setId(id);
		proyectoExistente.setNombre(proyecto.getNombre());
		proyectoExistente.setFecha_inicio(proyecto.getFecha_inicio());
		proyectoExistente.setFecha_fin(proyecto.getFecha_fin());
		proyectoExistente.setActivo(proyecto.getActivo());
		
		servicio.guardarProyecto(proyectoExistente);
		
		return "redirect:/proyectos";
	}
	
	@PostMapping("/proyecto/eliminar/{id}")
	public String eliminarProyecto(@PathVariable Long id) {
		servicio.eliminarProyecto(id);
		
		return "redirect:/proyectos";
	}
	
}
	
	



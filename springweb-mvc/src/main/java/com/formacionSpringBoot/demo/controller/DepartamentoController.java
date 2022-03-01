package com.formacionSpringBoot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacionSpringBoot.demo.entity.Departamento;
import com.formacionSpringBoot.demo.service.DepartamentoService;

@Controller
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService servicio;

	
	@GetMapping("/departamentos")
	public String mostrarProyectos(Model modelo) {
		
		modelo.addAttribute("dato",servicio.listarTodosLosDepartamentos());
		return "departamentos";
	}
	
	@GetMapping("departamento/nuevo")
	public String crearDepartamentoTemplate(Model modelo) {
		Departamento dep= new Departamento();
		modelo.addAttribute("keyDepartamento",dep);
		
		return "nuevo_departamento";
	}
	
	@PostMapping("/departamento")
	public String guardarDepartamento(@ModelAttribute("KeyDepartamento") Departamento departamento) {
		servicio.guardarDepartamento(departamento);
		return "redirect:/departamentos";
	}
	
	@GetMapping("/departamento/editar/{id}")
	public String editarDepartamentoTemplate(@PathVariable Long id,Model modelo) {
		modelo.addAttribute("keyDepartamento",servicio.obtenerDepartamento(id));
		
		return "editar_departamento";
	}
	
	@PostMapping("/departamento/{id}")
	public String actualizarDepartamento(@PathVariable Long id,@ModelAttribute("keyDepartamento") Departamento departamento) {
		
		Departamento departamentoExistente = servicio.obtenerDepartamento(id);
		
		departamentoExistente.setId(id);
		departamentoExistente.setNombre(departamento.getNombre());
		
		
		servicio.guardarDepartamento(departamentoExistente);
		
		return "redirect:/departamentos";
	}
	
	@PostMapping("/departamento/eliminar/{id}")
	public String eliminarDepartamento(@PathVariable Long id) {
		servicio.eliminarDepartamento(id);
		
		return "redirect:/departamentos";
	}
	
	
}

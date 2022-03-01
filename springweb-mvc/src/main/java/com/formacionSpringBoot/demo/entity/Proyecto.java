package com.formacionSpringBoot.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proyectos")
public class Proyecto implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length=50)
	private String nombre;
	
	@Column(nullable = false, length=50)
	private String fecha_inicio;
	
	@Column(nullable = false, length=50)
	private String fecha_fin;
	
	@Column(nullable = false, length=50)
	private String activo;

	
	
	
		public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getFecha_inicio() {
		return fecha_inicio;
	}





	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}





	public String getFecha_fin() {
		return fecha_fin;
	}





	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}





	public String getActivo() {
		return activo;
	}





	public void setActivo(String activo) {
		this.activo = activo;
	}



	//Serializable

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	
}


package com.formacionSpringBoot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacionSpringBoot.demo.entity.Empleado;

@Repository
public interface EmpleadoDao extends JpaRepository<Empleado, Long>{

}

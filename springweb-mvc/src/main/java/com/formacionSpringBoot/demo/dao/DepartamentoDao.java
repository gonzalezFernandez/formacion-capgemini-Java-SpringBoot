package com.formacionSpringBoot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacionSpringBoot.demo.entity.Departamento;



@Repository
public interface DepartamentoDao extends JpaRepository<Departamento, Long>{

}

package com.formacionSpringBoot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacionSpringBoot.demo.entity.Proyecto;



@Repository
public interface ProyectoDao extends JpaRepository<Proyecto, Long>{

}

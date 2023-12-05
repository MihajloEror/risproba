package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Glumi;

public interface GlumiRepository extends JpaRepository<Glumi, Integer> {
	
	@Query("select g from Glumi g inner join g.glumiUizvodjenjus gi where gi.izvodjenje.predstava.idPredstava = :idP")
	List<Glumi> getUlogeZaPredstavu(@Param("idP")Integer id);

}

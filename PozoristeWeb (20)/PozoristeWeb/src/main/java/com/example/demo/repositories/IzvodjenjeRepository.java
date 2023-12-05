package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Izvodjenje;

public interface IzvodjenjeRepository extends JpaRepository<Izvodjenje, Integer> {

	@Query("select i from Izvodjenje i where i.predstava.naziv = :nazivP")
	List<Izvodjenje> findByNazivPredstave(@Param("nazivP")String p);
}

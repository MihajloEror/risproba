package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Izvodjenje;

public interface IzvodjenjeRepository extends JpaRepository<Izvodjenje, Integer> {

	@Query("select i from Izvodjenje i inner join i.predstava.zanrPredstaves zp "
			+ "where zp.zanr.naziv =:z and zp.predstava = i.predstava order by i.scena.idScena")
	List<Izvodjenje> getIzvodjenjaZanra(@Param("z") String zanr);
}

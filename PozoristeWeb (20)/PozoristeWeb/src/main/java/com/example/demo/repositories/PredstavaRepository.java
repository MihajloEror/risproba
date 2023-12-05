package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Predstava;

public interface PredstavaRepository extends JpaRepository<Predstava, Integer> {

	@Query("select p from Predstava p inner join p.zanrPredstaves zp where zp.zanr.idZanr =:idZ")
	List<Predstava> findByZanr(@Param("idZ")Integer id);
}

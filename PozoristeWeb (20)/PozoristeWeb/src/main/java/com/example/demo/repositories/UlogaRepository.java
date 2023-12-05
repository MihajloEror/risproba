package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Uloga;

public interface UlogaRepository extends JpaRepository<Uloga, Integer>{

	@Query("select count(u.idUloga) from Uloga u where u.predstava.idPredstava = :idP")
	Integer getBrojUloga(@Param("idP") Integer idP);
}

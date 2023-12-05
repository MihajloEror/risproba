package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.GlumiRepository;
import com.example.demo.repositories.PredstavaRepository;
import com.example.demo.repositories.UlogaRepository;
import com.example.demo.repositories.ZanrRepository;

import model.Glumi;
import model.Predstava;
import model.Zanr;

@Service
public class PredstaveService {
	
	@Autowired
	ZanrRepository zr;

	@Autowired
	PredstavaRepository pr;
	
	@Autowired
	GlumiRepository gr;
	
	@Autowired
	UlogaRepository ur;
	
	public List<Zanr> getZanrovi(){
		return zr.findAll();
	}
	
	public List<Predstava> getPredstave(Integer idZanr){
		return pr.findByZanr(idZanr);
	}
	
	public Zanr getZanr(Integer idZanr) {
		return zr.findById(idZanr).get();
	}
	
	public List<Glumi> getGlumi(Integer idP){
		return gr.getUlogeZaPredstavu(idP);
	}
	
	public Integer getBrojUloga(Integer idP) {
		return ur.getBrojUloga(idP);
	}
}

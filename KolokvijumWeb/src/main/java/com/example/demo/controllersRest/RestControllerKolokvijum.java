package com.example.demo.controllersRest;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GlumacDTO;
import com.example.demo.services.PripremaService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("api/kolokvijum/")
public class RestControllerKolokvijum {

	
	@Autowired
	PripremaService service;
	
	@GetMapping("getPredstave")
	public ResponseEntity<?> getPredstave() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getPredstave());
	}
	
	@PostMapping("saveGlumac")
	public ResponseEntity<?> saveGlumac(GlumacDTO glumac) {
		if(glumac.getIme() == "" || glumac.getPrezime() == "" || glumac.getJmbg() == "") {
			throw new EmptyFieldsException("Nijedno polje ne sme biti prazno.");
		}
		Integer idNovogGlumca = service.saveGlumac(glumac);
		
		return ResponseEntity.ok("Uspesno sacuvano novi glumac, id glumca je: " + idNovogGlumca);
	}
	
	@GetMapping("izvestajIzvodjenja")
	public ResponseEntity<?> getReport(String zanr) throws JRException, IOException {
		if (!service.existZanr(zanr))
			throw new NotfoundException("Ne postoji u bazi uneti zanr. ", zanr);
        	byte[] izvestaj = service.kreirajIzvestaj(zanr);
        	if (izvestaj == null) { 
        		throw new NotfoundException("Nema nijedno izvodjenje za uneti zanr.", zanr);
        	}
        	HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType("application/pdf"));
	        headers.setContentDispositionFormData("attachment", "izvodjenjaZaZanr.pdf");
	        return ResponseEntity.ok()
	            .headers(headers)
	            .body(izvestaj);
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleNotFoundZException(RuntimeException e) {
		return ResponseEntity.badRequest().body("Greska: " + e.getMessage());
	}
}

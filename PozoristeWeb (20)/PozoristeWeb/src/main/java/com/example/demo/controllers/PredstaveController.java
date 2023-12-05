package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.PredstaveService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/predstave/")
public class PredstaveController {

	@Autowired
	PredstaveService service;
	
	@GetMapping("getZanrovi")
	public String getZanrovi(HttpServletRequest request) {
		request.getSession().removeAttribute("predstave");
		request.getSession().removeAttribute("odabraniZanr");
		request.getSession().setAttribute("zanrovi", service.getZanrovi());
		return "prikazPredstava";
	}
	
	@GetMapping("getPredstave")
	public String getPredstave(@RequestParam("idZanra")Integer id, HttpServletRequest request) {
		request.getSession().setAttribute("predstave", service.getPredstave(id));
		request.getSession().setAttribute("odabraniZanr", service.getZanr(id));
		return "prikazPredstava";
	}
	
	@GetMapping("getGlumci")
	public String getGlumci(@RequestParam("idP")Integer idPredstave, Model m) {
		m.addAttribute("glumis", service.getGlumi(idPredstave));
		m.addAttribute("brojUloga", service.getBrojUloga(idPredstave));
		return "prikazGlumaca";
	}
	
	@PostMapping("goBack")
	public String back() {
		return "prikazPredstava";
	}
}

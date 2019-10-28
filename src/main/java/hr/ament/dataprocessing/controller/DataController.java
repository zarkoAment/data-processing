package hr.ament.dataprocessing.controller;

import hr.ament.dataprocessing.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@GetMapping("/")
	public String getPersons(Model model) throws Exception {
		System.out.println(" PerSonz::::   " + dataService.getPersons());
		dataService.getPersons();
		return "index";
	}
	
	
}

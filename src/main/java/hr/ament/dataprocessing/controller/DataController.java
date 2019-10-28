package hr.ament.dataprocessing.controller;

import hr.ament.dataprocessing.domain.Person;
import hr.ament.dataprocessing.repository.PersonDao;
import hr.ament.dataprocessing.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.file.Paths;
import java.util.List;

@Controller
public class DataController {
	
	@Autowired
	private DataService dataService;

	@Autowired
	private PersonDao personDao;
	
	@GetMapping("/")
	public String getPersons(Model model) throws Exception {

		return "index";
	}

	@PostMapping("/csv")
	public String convertCsv (Model model) throws Exception {
		List<Person> persons = dataService.getPersons();
		System.out.println("<<<<<<<<<<<<============== Ispis podataka iz CSV-a u konzoli ==============>>>>>>>>>> ");

		persons.forEach(person -> System.out.println("Ime: " + person.getName() + " || Prezime: " + person.getSurname() + " || Datum rođenja: " + person.getDateOfBirth().toString()));
		personDao.saveAll(persons);

		model.addAttribute("persons", personDao.findAll());

		return "index";
	}
}

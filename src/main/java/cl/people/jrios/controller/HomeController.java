package cl.people.jrios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String welcome() {
		String links = "https://entry23people.rj.r.appspot.com/students or https://entry23people.rj.r.appspot.com/courses";
		return links;
	}
}

package cl.people.jrios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.people.jrios.model.entity.Student;
import cl.people.jrios.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService service;

	@GetMapping
	public List<Student> toList() {
		return service.toList();
	}

	@GetMapping("/{id}")
	public Student toListForId(@PathVariable("id") Integer id) {
		return service.readForId(id);
	}

	@PostMapping
	public Student register(@RequestBody Student student) {
		return service.register(student);
	}

	@PutMapping
	public Student modify(@RequestBody Student student) {
		return service.modify(student);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable("id") Integer id) {
		service.remove(id);
	}

}

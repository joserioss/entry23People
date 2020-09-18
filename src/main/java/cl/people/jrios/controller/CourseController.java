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

import cl.people.jrios.model.entity.Course;
import cl.people.jrios.service.ICourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private ICourseService service;

	@GetMapping
	public List<Course> toList() {
		return service.toList();
	}

	@GetMapping("/{id}")
	public Course toListForId(@PathVariable("id") Integer id) {
		return service.readForId(id);
	}

	@PostMapping
	public Course register(@RequestBody Course course) {
		return service.register(course);
	}

	@PutMapping
	public Course modify(@RequestBody Course course) {
		return service.modify(course);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable("id") Integer id) {
		service.remove(id);
	}

}

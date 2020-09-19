package cl.people.jrios.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.people.jrios.exception.ModelNotFoundException;
import cl.people.jrios.model.entity.Course;
import cl.people.jrios.service.ICourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private ICourseService service;

	@GetMapping
	public ResponseEntity<Page<Course>> toList(Pageable pageable) {
		Page<Course> page = service.toList(pageable);
		return new ResponseEntity<Page<Course>>(page, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Course>> toListAll() {
		List<Course> list = service.toListAll();
		return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> toListForId(@PathVariable("id") Integer id) {
		Course cour = service.readForId(id);
		// if it detects that the id does not exist, send exception
		if (cour.getIdCourse() == null) {
			throw new ModelNotFoundException("ID COURSE NOT FOUND " + id);
		}
		return new ResponseEntity<Course>(cour, HttpStatus.CREATED);
	}

	@PostMapping
	public ResponseEntity<Object> register(@Valid @RequestBody Course course) {
		Course cour = service.register(course);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(course.getIdCourse()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Course> modify(@Valid @RequestBody Course course) {
		Course cour = service.modify(course);
		return new ResponseEntity<Course>(cour, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> remove(@PathVariable("id") Integer id) {
		Course cour = service.readForId(id);
		if (cour.getIdCourse() == null) {
			throw new ModelNotFoundException("ID COURSE NOT FOUND " + id);
		}
		service.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}

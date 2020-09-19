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
import cl.people.jrios.model.entity.Student;
import cl.people.jrios.service.ICourseService;
import cl.people.jrios.service.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private IStudentService service;
	
	@Autowired
	private ICourseService serviceCourse;

	@GetMapping
	public ResponseEntity<Page<Student>> toList(Pageable pageable) {
		Page<Student> page = service.toList(pageable);
		return new ResponseEntity<Page<Student>>(page, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> toListAll() {
		List<Student> list = service.toListAll();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> toListForId(@PathVariable("id") Integer id) {
		Student stu = service.readForId(id);
		// if it detects that the id does not exist, send exception
		if(stu.getIdStudent() == null) {
			throw new ModelNotFoundException("ID STUDENT NOT FOUND " + id);
		}
		return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
	}

	@PostMapping
	public ResponseEntity<Object> register(@Valid @RequestBody Student student) {
		boolean codeFound = serviceCourse.findByCode(student.getCourse()); 
		if(codeFound == false) {
			throw new ModelNotFoundException("CODE COURSE NOT FOUND ");
		}
		Student stu = service.register(student);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getIdStudent()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Student> modify(@Valid @RequestBody Student student) {
		boolean codeFound = serviceCourse.findByCode(student.getCourse()); 
		if(codeFound == false) {
			throw new ModelNotFoundException("CODE COURSE NOT FOUND ");
		}
		Student stu = service.modify(student);
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> remove(@PathVariable("id") Integer id) {
		Student stu = service.readForId(id);
		if(stu.getIdStudent() == null) {
			throw new ModelNotFoundException("ID STUDENT NOT FOUND " + id);
		}
		service.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}

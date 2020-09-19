package cl.people.jrios.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.people.jrios.model.entity.Student;

public interface IStudentService {
	
	//Service to register student
	Student register(Student student);
	//Service to modify student
	Student modify(Student student);
	//Service to List students in a paginated way
	Page<Student> toList(Pageable pegeable);
	//Service to List students All
	List<Student> toListAll();
	//Service to search for id
	Student readForId(Integer id);
	//Service to remove student
	boolean remove(Integer id);
}

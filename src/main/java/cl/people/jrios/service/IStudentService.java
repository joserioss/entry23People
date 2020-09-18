package cl.people.jrios.service;

import java.util.List;

import cl.people.jrios.model.entity.Student;

public interface IStudentService {
	
	//Service to register student
	Student register(Student student);
	//Service to modify student
	Student modify(Student student);
	//Service to List students in a paginated way
	List<Student> toList();
	//Service to List students All
	List<Student> toListAll();
	//Service to search for id
	Student readForId(Integer id);
	//Service to remove student
	boolean remove(Integer id);
}

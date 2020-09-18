package cl.people.jrios.service;

import java.util.List;

import cl.people.jrios.model.entity.Course;

public interface ICourseService {
	
	//Service to register course
	Course register(Course course);
	//Service to modify course
	Course modify(Course course);
	//Service to List courses in a paginated way
	List<Course> toList();
	//Service to List courses All
	List<Course> toListAll();
	//Service to search for id
	Course readForId(Integer id);
	//Service to remove course
	boolean remove(Integer id);
}

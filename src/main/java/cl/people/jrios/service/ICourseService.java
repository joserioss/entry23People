package cl.people.jrios.service;

import cl.people.jrios.model.entity.Course;

public interface ICourseService extends ICRUD<Course>{
	boolean findByCode(String codeCourse);
}

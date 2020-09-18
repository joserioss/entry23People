package cl.people.jrios.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.people.jrios.model.entity.Course;

public interface ICourseRepo extends JpaRepository<Course, Integer>{

}

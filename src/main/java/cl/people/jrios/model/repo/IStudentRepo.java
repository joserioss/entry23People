package cl.people.jrios.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.people.jrios.model.entity.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer>{

}

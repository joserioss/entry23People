package cl.people.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.people.jrios.model.entity.Course;
import cl.people.jrios.model.repo.ICourseRepo;
import cl.people.jrios.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICourseRepo repo;

	@Override
	public Course register(Course course) {
		return repo.save(course);
	}

	@Override
	public Course modify(Course course) {
		return repo.save(course);
	}

	@Override
	public Page<Course> toList(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<Course> toListAll() {
		return repo.findAll();
	}

	/**
	 * Because findById returns an optional, an optional is performed which: 
	 * - if id exists, returns the indicated course, 
	 * - and if id does not exist, it retrieves an empty instance
	 */
	@Override
	public Course readForId(Integer id) {
		Optional<Course> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Course();
	}

	@Override
	public boolean remove(Integer id) {
		repo.deleteById(id);
		return true;
	}

	/**
	 * Because findByCode returns an optional, an optional is performed which: 
	 * - if code of Course exists, returns true, 
	 * - and if code of Course does not exist, it retrieves a false.
	 */
	@Override
	public boolean findByCode(String codeCourse) {
		Optional<Course> op = repo.findByCode(codeCourse);
		return op.isPresent();
	}

}

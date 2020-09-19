package cl.people.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.people.jrios.model.entity.Student;
import cl.people.jrios.model.repo.IStudentRepo;
import cl.people.jrios.service.IStudentService;
import cl.people.jrios.utility.ValidateRut;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo repo;

	@Override
	public Student register(Student student) {
		return repo.save(student);
	}

	@Override
	public Student modify(Student student) {
		return repo.save(student);
	}

	@Override
	public Page<Student> toList(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<Student> toListAll() {
		return repo.findAll();
	}

//	Because findById returns an optional, an optional is performed which:
//	- if id exists, returns the indicated student, 
//	- and if id does not exist, it retrieves an empty instance
	@Override
	public Student readForId(Integer id) {
		Optional<Student> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Student();
	}

	@Override
	public boolean remove(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public boolean checkRut(String rut) {
		return ValidateRut.CheckDigitRut(rut);
	}

}

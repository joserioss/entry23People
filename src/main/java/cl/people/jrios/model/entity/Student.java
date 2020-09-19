package cl.people.jrios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStudent;

	// RUT is a String, without check digit. Internally I will generate the
	// verification digit
	@Size(min = 8, max = 9, message = "rut: whitout check digit")
	@Column(name = "rut", nullable = false, length = 9)
	private String rut;

	@Size(min = 3, message = "Name: minimum three characters")
	@Column(name = "name", nullable = false, length = 40)
	private String name;

	@Size(min = 3, message = "LastName: minimum three characters")
	@Column(name = "lastName", nullable = false, length = 40)
	private String lastName;

	// over eighteen
	@Min(18)
	private Integer age;

	// age will be considered momentarily as string -> Class Course
	@Size(max = 4, message = "Code course: max four characters")
	@Column(name = "codeCourse", nullable = false, length = 40)
	private String course;

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourse() {
		return course.toUpperCase();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setCourse(String course) {
		this.course = course.toUpperCase();
	}

}

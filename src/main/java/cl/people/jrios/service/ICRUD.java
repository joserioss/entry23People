package cl.people.jrios.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


//Service generic CRUD
public interface ICRUD<T> {
	//Service register
	T register(T obj);
	//Service to modify 
	T modify(T obj);
	//Service paginated
	Page<T> toList(Pageable pageable);
	//Service to List All
	List<T> toListAll();
	//Service to search for id
	T readForId(Integer id);
	//Service to remove
	boolean remove(Integer id);
}

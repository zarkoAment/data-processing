package hr.ament.dataprocessing.repository;

import hr.ament.dataprocessing.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {
	
}

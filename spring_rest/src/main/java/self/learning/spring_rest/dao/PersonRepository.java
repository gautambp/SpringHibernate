package self.learning.spring_rest.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import self.learning.spring_rest.domain.Person;

@RepositoryRestResource(collectionResourceRel="people", path="people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	List<Person> findByName(@Param("name") String name);
}

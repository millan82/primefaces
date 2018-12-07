package es.jsfprime.primefaces.repository;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import es.jsfprime.primefaces.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {


  // public Page<Person> findAll(Pageable pageRequest);

  public Optional<Person> findByName(String name);
}

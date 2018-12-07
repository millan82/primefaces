package es.jsfprime.primefaces.repository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import es.jsfprime.primefaces.model.Person;

@Component
public class PersonBO {

  @Autowired
  private PersonRepository repository;

  public Person save(Person p) {
    return repository.save(p);
  }

  public Optional<Person> findByName(String name) {
    return repository.findByName(name);
  }

  public Page<Person> findAll(Pageable pageRequest) {
    return repository.findAll(pageRequest);
  }

  public Optional<Person> findById(Long id) {
    return repository.findById(id);
  }

  public void delete(Person person) {
    repository.delete(person);
  }

}

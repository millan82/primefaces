package es.jsfprime.primefaces.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import es.jsfprime.primefaces.model.Person;
import es.jsfprime.primefaces.repository.PersonBO;

@Service
public class PersonService {

  @Autowired
  private PersonBO personBO;

  public void savePerson(Person person) {
    personBO.save(person);
  }

  public Person getPerson(String name) {
    Person result = null;
    Optional<Person> person = personBO.findByName(name);
    if (person.isPresent()) {
      result = person.get();
    }
    return result;
  }

  public Page<Person> getAllPerson(PageRequest request) {
    return personBO.findAll(request);
  }

  public Person getPersonId(Long id) {
    Person result = null;
    Optional<Person> person = personBO.findById(id);
    if (person.isPresent()) {
      result = person.get();
    }
    return result;
  }

  public void delete(Person person) {
    personBO.delete(person);
  }
}

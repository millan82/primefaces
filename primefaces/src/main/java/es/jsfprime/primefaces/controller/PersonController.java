package es.jsfprime.primefaces.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import es.jsfprime.primefaces.model.Person;
import es.jsfprime.primefaces.service.PersonService;

@ManagedBean("people")
@ViewScoped
public class PersonController {

  @Autowired
  private PersonService service;

  private Person person;
  private List<Person> personList;
  @Autowired
  private PersonLazyList persons;

  @PostConstruct
  private void init() {
    person = new Person();
    personList = new ArrayList<>();
  }

  public PersonService getService() {
    return service;
  }

  public void setService(PersonService service) {
    this.service = service;
  }

  public List<Person> getPersonList() {
    return personList;
  }

  public void setPersonList(List<Person> personList) {
    this.personList = personList;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }


  public String mostrar() {
    return "Soy " + person.getName() + ", tengo " + person.getAge() + " años!";
  }

  public void savePerson() {
    service.savePerson(person);
    person = new Person();
  }


  public PersonLazyList getPersons() {
    return persons;
  }

  public void setPersons(PersonLazyList persons) {
    this.persons = persons;
  }

  public void delete() {
    if (!personList.isEmpty()) {
      personList.forEach(x -> {
        service.delete(x);
      });
    }
  }



}

package es.jsfprime.primefaces.controller;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;
import es.jsfprime.primefaces.model.Person;
import es.jsfprime.primefaces.service.PersonService;

@Component
public class PersonLazyList extends LazyDataModel<Person> {
  private static final long serialVersionUID = 1L;
  /**
   * Servicio.
   */
  @Autowired
  private PersonService service;

  /**
   * @param arg0 first.
   * @param arg1 pageSize.
   * @param arg2 sortField.
   * @param arg3 sortOrder.
   * @param arg4 filters.
   */
  @Override
  public List<Person> load(int first, int pageSize, String sortField, SortOrder sortOrder,
      Map<String, Object> filters) {

    Sort sort = Sort.by(Order.asc(sortField));
    if (SortOrder.DESCENDING.equals(sortOrder)) {
      sort = Sort.by(Order.desc(sortField));
    }
    Page<Person> resultadoPaginado =
        service.getAllPerson(PageRequest.of(first / pageSize, pageSize, sort));
    List<Person> regreso = resultadoPaginado.getContent();
    this.setRowCount((int) resultadoPaginado.getTotalElements());
    this.setPageSize(pageSize);
    return regreso;
  }



  /*
   * Los siguientes dos metodos son muy importantes porque son los necesarios para poder utilizar la
   * seleccion de elementos en la tabla.
   */
  /**
   * Retorna el identificador del proveedor proporcionado.
   * 
   * @param proveedor Proveedor del que se quiere saber su identificador.
   */
  @Override
  public Object getRowKey(Person person) {
    return person.getId();
  }

  /**
   * Retorna la informacion del proveedor buscado.
   * 
   * @param idProveedor Identificador del proveedor en formato de texto.
   */
  @Override
  public Person getRowData(String idProveedor) {
    return service.getPersonId(Long.valueOf(idProveedor));
  }

}

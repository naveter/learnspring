package ru.job4j.server;

import ru.job4j.client.PersonService;
import ru.job4j.server.domain.Person;
import ru.job4j.server.repository.PersonRepository;
import ru.job4j.server.service.AppContext;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.job4j.shared.PersonResp;
import java.util.ArrayList;
import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PersonServiceImpl extends RemoteServiceServlet
        implements PersonService {

    private final PersonRepository persons = AppContext.getBean(PersonRepository.class);

    @Override
    public List<PersonResp> list() {
        List<PersonResp> people = new ArrayList<>();
        for (Person person : this.persons.findAll()) {
            people.add(new PersonResp(person.getId(), person.getUsername(), person.getBirthday()));
        }
        return people;
    }

    @Override
    public PersonResp save(PersonResp data) {
        Person person = new Person();
        person.setId(data.getId());
        person.setUsername(data.getUsername());
        person.setBirthday(data.getBirthday());
        this.persons.save(person);
        data.setId(person.getId());
        return data;
    }

    @Override
    public boolean delete(PersonResp person) {
        this.persons.delete(person.getId());
        return true;
    }
}

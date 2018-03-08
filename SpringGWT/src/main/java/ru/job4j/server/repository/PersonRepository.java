package ru.job4j.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.server.domain.Person;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}

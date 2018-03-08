package ru.job4j.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.job4j.shared.PersonResp;

import java.util.List;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("person")
public interface PersonService extends RemoteService {
  List<PersonResp> list();

  PersonResp save(PersonResp person);

  boolean delete(PersonResp person);
}

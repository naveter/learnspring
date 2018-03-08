package ru.job4j.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.job4j.shared.PersonResp;

import java.util.List;

public interface PersonServiceAsync {
    void list(AsyncCallback<List<PersonResp>> callback);

    void save(PersonResp person, AsyncCallback<PersonResp> callback);

    void delete(PersonResp person, AsyncCallback<Boolean> callback);
}

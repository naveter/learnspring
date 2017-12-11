package learnspring.springcmd.dbitems;

import java.util.List;

public interface UserDAO {
    public User save(User p);

    public List<User> list();

    public User getById(int id);
}

package learnspring.springcmd.dbitrems;

import java.util.List;

public interface UserDAO {
    public void save(User p);

    public List<User> list();

    public User getById(int id);
}

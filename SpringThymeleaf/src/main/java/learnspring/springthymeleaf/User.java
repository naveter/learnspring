package learnspring.springthymeleaf;

import org.springframework.stereotype.Component;


@Component
public class User {

    private String name = "taras";
    private String password ="passtaras";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
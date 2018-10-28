package learnspring.springmybatis;

import java.util.Date;

public class User extends DBEntity {

    private String firstname;
    private String lastname;
    private Date created;
    private String login;
    private String password;
    private Date lastlogin;
    private Long rang_id;
    private Rang rang;

    public Long getRang_id() {
        return rang_id;
    }

    public void setRang_id(Long rang_id) {
        this.rang_id = rang_id;
    }

    public Rang getRang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }

    public Long getRang_ID() {
        return rang_id;
    }

    public void setRang_ID(Long rangID) {
        this.rang_id = rangID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return super.toString() +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + '\'';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

}

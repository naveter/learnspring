package learnspring.springmybatis;

public class Rang {
    private Long id;
    private String rang_name;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRang_name() {
        return rang_name;
    }

    public void setRang_name(String rang_name) {
        this.rang_name = rang_name;
    }


}

package learnspring.myblog.beans;

public class SimpleBean1 {
    public String name = "SimpleBean1 ";
    private String prop;

    public String getName(){
        return name + prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getProp() {
        return prop;
    }
}

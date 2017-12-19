package learnspring.myblog.beans;

public class SimpleBean2 {
    public String name = "SimpleBean2";
    public static SimpleBean2 instance = new SimpleBean2();

    public static SimpleBean2 getInstance(){
        return instance;
    }

    public String getName(){
        return name;
    }

}

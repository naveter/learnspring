package learnspring.myblog.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("beanX")
@Scope("prototype")
public class BeanX implements iBean {

    @Override
    public String getName(){
        return "BeanX";
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct BeanX");
    }
}

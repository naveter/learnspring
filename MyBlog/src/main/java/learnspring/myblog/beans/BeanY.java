package learnspring.myblog.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("beanY")
@Scope("prototype")
public class BeanY implements iBean {

    @Override
    public String getName(){
        return "BeanY";
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct BeanY");
    }


}

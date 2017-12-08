package learnspring.springcmd;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AppAspect {


    @Before("execution(* printMessage())")
    public void doPrintMessage() {
        System.out.println("AppAspect.doPrintMessage() is called");
    }


}
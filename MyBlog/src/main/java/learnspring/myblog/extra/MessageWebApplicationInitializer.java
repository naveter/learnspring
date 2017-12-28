package learnspring.myblog.extra;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MessageWebApplicationInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfiguration.class, WebSecurityConfig.class };
    }

    @Override
    protected  Class<?>[] getServletConfigClasses(){
        return new Class[] { AppConfiguration.class };
    }

    protected String[] getServletMappings(){
        return new String[] { "/" };
    }
}
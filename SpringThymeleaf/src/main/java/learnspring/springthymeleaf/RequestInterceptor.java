package learnspring.springthymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        System.out.println("[preHandle][" + request + "]" + "[" + request.getMethod()
                + "]" + request.getRequestURI());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("[postHandle][" + request + "]");
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response,Object handler, Exception ex)
            throws Exception {

        System.out.println("[afterCompletion][" + request + "][exception: " + ex + "]");
    }
}

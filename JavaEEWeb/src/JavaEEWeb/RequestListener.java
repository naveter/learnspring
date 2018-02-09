package JavaEEWeb;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("request being sent to "
                + event.getServletRequest().getRemoteAddr());
    }

    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("now initializing request"
                + event.getServletRequest().getRemoteAddr());

    }

}

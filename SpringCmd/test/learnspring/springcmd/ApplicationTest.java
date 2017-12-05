package learnspring.springcmd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
public class ApplicationTest {

    @Autowired
    private MessageService service;

    @Test
    public void contextLoads() {
        System.out.println(service.getMessage());
        assertEquals("Hello World!", service.getMessage());
    }

}


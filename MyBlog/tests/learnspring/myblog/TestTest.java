package learnspring.myblog;

import learnspring.myblog.extra.AppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfiguration.class)
public class TestTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void saveTest(){
        assertEquals("After save category", 1, 1);
    }

}

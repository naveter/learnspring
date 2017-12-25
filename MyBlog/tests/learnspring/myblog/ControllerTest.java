package learnspring.myblog;

import learnspring.myblog.extra.AppConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfiguration.class)
public class ControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void testCreateSignupFormInvalidUser() throws Exception {
        MockHttpServletRequestBuilder builder;

        builder = MockMvcRequestBuilders.get("/");
        this.mockMvc.perform(builder).andExpect(status().isOk());

        builder = MockMvcRequestBuilders.get("/post/1");
        this.mockMvc.perform(builder).andExpect(status().isOk());

        builder = MockMvcRequestBuilders.get("/post/add/form");
        this.mockMvc.perform(builder).andExpect(status().isOk());

//        builder = MockMvcRequestBuilders.post("/post/add");
//        this.mockMvc.perform(builder).andExpect(status().isOk());

        builder = MockMvcRequestBuilders.get("/category/1");
        this.mockMvc.perform(builder).andExpect(status().isOk());

        builder = MockMvcRequestBuilders.get("/user/1");
        this.mockMvc.perform(builder).andExpect(status().isOk());

        builder = MockMvcRequestBuilders.get("/exception");
        this.mockMvc.perform(builder).andExpect(status().isOk());


    }
}

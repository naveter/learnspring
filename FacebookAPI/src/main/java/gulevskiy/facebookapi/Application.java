package gulevskiy.facebookapi;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("I am started....");

            String[] beanNames = ctx.getBeanDefinitionNames();

        };
    }

    @Bean
    public CommandLineRunner facebookRunner(ApplicationContext ctx) {
        return args -> {

            Facebook facebook = new Facebook();
            facebook.main();

        };
    }

}

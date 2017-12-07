package learnspring.springcmd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();


        String title = "not found";
        org.springframework.core.io.Resource template = context.getResource("https://mail.ru");

        try {
            title = new BufferedReader(new InputStreamReader(template.getInputStream()))
                    .lines()
                    .filter(e -> e.matches(".*<title>.+</title>.*"))
                    .map(e -> e.replaceAll(".+<title>|</title>.+", ""))
                    .collect(Collectors.joining("<br>"));

//            title = title.substring(0, 10);

            System.out.println(title);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

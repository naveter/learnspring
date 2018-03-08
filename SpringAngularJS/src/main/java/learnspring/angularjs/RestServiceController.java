package learnspring.angularjs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestServiceController {

    @GetMapping("/first")
    public List<First> index(@RequestParam(value="p", required=false, defaultValue="0") int p) {
        List<First> list = new ArrayList<>();

        list.add(new First("Petrov", "Ivan"));
        list.add(new First("Kozlov", "Sidor"));
        list.add(new First("Markov", "Tar"));
        list.add(new First("Sabatov", "Kurkum"));

        return list;
    }

    @GetMapping("/second")
    public List<Second> categories() {
        List<Second> list = new ArrayList<>();

        list.add(new Second("Karaseiv", "Parata"));
        list.add(new Second("Pontaine", "Sumute"));
        list.add(new Second("Serolovada", "Koleta"));
        list.add(new Second("Composo", "Stepan"));

        return list;
    }



}

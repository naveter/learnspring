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

    @GetMapping("/index")
    public List<First> index(@RequestParam(value="p", required=false, defaultValue="0") int p) {
        List<First> list = new ArrayList<>();

        list.add(new First("Al", "Patifon"));
        list.add(new First("Semenov", "Stas"));
        list.add(new First("Garelian", "Tarogat"));
        list.add(new First("Darionov", "Kurkumatium"));
        list.add(new First("Lonelies", "Coco"));
        list.add(new First("Molotovich", "Hans"));

        return list;
    }

    @GetMapping("/first")
    public List<First> first(@RequestParam(value="p", required=false, defaultValue="0") int p) {
        List<First> list = new ArrayList<>();

        list.add(new First("Petrov", "Ivan"));
        list.add(new First("Kozlov", "Sidor"));
        list.add(new First("Markov", "Tar"));
        list.add(new First("Sabatov", "Kurkum"));

        return list;
    }

    @GetMapping("/second")
    public List<Second> second() {
        List<Second> list = new ArrayList<>();

        list.add(new Second("Karaseiv", "Parata"));
        list.add(new Second("Pontaine", "Sumute"));
        list.add(new Second("Serolovada", "Koleta"));
        list.add(new Second("Composo", "Stepan"));

        return list;
    }



}

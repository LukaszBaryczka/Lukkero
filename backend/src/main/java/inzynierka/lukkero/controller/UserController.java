package inzynierka.lukkero.controller;

import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @RequestMapping("/save")
    public String process() {
        repository.save(new Customer("Łukasz", "Baryczka", "l.baryczka@gmail.com", null ));
        repository.save(new Customer("Łukasz2", "Baryczka2", "l.baryczka@gmail.com2", null ));
        repository.save(new Customer("Łukasz3", "Baryczka3", "l.baryczka@gmail.com3", null ));
        repository.save(new Customer("Łukasz4", "Baryczka4", "l.baryczka@gmail.com4", null ));
        repository.save(new Customer("Łukasz5", "Baryczka5", "l.baryczka@gmail.com5", null ));

        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result = "<html>";
        for(Customer user : repository.findAll()) {
            result += "<div>" + user.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id")BigInteger id) {
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/finduserbysurname")
    public String fetchDataBySurname(@RequestParam("surname") String surname) {
        String result = "<html>";
        for(Customer user : repository.findUserBySurname(surname)) {
            result += "<div>" + user.toString() + "</div>";
        }

        return result + "</html>";
    }
}

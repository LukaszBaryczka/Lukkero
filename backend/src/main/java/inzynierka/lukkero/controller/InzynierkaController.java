package inzynierka.lukkero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import inzynierka.lukkero.model.Customer;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/inz/lukas")
public class InzynierkaController {

    List<Customer> users;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String get() {
        return "Hello world, method GET";
    }

    @RequestMapping(value = "/home", params = {"param"}, method = RequestMethod.GET)
    public @ResponseBody String getParam(@RequestParam(value = "param") String param) {
        return "Hello world, method  and param = " + param;
    }

    @RequestMapping(value = "/user", params = {"id"}, method = RequestMethod.GET)
    public @ResponseBody
    Customer getUser(@RequestParam(value = "id") int id) {

        users = new ArrayList<>();

        Customer user = new Customer();
        user.setEmail("l.baryczka@gmail.com");
        user.setName("Lukasz");
        user.setSurname("Baryczka");

        users.add(user);

        Customer user2 = new Customer();
        user2.setEmail("l.baryczka@gmail.com2");
        user2.setName("Lukasz2");
        user2.setSurname("Baryczka2");


        users.add(user2);

        for(Customer u : users) {
            if(u.getId().equals(BigInteger.valueOf(id))) {
                return u;
            }
        }

        return new Customer();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Customer> getUsers() {

        users = new ArrayList<>();

        Customer user = new Customer();
        user.setEmail("l.baryczka@gmail.com");
        user.setName("Lukasz");
        user.setSurname("Baryczka");

        users.add(user);

        Customer user2 = new Customer();
        user2.setEmail("l.baryczka@gmail.com2");
        user2.setName("Lukasz2");
        user2.setSurname("Baryczka2");

        users.add(user);
        users.add(user2);

        return users;
    }

    @RequestMapping(value = "/create_user", method = RequestMethod.POST)
    public @ResponseBody String postUser(HttpServletRequest request,
                                             @RequestParam(value="name", required=false) String name,
                                             @RequestParam(value="suname", required=false) String surname,
                                             @RequestParam(value="email", required=false) String email){
        String response;
        try{
            Customer u = new Customer();
            u.setEmail(email);
            u.setName(name);
            u.setSurname(surname);
            response = "Success";
        }catch(Exception ex){
            response = "Fail";
        }
        return response;
    }
}
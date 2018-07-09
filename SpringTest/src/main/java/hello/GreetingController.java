package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value = "name", defaultValue = "unknown") String name) {

        List<User> users = userRepository.findByName(name);

        User user;
        if (users.isEmpty()) {
            user = new User(name, 0);
        } else {
            user = users.get(0);
        }

        user.incrementTimesGreeted();

        userRepository.save(user);

        return new Greeting(user.getTimesGreeted(), name).toHTML();
    }
}

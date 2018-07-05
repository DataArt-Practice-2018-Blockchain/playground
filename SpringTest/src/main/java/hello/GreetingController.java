package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s";

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "there") String name) {

        List<User> users = userRepository.findByName(name);

        User user;
        if (users.isEmpty()) {
            user = new User(name, 0);
        } else {
            user = users.get(0);
        }

        user.setTimesGreeted(user.getTimesGreeted() + 1);

        userRepository.save(user);

        return new Greeting(user.getTimesGreeted(), String.format(template, name));
    }
}

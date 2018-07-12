package sendmsg.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@Configuration
public class AppConfig {
    @Bean
    public Mongo mongo() throws UnknownHostException {
        Mongo mongo = new MongoClient("127.0.0.1", 27017);
        return mongo;
    }
}

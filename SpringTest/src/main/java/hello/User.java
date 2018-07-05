package hello;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    String id;
    String name;
    Integer timesGreeted;

    public User(String name, Integer timesGreeted) {
        this.name = name;
        this.timesGreeted = timesGreeted;
    }

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimesGreeted() {
        return timesGreeted;
    }

    public void setTimesGreeted(Integer timesGreeted) {
        this.timesGreeted = timesGreeted;
    }
}

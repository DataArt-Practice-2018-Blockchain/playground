package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByName(@Param("name") String name);

}

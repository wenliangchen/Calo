package run.cola.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import run.cola.app.po.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);
}

package pl.edu.wszib.homebudget.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.homebudget.domain.User;

@Repository
public interface UserDao extends CrudRepository <User, Long> {

}

package global.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import global.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

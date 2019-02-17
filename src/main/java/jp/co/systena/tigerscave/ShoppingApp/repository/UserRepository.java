package jp.co.systena.tigerscave.ShoppingApp.repository;

import jp.co.systena.tigerscave.ShoppingApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}

package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

//    List<User> findAllByRole(String role);

    @Query(value = "select * from users u join user_role ur on u.id = ur.user_id join roles r on ur.roles_id = r.id where r.role in ('ROLE_ADMIN')", nativeQuery = true)
    public List<User> findAllAdmins();
}

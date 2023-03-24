package springBoot_3_1_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot_3_1_2.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}

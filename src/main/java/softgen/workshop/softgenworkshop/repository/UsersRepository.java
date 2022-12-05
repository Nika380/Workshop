package softgen.workshop.softgenworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softgen.workshop.softgenworkshop.entity.Users;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findByActive(boolean active);
}

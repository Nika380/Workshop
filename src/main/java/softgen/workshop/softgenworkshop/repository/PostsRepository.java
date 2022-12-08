package softgen.workshop.softgenworkshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softgen.workshop.softgenworkshop.entity.Posts;
import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {

    List<Posts> findByUserId(int id);
    List<Posts> findByDeleted(boolean deleted);
}

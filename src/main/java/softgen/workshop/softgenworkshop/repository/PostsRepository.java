package softgen.workshop.softgenworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softgen.workshop.softgenworkshop.entity.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
}

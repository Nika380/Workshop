package softgen.workshop.softgenworkshop.service.posts;

import softgen.workshop.softgenworkshop.entity.Posts;

import java.util.List;

public interface PostsInterface {
    List<Posts> allPosts();

    Posts userPost(int id);

    Posts addPost(Posts posts);

    Posts getPostById(int id);

    Posts updatePost(int id, Posts posts);

    List<Posts> getByUserId(int id);


    void deletePost(int id);
}

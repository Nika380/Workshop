package softgen.workshop.softgenworkshop.service.posts;

import org.springframework.stereotype.Service;
import softgen.workshop.softgenworkshop.entity.Posts;
import softgen.workshop.softgenworkshop.exceptions.NotFoundException;
import softgen.workshop.softgenworkshop.repository.PostsRepository;

import java.util.List;

@Service
public class PostsService implements PostsInterface{

    private final PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public List<Posts> allPosts() {
        return postsRepository.findByDeleted(false);
    }

    @Override
    public Posts userPost(int id) {
        return (Posts) postsRepository.findByUserId(id);
    }

    @Override
    public Posts addPost(Posts posts) {
        postsRepository.save(posts);
        return posts;
    }

    @Override
    public Posts getPostById(int id) {
        var byId =  postsRepository.findById(id);
        if(byId.isEmpty()) {
            throw new NotFoundException("Not Found Post with this Id");
        }
        return byId.get();
    }

    @Override
    public Posts updatePost(int id, Posts posts) {
        var postToUpdate = getPostById(id);
        postToUpdate.setBody(posts.getBody());
        postToUpdate.setTitle(posts.getTitle());
        postsRepository.save(postToUpdate);
        return postToUpdate;
    }



    @Override
    public void deletePost(int id) {
        var toDelete = getPostById(id);
        toDelete.setDeleted(true);
        postsRepository.save(toDelete);
    }

    @Override
    public List<Posts> getByUserId(int id) {
        return postsRepository.findByUserId(id);
    }
}

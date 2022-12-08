package softgen.workshop.softgenworkshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softgen.workshop.softgenworkshop.entity.Posts;
import softgen.workshop.softgenworkshop.exceptions.NotFoundException;
import softgen.workshop.softgenworkshop.service.posts.PostsService;
import softgen.workshop.softgenworkshop.service.users.UserService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;
    private final UserService userService;

    public PostsController(PostsService postsService, UserService userService) {
        this.postsService = postsService;
        this.userService = userService;
    }

    @GetMapping("")
    public List<Posts> getAll() {
        return postsService.allPosts();
    }
    @PostMapping("")
    public Posts addPost(@RequestBody Posts posts) {
        int id = posts.getUserId();
        if(!userService.getById(id).isActive()) {
            throw new NotFoundException("User Does not exist");
        }
        return postsService.addPost(posts);
    }

    @PutMapping("/{id}")
    public Posts updatePost(@RequestBody Posts posts, @PathVariable int id) {
        return postsService.updatePost(id, posts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Posts> deletePost(@PathVariable int id) {
        postsService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public Posts getPostById(@PathVariable int id) {
        return postsService.getPostById(id);
    }

}

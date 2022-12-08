package softgen.workshop.softgenworkshop.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softgen.workshop.softgenworkshop.entity.Posts;
import softgen.workshop.softgenworkshop.entity.Users;
import softgen.workshop.softgenworkshop.service.posts.PostsService;
import softgen.workshop.softgenworkshop.service.users.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final PostsService postsService;
    private final UserService userService;

    public UsersController(PostsService postsService, UserService userService) {
        this.postsService = postsService;
        this.userService = userService;
    }

    @GetMapping("")
    public List<Users> getAll() {
        return userService.getAll();
    }

    @GetMapping ("/{id}")
    public Users getByid(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    public Users add(@RequestBody Users user) {
        return userService.add(user);
    }

    @PutMapping("/{id}")
    public Users update(@RequestBody Users user, @PathVariable int id) {
        return userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> delete(@PathVariable int id) {

        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public List<Posts> getUsersPosts(@PathVariable int id) {
        return postsService.getByUserId(id);
    }

}

package softgen.workshop.softgenworkshop.service.users;

import org.springframework.stereotype.Service;
import softgen.workshop.softgenworkshop.entity.Users;
import softgen.workshop.softgenworkshop.repository.PostsRepository;
import softgen.workshop.softgenworkshop.repository.UsersRepository;

import java.util.List;



@Service
public class UserService implements UserInterface{


    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    public UserService(PostsRepository postsRepository, UsersRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> getAll() {
        return usersRepository.findByActive(true);
    }

    @Override
    public Users add(Users user) {
        usersRepository.save(user);
        return user;
    }


    @Override
    public Users update(Users user, int id) {
        var userUpdated = getById(id);
        userUpdated.setEmail(user.getEmail());
        userUpdated.setPassword(user.getPassword());
        userUpdated.setUsername(user.getUsername());
        usersRepository.save(userUpdated);
        return userUpdated;
    }

    @Override
    public void delete(int id) {
        var userDeleted = getById(id);
        userDeleted.setActive(false);
        usersRepository.save(userDeleted);
    }

    @Override
    public Users getById(int id) {
        var byId = usersRepository.findById(id);
        if(byId.isEmpty()) {
            throw new RuntimeException("User Not Found");
        }
        return byId.get();
    }

}

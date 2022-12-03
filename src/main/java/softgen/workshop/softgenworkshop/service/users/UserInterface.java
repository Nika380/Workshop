package softgen.workshop.softgenworkshop.service.users;

import softgen.workshop.softgenworkshop.entity.Users;

import java.util.List;

public interface UserInterface {
    List<Users> getAll();

    Users add(Users user);

    Users update(Users user, int id);

    void delete(int id);

    Users getById(int id);
}

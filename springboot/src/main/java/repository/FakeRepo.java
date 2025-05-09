package repository;

import model.User;
import org.springframework.stereotype.Repository;
import repository.FakeRepoInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class FakeRepo implements FakeRepoInterface {
    private final Map<UUID, User> userDatabase = new HashMap<>();

    @Override
    public String insertUser(UUID id, String name, String surname) {
        userDatabase.put(id, new User(id, name, surname));
        return name;
    }

    @Override
    public String findUserById(UUID id) {
        User user = userDatabase.get(id);
        return user != null ? user.getName() : null;
    }

    @Override
    public String deleteUser(UUID id) {
        User user = userDatabase.remove(id);
        return user != null ? user.getName() : null;
    }
}
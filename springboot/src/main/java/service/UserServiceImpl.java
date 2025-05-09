package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FakeRepo;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final FakeRepo fakeRepo;

    @Autowired
    public UserServiceImpl(FakeRepo fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public String addUser(String name, String surname) {
        UUID id = UUID.randomUUID();
        fakeRepo.insertUser(id, name, surname);
        return name + " added";
    }

    @Override
    public String removeUser(UUID id) {
        String name = fakeRepo.deleteUser(id);
        return name + " removed";
    }

    @Override
    public String getUser(UUID id) {
        String name = fakeRepo.findUserById(id);
        return "hello " + name;
    }
}
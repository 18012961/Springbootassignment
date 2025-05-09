package service;

import java.util.UUID;

public interface UserService {
    String addUser(String name, String surname);
    String removeUser(UUID id);
    String getUser(UUID id);
}
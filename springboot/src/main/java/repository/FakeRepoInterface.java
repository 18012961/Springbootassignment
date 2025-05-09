package repository;

import java.util.UUID;

public interface FakeRepoInterface
{
    String insertUser(UUID id, String name, String surname);
    String findUserById(UUID id);
    String deleteUser(UUID id);
}

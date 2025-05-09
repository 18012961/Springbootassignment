package service;

import org.mockito.Mock;
import repository.FakeRepo;


    import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

    class UserServiceTests {
        @Mock
        private FakeRepo fakeRepo;

        @InjectMocks
        private UserServiceImpl userService;

        private final UUID testId = UUID.randomUUID();
        private final String testName = "John";
        private final String testSurname = "Doe";

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testAddUser() {
            when(fakeRepo.insertUser(any(UUID.class), eq(testName), eq(testSurname)))
                    .thenReturn(testName);

            String result = userService.addUser(testName, testSurname);
            assertEquals(testName + " added", result);
            verify(fakeRepo, times(1)).insertUser(any(UUID.class), eq(testName), eq(testSurname));
        }

        @Test
        void testRemoveUser() {
            when(fakeRepo.deleteUser(testId)).thenReturn(testName);

            String result = userService.removeUser(testId);
            assertEquals(testName + " removed", result);
            verify(fakeRepo, times(1)).deleteUser(testId);
        }

        @Test
        void testGetUser() {
            when(fakeRepo.findUserById(testId)).thenReturn(testName);

            String result = userService.getUser(testId);
            assertEquals("hello " + testName, result);
            verify(fakeRepo, times(1)).findUserById(testId);
        }
    }


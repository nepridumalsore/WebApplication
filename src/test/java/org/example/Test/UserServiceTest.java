package org.example.Test;

import org.example.Service.UserService;
import org.example.Entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public static class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {
        User user = new User(null, "test", "test");
        User createdUser = userService.addUser(user);
        assertNotNull(createdUser);
        assertEquals("test", createdUser.getName());
        assertEquals("test@example.com", createdUser.getEmail());
    }
    @Test
    public void testUpdateUser() {
        User user = new User(null, "test", "test");
        User createdUser = userService.addUser(user);
        createdUser.setEmail("updated@example.com");
        User updatedUser = userService.updateUser(createdUser);
        assertNotNull(createdUser);
        assertEquals("test", createdUser.getName());
        assertEquals("test@example.com", createdUser.getEmail());
    }

    @Test
    public void testDeleteUser() {
        User user = new User(null, "test", "test@example.com");
        User createdUser = userService.addUser(user);
        assertNotNull(createdUser);

        userService.deleteUserById(createdUser.getId());

        User deletedUser = userService.findUserById(createdUser.getId());
        assertNull(deletedUser);
    }

    @Test
    public void testFindUserByName() {
        User testUser = new User(null, "test", "test@example.com");
        userService.addUser(testUser);

        User user = UserService.getByUsername("test");

        assertEquals(testUser, user);
    }

    @Test
    public void testFindUserById() {
        User testUser = new User(null, "test", "test@example.com");
        userService.addUser(testUser);

        User user = userService.findUserById(testUser.getId());

        assertEquals(testUser, user);
    }

    @Test
    public void testFindAllUsers() {
        User testUser1 = new User(null, "test", "test@example.com");
        User testUser2 = new User(null, "test2", "test2@example.com");
        userService.addUser(testUser1);
        userService.addUser(testUser2);

        List<User> users = UserService.getAllUsers();

        assertEquals(2, users.size());
        assertTrue(users.contains(testUser1));
        assertTrue(users.contains(testUser2));
    }
}
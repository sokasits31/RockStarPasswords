package com.stevesokasits.persistence;

import com.stevesokasits.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setup() {
        dao = new UserDao();
    }

    @Test
    void getAllUsersSuccess() {

        List<User> users = dao.getAllUsers();
        assertEquals(5, users.size());

    }


    @Test
    void getEmailByIdSuccess() {
        User user = dao.getById(2);
        assertEquals("heather.sokasits@gmail.com", user.getEmailAddress());

    }

}
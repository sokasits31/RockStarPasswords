package com.stevesokasits.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class UserDaoTest {




    UserDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        com.stevesokasits.test.util.Database database = com.stevesokasits.test.util.Database.getInstance();
        //edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("usersTestData.sql");
        System.out.println("sQl ran.....................................................................................");
        dao = new UserDao();
    }

    @Test
    void getAllUsersSuccess() {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<User> users = dao.getAllUsers();
        assertEquals(5, users.size());

    }

    /**
     * Verify successful retrieval of a user
     */


    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(3);
        assertEquals("Lea.sokasits@gmail.com", retrievedUser.getEmailAddress());
        assertEquals("resource", retrievedUser.getUserRole());
        assertEquals("Lea",retrievedUser.getFirstName());
        assertEquals("Sokasits",retrievedUser.getLastName());
        assertEquals(false,retrievedUser.isPrimarySupport());
        assertEquals(true,retrievedUser.isSecondarySupport());
        assertEquals("college1",retrievedUser.getPassword());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("new@gmail.com","resource" ,"First", "Last",true,false,"college1", null);
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("new@gmail.com", insertedUser.getEmailAddress());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }


    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "Sok");
        assertEquals(1, users.size());
        assertEquals(4, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "c");
        assertEquals(3, users.size());
    }
}
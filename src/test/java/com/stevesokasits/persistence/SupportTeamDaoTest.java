package com.stevesokasits.persistence;

import com.stevesokasits.entity.SupportTeam;
import com.stevesokasits.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SupportTeamDaoTest {


    SupportTeamDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        com.stevesokasits.test.util.Database database = com.stevesokasits.test.util.Database.getInstance();
        database.runSQL("usersTestData.sql");
        dao = new SupportTeamDao();
    }

    /**
     * Test to verify we get all support teams
     */

    @Test
    void getAllSupportTeamsSuccess () {
        List<SupportTeam> supportTeams = dao.getAllSupportTeams();
        assertEquals(4,supportTeams.size());

    }

    /**
     *  Test to verify we can retreive a Support Team by Id
     */
    @Test
    void getByIdSuccess() {
        SupportTeam retrievedSupportTeam = dao.getById(1);
        assertEquals("Team 1", retrievedSupportTeam.getSupportTeamName());

    }


    /**
     * Test to verify we can insert a support Team (without users)
     */
    @Test
    void insertSuccess() {

        SupportTeam newSupportTeam = new SupportTeam("CanDoIt");

        //Insert record and return Id
        int id = dao.insert(newSupportTeam);

        //Should get something
        assertNotEquals(0,id);

        //Get newly inserted Id
        SupportTeam insertedSupportTeam = dao.getById(id);
        assertEquals("CanDoIt", insertedSupportTeam.getSupportTeamName());
    }


    /**
     * Test to verify we can insert a support Team (with users)
     */
    @Test
    void insertWithUserSuccess() {

        // Create Parent Object
        SupportTeam newSupportTeam = new SupportTeam("Team Test 1");

        // Create Child Object
        User newUser = new User("new@gmail.com","resource" ,"First", "Last",true,false,"college1", newSupportTeam);

        // Sync Child to parent
        newSupportTeam.addUser(newUser);

        // Insert record and get Id
        int id = dao.insert(newSupportTeam);

        // Should get something
        assertNotEquals(0,id);

        SupportTeam insertedSupportTeam = dao.getById(id);
        assertEquals("Team Test 1", insertedSupportTeam.getSupportTeamName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Test to verify we can delete a Support Team
     */
    @Test
    void deleteSuccess() {

        //Delete by Id Number
        dao.delete(dao.getById(3));

        //Check if ID is found
        assertNull(dao.getById(3));
    }

    /**
     * Test to verify we can update a support Team name
     */
    @Test
    void updateSupportTeam () {
        SupportTeam supportTeam = dao.getById(2);
        supportTeam.setSupportTeamName("testing");
        dao.saveOrUpdate(supportTeam);
        SupportTeam updatedSupportTeam = dao.getById(2);
        assertEquals("testing",updatedSupportTeam.getSupportTeamName());
    }

}
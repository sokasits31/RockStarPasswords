package com.stevesokasits.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Support team.
 */
@Entity(name="SupportTeam")   // Class controlled by Hibernate
@Table(name="support_teams")  // Table name that holds the data (case-sensitive)

public class SupportTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "support_team_name")
    private String supportTeamName;

    // mappedBy refers to instance variable on the User class
    // cascade(what's happening on database).... Get rid of suport we get rid of all the users
    // orphanRemval what Hiberate is doing with memory
    @OneToMany(mappedBy = "supportTeam", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();  // Hibernate needs this created in instances variables.

    /**
     * Instantiates a new Support team.
     */
    public SupportTeam() {
    }

    /**
     * Instantiates a new Support team.
     *
     * @param supportTeamName the support team name
     */
    public SupportTeam (String supportTeamName) {
        this.supportTeamName = supportTeamName;

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets support team name.
     *
     * @return the support team name
     */
    public String getSupportTeamName() {
        return supportTeamName;
    }

    /**
     * Sets support team name.
     *
     * @param supportTeamName the support team name
     */
    public void setSupportTeamName(String supportTeamName) {
        this.supportTeamName = supportTeamName;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }


    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser (User user) {
        users.add(user);
        user.setSupportTeam(this);
    }

    /**
     * Remove user.
     *
     * @param user the user
     */
    public void removeUser (User user) {
        users.remove(user);
        user.setSupportTeam(null);

    }


    @Override
    public String toString() {
        return "SupportTeam{" +
                "id=" + id +
                ", supportTeamName='" + supportTeamName + '\'' +
                ", users=" + users +
                '}';
    }
}

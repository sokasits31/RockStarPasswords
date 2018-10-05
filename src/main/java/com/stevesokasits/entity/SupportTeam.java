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
    private String support_team_name;


    @OneToMany(mappedBy = "suportTeam", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();  // Hibernate needs this created in instances variables.

    /**
     * Instantiates a new Support team.
     */
    public SupportTeam() {
    }


    /**
     * Instantiates a new Support team.
     *
     * @param support_team_name the support team name
     * @param user              the user
     */
    public SupportTeam (String support_team_name, User user) {
        this.support_team_name = support_team_name;
        this.user = user;
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
    public String getSupport_team_name() {
        return support_team_name;
    }

    /**
     * Sets support team name.
     *
     * @param support_team_name the support team name
     */
    public void setSupport_team_name(String support_team_name) {
        this.support_team_name = support_team_name;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public String toString() {
        return "SupportTeam{" +
                "id=" + id +
                ", support_team_name='" + support_team_name + '\'' +
                ", user=" + user +
                '}';
    }
}

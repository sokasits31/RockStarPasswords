package com.stevesokasits.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type User.
 */
@Entity(name = "User")
@Table(name = "users")
public class User {

    /**
     * Instance variables
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy =  "native")
    private int id;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "primary_support")
    private boolean primarySupport;

    @Column(name = "secondary_support")
    private boolean secondarySupport;

    private String password;

    @ManyToOne
    private SupportTeam supportTeam;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param emailAddress     the email address
     * @param userRole         the user role
     * @param firstName        the first name
     * @param lastName         the last name
     * @param primarySupport   the primary support
     * @param secondarySupport the secondary support
     * @param password         the password
     */
    public User(String emailAddress, String userRole, String firstName, String lastName, boolean primarySupport, boolean secondarySupport, String password, int supportTeamId) {
        this.emailAddress = emailAddress;
        this.userRole = userRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.primarySupport = primarySupport;
        this.secondarySupport = secondarySupport;
        this.password = password;
        this.supportTeam = supportTeam;
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
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets user role.
     *
     * @return the user role
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets user role.
     *
     * @param userRole the user role
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Is primary support boolean.
     *
     * @return the boolean
     */
    public boolean isPrimarySupport() {
        return primarySupport;
    }

    /**
     * Sets primary support.
     *
     * @param primarySupport the primary support
     */
    public void setPrimarySupport(boolean primarySupport) {
        this.primarySupport = primarySupport;
    }

    /**
     * Is secondary support boolean.
     *
     * @return the boolean
     */
    public boolean isSecondarySupport() {
        return secondarySupport;
    }

    /**
     * Sets secondary support.
     *
     * @param secondarySupport the secondary support
     */
    public void setSecondarySupport(boolean secondarySupport) {
        this.secondarySupport = secondarySupport;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets support team.
     *
     * @return the support team
     */
    public SupportTeam getSupportTeam() {
        return supportTeam;
    }

    /**
     * Sets support team.
     *
     * @param supportTeam the support team
     */
    public void setSupportTeam(SupportTeam supportTeam) {
        this.supportTeam = supportTeam;
    }
}

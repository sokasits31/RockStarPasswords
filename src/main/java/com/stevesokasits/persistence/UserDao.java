package com.stevesokasits.persistence;


import com.stevesokasits.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;


public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get user by id
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get( User.class, id );
        session.close();
        return user;
    }

    /**
     * update user
     * @param user  User to be inserted or updated
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(user);
        session.close();
    }

    /**
     * update user
     * @param user  User to be inserted or updated
     */
    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a user
     * @param user User to be deleted
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }


    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        System.out.println("111111111111111111");
        CriteriaBuilder builder = session.getCriteriaBuilder();
        System.out.println("222222222222222222222222222");
        CriteriaQuery<User> query = builder.createQuery( User.class );

        System.out.println("33333333333333333333333333333");


        Root<User> root = query.from( User.class );
        System.out.println("444444444444444444444444444444444444444444444");
        List<User> users = session.createQuery( query ).getResultList();

        logger.debug("The list of users " + users);
        session.close();

        return users;
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<User> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<User> users = session.createQuery( query ).getResultList();

        session.close();
        return users;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<User> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<User> users = session.createQuery( query ).getResultList();
        session.close();
        return users;
    }

}


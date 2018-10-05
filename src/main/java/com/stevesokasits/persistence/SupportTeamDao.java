package com.stevesokasits.persistence;


import com.stevesokasits.entity.SupportTeam;
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


public class SupportTeamDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get supportTeam by id
     */
    public SupportTeam getById(int id) {
        Session session = sessionFactory.openSession();
        SupportTeam supportTeam = session.get( SupportTeam.class, id );
        session.close();
        return supportTeam;
    }

    /**
     * update supportTeam
     * @param supportTeam  SupportTeam to be inserted or updated
     */
    public void saveOrUpdate(SupportTeam supportTeam) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(supportTeam);
        session.close();
    }

    /**
     * update supportTeam
     * @param supportTeam  SupportTeam to be inserted or updated
     */
    public int insert(SupportTeam supportTeam) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(supportTeam);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a supportTeam
     * @param supportTeam SupportTeam to be deleted
     */
    public void delete(SupportTeam supportTeam) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(supportTeam);
        transaction.commit();
        session.close();
    }


    /** Return a list of all users
     *
     * @return All users
     */
    public List<SupportTeam> getAllUsers() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SupportTeam> query = builder.createQuery( SupportTeam.class );
        Root<SupportTeam> root = query.from( SupportTeam.class );
        List<SupportTeam> users = session.createQuery( query ).getResultList();

        logger.debug("The list of users " + users);
        session.close();

        return users;
    }

    /**
     * Get supportTeam by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<SupportTeam> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for supportTeam with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SupportTeam> query = builder.createQuery( SupportTeam.class );
        Root<SupportTeam> root = query.from( SupportTeam.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<SupportTeam> users = session.createQuery( query ).getResultList();

        session.close();
        return users;
    }

    /**
     * Get supportTeam by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<SupportTeam> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for supportTeam with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SupportTeam> query = builder.createQuery( SupportTeam.class );
        Root<SupportTeam> root = query.from( SupportTeam.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<SupportTeam> users = session.createQuery( query ).getResultList();
        session.close();
        return users;
    }

}

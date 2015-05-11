package edu.arhs.team1100.worldclass.handlers;

import edu.arhs.team1100.worldclass.objects.Match;
import edu.arhs.team1100.worldclass.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author Eddie
 */
public class MatchHandler {

    /**
     * Adds a TeamEventMatch to the database
     *
     * @param tem
     * @return true if successful
     */
    public static boolean addMatch(Match tem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(tem);
        try {
            session.getTransaction().commit();
            return true;
        } catch (JDBCConnectionException | ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

    }

    /**
     * Updates a TeamEventMatch to the database
     *
     * @param tem
     */
    public static void updateMatch(Match tem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(tem);
        session.getTransaction().commit();
    }

    /**
     * Get all matches from the database
     *
     * @return List of all matches
     */
    public static List<Match> getMatches() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List tem = session.createQuery("from Match").list();
        session.getTransaction().commit();

        return tem;
    }

    /**
     * Deletes a match form the database
     *
     * @param match
     */
    public static void deleteMatch(Match match) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(match);

        session.getTransaction().commit();

    }

    public static List<Match> getMatchesFromTeam(int teamNumber) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List tem = session.createQuery("from Match where teamNumber = :team").setParameter("team", teamNumber).list();
        session.getTransaction().commit();

        return tem;
    }
    
    public static List<Match> getSavedMatches(int teamNumber){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List tem = session.createQuery("from Match where saved = true AND teamNumber = :team").setParameter("team", teamNumber).list();
        session.getTransaction().commit();

        return tem;
    }

}

package edu.arhs.team1100.worldclass.handlers;

import edu.arhs.team1100.worldclass.objects.Team;
import edu.arhs.team1100.worldclass.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Eddie
 */
public class TeamHandler {

    /**
     * Add a team to the database
     *
     * @param team
     * @return true if successful
     */
    public static boolean addTeam(Team team) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(team);

        try {
            session.getTransaction().commit();
            return true;
        } catch (ConstraintViolationException ex) {

            session.getTransaction().rollback();
            return false;
        }
    }

    /**
     * Gets all Teams in the database
     *
     * @return List of all Teams
     */
    public static List<Team> getTeams() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List teams = session.createQuery("from Team").list();
        session.getTransaction().commit();

        return teams;
    }

    /**
     * Updates a Team to the database
     *
     * @param team
     */
    public static void updateTeam(Team team) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(team);
        session.getTransaction().commit();
    }

    /**
     * Deletes a Team from the database
     *
     * @param team
     * @return
     */
    public static boolean deleteTeam(Team team) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(team);
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

        return true;
    }

    public static Team getTeamByNumnber(int teamNumber) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List team = session.createQuery("from Team where teamNumber = :number").setParameter("number", teamNumber).list();
        session.getTransaction().commit();
        return (Team) team.get(0);
    }
}

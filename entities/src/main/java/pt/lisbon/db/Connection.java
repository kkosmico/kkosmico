package pt.lisbon.db;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


/**
 * Created by José Carlos Campos Sousa on 10/03/2017.
 */
public class Connection {

    private static final Logger LOGGER = Logger.getLogger(Connection.class);

    private static Session session;

    public static Session getConnection() {
        if (session == null) {
            try {
                session = new Configuration().configure().buildSessionFactory().openSession();
            } catch (Exception e) {
                LOGGER.error("Error on connection the database: " + e.getMessage(), e);
            }
        }
        return session;
    }
}

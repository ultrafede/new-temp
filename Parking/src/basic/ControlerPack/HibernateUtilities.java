package basic.ControlerPack;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.apache.log4j.Logger;//nuova
/**
 * 
 * @author user
 *
 */
public class HibernateUtilities {

	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;
	/**
	 *@param class HibernateUtilities 
	 */
	final static Logger logger = Logger.getLogger(HibernateUtilities.class);
	static {

		try {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			System.out.println("session factory..");

		} catch (HibernateException e) {
			logger.error("Problem creating session factory", e);
			//log
			
		}
	}
	
	private HibernateUtilities() {
		
	}

	/**
	 * 
	 * @return
	 */
	public static SessionFactory getsSessionFactory() {
		return sessionFactory;
	}
	
}
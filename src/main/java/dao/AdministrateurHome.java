package dao;
// Generated 1 juil. 2019 11:22:20 by Hibernate Tools 5.4.2.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import entities.Administrateur;

/**
 * Home object for domain model class Administrateur.
 * @see dao.Administrateur
 * @author Hibernate Tools
 */
public class AdministrateurHome {

	private static final Log log = LogFactory.getLog(AdministrateurHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Administrateur transientInstance) {
		log.debug("persisting Administrateur instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Administrateur instance) {
		log.debug("attaching dirty Administrateur instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Administrateur instance) {
		log.debug("attaching clean Administrateur instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Administrateur persistentInstance) {
		log.debug("deleting Administrateur instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Administrateur merge(Administrateur detachedInstance) {
		log.debug("merging Administrateur instance");
		try {
			Administrateur result = (Administrateur) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Administrateur findById(entities.AdministrateurId id) {
		log.debug("getting Administrateur instance with id: " + id);
		try {
			Administrateur instance = (Administrateur) sessionFactory.getCurrentSession().get("dao.Administrateur", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Administrateur instance) {
		log.debug("finding Administrateur instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("dao.Administrateur")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}

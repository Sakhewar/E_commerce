package dao;
// Generated 1 juil. 2019 11:22:20 by Hibernate Tools 5.4.2.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import entities.Boutique;

/**
 * Home object for domain model class Boutique.
 * @see dao.Boutique
 * @author Hibernate Tools
 */
public class BoutiqueHome {

	private static final Log log = LogFactory.getLog(BoutiqueHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Boutique transientInstance) {
		log.debug("persisting Boutique instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Boutique instance) {
		log.debug("attaching dirty Boutique instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Boutique instance) {
		log.debug("attaching clean Boutique instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Boutique persistentInstance) {
		log.debug("deleting Boutique instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Boutique merge(Boutique detachedInstance) {
		log.debug("merging Boutique instance");
		try {
			Boutique result = (Boutique) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Boutique findById(int id) {
		log.debug("getting Boutique instance with id: " + id);
		try {
			Boutique instance = (Boutique) sessionFactory.getCurrentSession().get("dao.Boutique", id);
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

	public List findByExample(Boutique instance) {
		log.debug("finding Boutique instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("dao.Boutique")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}

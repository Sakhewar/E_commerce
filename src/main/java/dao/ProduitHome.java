package dao;
// Generated 1 juil. 2019 11:22:20 by Hibernate Tools 5.4.2.Final


import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entities.Produit;
import testbean.HibernateUtil;

/**
 * Home object for domain model class Produit.
 * @see dao.Produit
 * @author Hibernate Tools
 */
public class ProduitHome implements Serializable{
	
	public ProduitHome(){
		
	}
	
	
	public void create(Produit p) {
		
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(p);
		//Commit transaction
		tx.commit();
		System.out.println("Transaction Reussie");	
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}
		
	}

	
}

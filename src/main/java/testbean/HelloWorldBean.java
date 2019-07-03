package testbean;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ProduitHome;
import entities.Produit;

 
@ManagedBean(name="helloWorldBean")
@RequestScoped
public class HelloWorldBean  {
    
	public Produit produit ;
	public ProduitHome P ;  
	
    @PostConstruct
	public void init() {
    	produit = new Produit() ; 
    	
	 
	}
    
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	public ProduitHome getProduitHome() {
		return P ; 
	}
	public void setProduitHome(ProduitHome prodhome) {
		this.P = prodhome ; 
	}
	
	
		
	public void create(){ 
		/*
		 * P = new ProduitHome() ; P.create(produit);
		 */
		  
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// Get Session 
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			System.out.println("Session created"); 
			// start transaction 
			tx =session.beginTransaction(); 
			// Save the Model object
			session.save(produit);
			// Commit transaction 
			tx.commit(); 
			System.out.println("Transaction Reussie");
		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		}
		 
	   }
	
	public List<Produit> lst = new ArrayList<Produit> (); 
	
	public List<Produit> getLst(){
		return lst ; 
	}
    public void setLst(List<Produit> lst) {
    	this.lst = lst ; 
    }
    
    public List<Produit> affiche(){
    	
    	List<Produit> lst = new ArrayList<Produit> (); 
    	SessionFactory sessionFactory = null;
		Session session = null;
		Transaction t = null;
		try {
		//Get session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		System.out.println("Session created");
		
		//start transaction
		t = session.beginTransaction();
		
		//find
		
		lst = session.createCriteria(Produit.class).list() ; 
		
		System.out.println("liste de produit recupere");
		
		//commit
		t = session.getTransaction() ; 
		t.commit();
		System.out.println("transaction cool");
		
		}catch(Exception e) {
			//System.out.println("Exception occured. "+e.getMessage());
			
		}
		
		
		
		
		return lst ; 
    	
    	
    }
    
    public void update(){
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
			
			//Update
    	    session.update(produit);
    	    
    	  //Commit transaction
    	    tx =  session.getTransaction() ;
			tx.commit();
			System.out.println("Transaction Reussie");	
    	  
		}catch (Exception e){
    	e.printStackTrace();
    	session.getTransaction().rollback();
    	}
    	}
    
    public String edit(Integer clt){
    	
    	System.out.println(clt);	
    	return "update";
    	}
    
    public void delete(Produit clt){
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
    	    session.delete(clt);
    	    tx =session.getTransaction() ; 
    	    tx.commit();
    	}catch (Exception e){
    	e.printStackTrace();
    	session.getTransaction().rollback();
    	}
    	}
    
    
    
 
}


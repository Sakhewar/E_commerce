package controller;

import entities.Produit;
import testbean.HibernateUtil;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean ;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ProduitHome;

@ManagedBean(name = "productController")
@SessionScoped

public class ProductController implements Serializable {

	public Produit produit ;



	
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
	
	
	  public String create(){ 
		  Produit clt = new Produit() ; SessionFactory
	  sessionFactory = null;
		  Session session = null; 
		  Transaction tx = null ; try{
	  //Get Session sessionFactory = HibernateUtil.getSessionFactory(); session =
	  sessionFactory.openSession() ; System.out.println("Session created"); //start transaction
	  
	  session.beginTransaction(); session.save(clt);
	  session.getTransaction().commit();
	  
	  
	  tx = session.beginTransaction(); //Save the Model object session.save(clt);
	  //Commit transaction session.getTransaction().commit();
	  System.out.println("Transaction cool");
	  
	  }catch (Exception e){
	  
	  e.printStackTrace(); System.out.println("Errooooooor");
	  
	  
	  } return "index"; }
	 
	  
	  

	 

}

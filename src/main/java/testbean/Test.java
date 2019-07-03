package testbean;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import entities.Produit;

public class Test {

	public static void main(String[] args) {
		
		Produit txn = buildDemoTransaction();
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(txn);
		//Commit transaction
		tx.commit();
		System.out.println("Transaction cool");
		
		
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}


	private static Produit buildDemoTransaction() {
		Produit txn = new Produit() ;
		txn.setIdprod(17);
		txn.setCodeproduit(17);
		txn.setNom(17);
	
		return txn;
	}

}
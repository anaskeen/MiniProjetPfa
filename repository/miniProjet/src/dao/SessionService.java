package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import model.Session;

public class SessionService {	EntityManager em=null;
UserTransaction trans;

public void ajouterSession(Session a){
	
	try {
		trans.begin();
		em.persist(a);
		em.flush();
		trans.commit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		try {
			trans.rollback();
		} 
		 catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}	
	
	
}


public void supprimerSession(int id) {
	
	Session a = em.find(Session.class, id);

	  
	  try {
		  trans.begin();
		  em.remove(a);
		trans.commit();
	} catch (Exception e) {
		
		e.printStackTrace();
		try {
			trans.rollback();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}

	}
	
public void modifierSession(int id) {
	Session a = em.find(Session.class, id);
			try {
				trans.begin();
				em.merge(a);
				trans.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					trans.rollback();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
			
		
		}

@SuppressWarnings("unchecked")
public List<Session> toutSession() {
	
	return em.createNamedQuery(Session.class.getSimpleName()+"findAll").getResultList();
	
	
}

}

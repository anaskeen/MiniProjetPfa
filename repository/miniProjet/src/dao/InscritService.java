package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import model.Inscrit;

public class InscritService {	EntityManager em=null;
UserTransaction trans;

public void ajouterInscrit(Inscrit a){
	
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


public void supprimeInscrit(int id) {
	
	Inscrit a = em.find(Inscrit.class, id);

	  
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
	
public void modifierInscrit(int id) {
	Inscrit a = em.find(Inscrit.class, id);
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
public List<Inscrit> toutInscrit() {
	
	return em.createNamedQuery(Inscrit.class.getSimpleName()+"findAll").getResultList();
	
	
}

}

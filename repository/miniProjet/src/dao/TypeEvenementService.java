package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import model.Typeevenement;

public class TypeEvenementService {
	EntityManager em=null;
	UserTransaction trans;
	
	public void ajouterTypeEvent(Typeevenement a){
		
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

	
	public void supprimerTypeEvent(int id) {
		
		Typeevenement a = em.find(Typeevenement.class, id);

		  
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
		
	public void modifierTypeEvent(int id) {
		Typeevenement a = em.find(Typeevenement.class, id);
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
	public List<Typeevenement> toutTypeEvent() {
		
		return em.createNamedQuery(Typeevenement.class.getSimpleName()+"findAll").getResultList();
		
		
	}

}

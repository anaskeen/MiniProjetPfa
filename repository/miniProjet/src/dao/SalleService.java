package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import model.Salle;

public class SalleService {
	EntityManager em=null;
	UserTransaction trans;
	
	public void ajouterSalle(Salle a){
		
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

	
	public void supprimerSalle(int id) {
		
		Salle a = em.find(Salle.class, id);

		  
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
		
	public void modifierSalle(int id) {
		Salle a = em.find(Salle.class, id);
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
	public List<Salle> toutSalle() {
		
		return em.createNamedQuery(Salle.class.getSimpleName()+"findAll").getResultList();
		
		
	}

}

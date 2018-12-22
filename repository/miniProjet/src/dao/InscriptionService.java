package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import model.Inscription;

public class InscriptionService {
	EntityManager em=null;
	UserTransaction trans;
	
	public void ajouterInscription(Inscription a){
		
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

	
	public void supprimerIncription(int id) {
		
		Inscription a = em.find(Inscription.class, id);

		  
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
		
	public void modifierInscription(int id) {
		Inscription a = em.find(Inscription.class, id);
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
	public List<Inscription> toutInscription() {
		
		return em.createNamedQuery(Inscription.class.getSimpleName()+"findAll").getResultList();
		
		
	}

}

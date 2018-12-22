package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import model.Evenement;



public class EvenementService {
	
	EntityManager em=null;
	UserTransaction trans;
	
	public void ajouterEvent(Evenement a) {
		
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

	
	public void supprimerEvent(int id) {
		
		Evenement a = em.find(Evenement.class, id);

		  
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
		
	public void modifierEvent(int id) {
		Evenement a = em.find(Evenement.class, id);
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
	public List<Evenement> toutEvent() {
		
		return em.createNamedQuery(Evenement.class.getSimpleName()+"findAll").getResultList();
		
		
	}

}

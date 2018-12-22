package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;


import model.Hotesse;

public class HotesseService {
	EntityManager em=null;
	UserTransaction trans;
	
	public void ajouterHotesse(Hotesse a){
		
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

	
	public void supprimerHotesse(int id) {
		
		Hotesse a = em.find(Hotesse.class, id);

		  
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
		
	public void modifierHotesse(int id) {
		Hotesse a = em.find(Hotesse.class, id);
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
	public List<Hotesse> toutHotesse() {
		
		return em.createNamedQuery(Hotesse.class.getSimpleName()+"findAll").getResultList();
		
		
	}

}

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.UserTransaction;

import model.Administrateur;

@PersistenceContext(name="miniProjet", type=PersistenceContextType.EXTENDED)
public class AdministrateurService {

	EntityManager em=null;
	UserTransaction trans;
	
	public void ajouterAdmin(Administrateur a){
		
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

	
	public void supprimerAdmin(int id) {
		
		Administrateur a = em.find(Administrateur.class, id);

		  
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
		
	public void modifierAdmin(int id) {
		Administrateur a = em.find(Administrateur.class, id);
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
	public List<Administrateur> toutAdmin() {
		
		return em.createNamedQuery(Administrateur.class.getSimpleName()+"findAll").getResultList();
		
		
	}
		
	
	
}	


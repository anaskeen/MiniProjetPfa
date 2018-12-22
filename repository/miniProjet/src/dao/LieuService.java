package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import model.Lieu;

public class LieuService {
	EntityManager em=null;
	UserTransaction trans;
	
	public void ajouterLieu(Lieu a){
		
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

	
	public void supprimerLieu(int id) {
		
		Lieu a = em.find(Lieu.class, id);

		  
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
		
	public void modifierLieu(int id) {
		Lieu a = em.find(Lieu.class, id);
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
	public List<Lieu> toutLieu() {
		
		return em.createNamedQuery(Lieu.class.getSimpleName()+"findAll").getResultList();
		
		
	}

}

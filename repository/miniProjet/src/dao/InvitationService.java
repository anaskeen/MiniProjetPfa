package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import model.Invitation;

public class InvitationService {
	EntityManager em=null;
	UserTransaction trans;
	
	public void ajouterInvitation(Invitation a){
		
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

	
	public void supprimerInviation(int id) {
		
		Invitation a = em.find(Invitation.class, id);

		  
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
		
	public void modifierInvitation(int id) {
		Invitation a = em.find(Invitation.class, id);
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
	public List<Invitation> toutInvitation() {
		
		return em.createNamedQuery(Invitation.class.getSimpleName()+"findAll").getResultList();
		
		
	}

}

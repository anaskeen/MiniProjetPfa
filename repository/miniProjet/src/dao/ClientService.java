package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import model.Client;


public class ClientService {
	
	EntityManager em=null;
	UserTransaction trans;
	
	public void ajouterClient(Client a){
		
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

	
	public void supprimerClient(int id) {
		
		Client a = em.find(Client.class, id);

		  
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
		
	public void modifierClient(int id) {
		Client a = em.find(Client.class, id);
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
	public List<Client> toutClient() {
		
		return em.createNamedQuery(Client.class.getSimpleName()+"findAll").getResultList();
		
		
	}

}

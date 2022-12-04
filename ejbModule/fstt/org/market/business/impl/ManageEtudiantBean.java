package fstt.org.market.business.impl;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import fstt.org.market.business.EtudiantRemote;
import fstt.org.market.entities.persistence.Etudiant;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityTransaction;

/**
 * Session Bean implementation class ManageEtudiantBean
 */
@Stateless
public class ManageEtudiantBean implements EtudiantRemote {

	@PersistenceContext(unitName = "etudiantUnit")
    private static EntityManager entityManager = Persistence.createEntityManagerFactory("etudiantUnit").createEntityManager();
	private static EntityTransaction transactionObj = entityManager.getTransaction();
	
    /**
     * Default constructor. 
     */
    public ManageEtudiantBean() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Etudiant> findAll() {
		List<Etudiant> list = new ArrayList<Etudiant>();
		list = entityManager.createQuery("select i from Etudiant i", Etudiant.class).getResultList();
		return list;
    }
    public Etudiant findEtudiantById(Integer id) throws IOException {
    	Etudiant etudiant = entityManager.find(Etudiant.class, id);
        if (etudiant == null) {
            throw new IOException();
        }
        return etudiant;
    }
    

    public void updateEtudiant(Integer id, Etudiant etudiant) throws IOException {
    	Etudiant etudiantToUpdate = findEtudiantById(id);
    	
    	etudiantToUpdate.setNom(etudiant.getNom());
    	etudiantToUpdate.setPrenom(etudiant.getPrenom());
    	etudiantToUpdate.setCne(etudiant.getCne());
    	etudiantToUpdate.setAdresse(etudiant.getAdresse());
    	etudiantToUpdate.setNiveau(etudiant.getNiveau());
    }
    
    public void addEtudiant(Etudiant etudiant) {
    	if(!transactionObj.isActive()) {
			transactionObj.begin();
		}
        entityManager.persist(etudiant);
        transactionObj.commit();
    } 
    
    public void deleteClient(Integer etudiantId) throws IOException {
    	if(!transactionObj.isActive()) {
			transactionObj.begin();
		}
        entityManager.createNativeQuery("delete from Etudiant where id = ?")
        .setParameter(1, etudiantId)
        .executeUpdate();
    }

}

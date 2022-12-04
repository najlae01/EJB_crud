package fstt.org.market.business;

import java.io.IOException;
import java.util.List;

import fstt.org.market.entities.persistence.Etudiant;
import jakarta.ejb.Remote;

@Remote
public interface EtudiantRemote {

	public void addEtudiant(Etudiant etudiant);
	
	public void updateEtudiant(Integer id, Etudiant etudiant) throws IOException;
	
	public void deleteClient(Integer etudiantId) throws IOException;
	
	public Etudiant findEtudiantById(Integer id) throws IOException;
	
	public List<Etudiant> findAll();
	
}

package mdb.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mdb.metier.dao.ProduitDao;
import mdb.metier.model.Produit;

@Transactional
@Repository
public class ProduitDaoJpa implements ProduitDao{
	
	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;


	@Override
	@Transactional(readOnly=true)
	public Produit find(Long id) {
		return em.find(Produit.class, id);
		
	}
	


	@Override
	@Transactional(readOnly=true)
	public List<Produit> findAll() {
		Query query = em.createQuery("from Produit l");		
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Produit> findByCategorie(Long catid) {
		Query query = em.createQuery("select l from Produit l join fetch l.categorie c where c.id= :catid");	
		query.setParameter("catid", catid);		
		return query.getResultList();
	}

	@Override
	public void create(Produit produit) {
		em.persist(produit);
	}

	//un objet récupéré de la base est déjà managé donc les modif se font automatiquement pas besoin d'update
	//on utilise update pour merger objet
	@Override
	public Produit update(Produit produit) {
		return em.merge(produit);
		
	}

	@Override
	public void delete(Produit produit) {
		em.remove(produit);
		
	}

	@Override
	public void delete(Long id) {
		Produit produit = find(id);
		em.remove(produit);
		
	}


}

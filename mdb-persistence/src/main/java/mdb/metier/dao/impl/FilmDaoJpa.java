package mdb.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mdb.metier.dao.FilmDao;
import mdb.metier.model.Film;

@Transactional
@Repository
public class FilmDaoJpa implements FilmDao{
	
	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;


	@Override
	@Transactional(readOnly=true)
	public Film find(Long id) {
		return em.find(Film.class, id);
		
	}
	


	@Override
	@Transactional(readOnly=true)
	public List<Film> findAll() {
		Query query = em.createQuery("from Film l");		
		return query.getResultList();
	}
	


	@Override
	public void create(Film film) {
		em.persist(film);
	}

	//un objet récupéré de la base est déjà managé donc les modif se font automatiquement pas besoin d'update
	//on utilise update pour merger objet
	@Override
	public Film update(Film film) {
		return em.merge(film);
		
	}

	@Override
	public void delete(Film film) {
		em.remove(film);
		
	}

	@Override
	public void delete(Long id) {
		Film film = find(id);
		em.remove(film);
		
	}


}

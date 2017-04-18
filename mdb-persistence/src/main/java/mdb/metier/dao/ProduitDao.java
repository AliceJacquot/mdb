package mdb.metier.dao;

import java.util.List;

import mdb.metier.model.Produit;

public interface ProduitDao extends Dao<Produit, Long> {
	public List<Produit> findByCategorie(Long catid);
}

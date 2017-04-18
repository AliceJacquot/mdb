package tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import mdb.metier.dao.FilmDao;
import mdb.metier.dao.ProduitDao;
import mdb.metier.model.Film;
import mdb.metier.model.Produit;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@Rollback(false)
public class TestCasPrat {
	@Autowired
	private FilmDao filmDao;
	@Autowired
	private ProduitDao produitDao;





	@Test
	@Transactional
	public void creationtablesuser() {
		Film f = new Film("Test");
		f.setDescription("premeir film test");
		f.setId(1L);
		filmDao.create(f);
		Film fbis=filmDao.find(new Long(1));
		Assert.assertTrue(fbis.getTitre().equals(f.getTitre()));
		//filmDao.delete(fbis);

		
	//	User pers = new User("momo", "chut", "Fret", "Mona", Type.AdminProd, "1 passage", "75000", "Paris", "France");
	//	userDao.create(pers);
	//	User pers2 = new User("momo2", "chut", "Fret2", "Mona2", Type.AdminCat, "2 passage", "75000", "Paris2", "France");
	//	userDao.create(pers2);
	//	Assert.assertTrue("Mona2".equals(userDao.find(new Long(10)).getPrenom()));
	//	Assert.assertTrue(Type.AdminCat==userDao.find("momo2").getType());
	//	Assert.assertTrue("2 passage".equals(userDao.find("momo2").getAdresse().getRue()));
		
		
	}
	
//	@Test
//	@Transactional
//	public void remplissage() {
	/*	User pers = new User("momo", "chut", "Fret", "Mona", Type.AdminProd, "1 passage", "75000", "Paris", "France");
		User pers2 = new User("momo2", "chut", "Fret2", "Mona2", Type.AdminCat, "2 passage", "75000", "Paris2", "France");
		Commande com1 = new Commande(new Date(), "commande test", pers);
		Commande com2 = new Commande(new Date(), "commande test 2", pers2);
		com2.setEtat(Etat.paye);
		com2.setTotal(5.6);
		com2.setAdrLivraison(new Adresse ("chez ma soeur", "41200", "Une ville", "Fra"));
		Categorie pcs= new Categorie("PC", "la catégorie des ordinateurs ");
		Categorie imp= new Categorie("Petites Imprimante","Pour imprimer chez soi");
		Produit hp = new Produit("HP123", "gros et bon", 41, 411.54);
		hp.setCategorie(pcs);
		Produit hp2 = new Produit("HP743", "petit et lent", 411, 865.);
		hp2.setCategorie(pcs);
		Produit laz = new Produit("LAZ-5000", "imprimante lazer trop cool", 10, 99.99);
		laz.setCategorie(imp);
		LigneCommande l1 = new LigneCommande(hp, com2, 3);
		LigneCommande l2 = new LigneCommande(laz, com2, 1);
		
		
		userDao.create(pers);
		userDao.create(pers2);
		commandeDao.create(com1);
		commandeDao.create(com2);
		categorieDao.create(pcs);
		categorieDao.create(imp);
		produitDao.create(laz);
		produitDao.create(hp);
		produitDao.create(hp2);
		lignecommandeDao.create(l1);
		lignecommandeDao.create(l2);
		
		*/
//		
//	}
//	
//	@Test
//	@Transactional
//	public void apresremplissage() {

		//System.out.println(lignecommandeDao.findForCommande(new Long(12)));
		
//	}

}
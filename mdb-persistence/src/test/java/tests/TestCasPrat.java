package tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
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
@Rollback(true)
public class TestCasPrat {
	@Autowired
	private FilmDao filmDao;

	//valeurs pour test
	private Film f;


	@Before
	public void initValues(){
		f = new Film("Test");
		f.setDescription("premeir film test");
		f.setPosterPath("pasparth");
		f.setId(2L);
	}

	@Test
	@Transactional
	public void testcreationFilm() {

		
		//Assert.fail("vla");

//		Assert.assertTrue("vr".equals("de"));
		filmDao.create(f);
//		System.out.println(f);
		Film fbis=filmDao.find(new Long(2));
		System.out.println(fbis);
		Assert.assertTrue(fbis.getTitre().equals(f.getTitre()));
		Assert.assertEquals("premeir film test", fbis.getDescription());
////		Assert.assertEquals("pasparth", f.getPosterPath());
		filmDao.delete(fbis);
		Assert.assertNull(filmDao.find(new Long(2)));
		
	}
	


}
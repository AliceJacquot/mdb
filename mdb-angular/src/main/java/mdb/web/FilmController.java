package mdb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mdb.metier.dao.FilmDao;
import mdb.metier.model.Film;

@RestController
public class FilmController {

	@Autowired
	private FilmDao filmDao;

	@RequestMapping(value = "/films/", method = RequestMethod.GET)
	public ResponseEntity<List<Film>> listFilm() {
		System.out.println("cou");
		//return null;
		List<Film> films = filmDao.findAll();
		if (films == null) {
			System.out.println("cou");
			return new ResponseEntity<List<Film>>(HttpStatus.NO_CONTENT);
		} else {
			System.out.println("covdu");
			return new ResponseEntity<List<Film>>(films, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/savefilm/", method = RequestMethod.POST)
	public void saveFilm(@RequestBody Film film) {
		System.out.println("Sauvegarde en base d'un film");
		filmDao.update(film);
//TODO
	}
	
}

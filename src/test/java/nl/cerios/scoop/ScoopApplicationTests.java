package nl.cerios.scoop;

import nl.cerios.scoop.domain.Film;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import nl.cerios.scoop.service.FilmService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoopApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFilmNotNull() {
		FilmService fs = new FilmService();
		Film tarzan = fs.getFilm("FILMTZ");

		assert(tarzan != null);
	}

	@Test
	public void testFilmTitleNotNull() {
		FilmService fs = new FilmService();
		Film tarzan = fs.getFilm("FILMTZ");

		assert(tarzan.getTitle() != null);
	}
}

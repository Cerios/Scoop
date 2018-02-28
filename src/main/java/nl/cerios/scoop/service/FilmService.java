package nl.cerios.scoop.service;

import nl.cerios.scoop.domain.Film;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by dwhelan on 08/02/2018.
 */
@Component
@Configuration
public class FilmService {

    ArrayList<Film> filmArrayList_;

    public FilmService() {
        filmArrayList_ = new ArrayList<Film>();
        initTestFilms();
    }

    private void initTestFilms() {
        Film JB = new Film();
        JB.setId("FILMJB");
        JB.setTitle("A View to a Kill");
        JB.setSummary("Agent 007 (Roger Moore) moet het opnemen tegen twee van de dodelijkste schurken: de superinteligente Max Zorin (Christopher Walken), product van een genetisch Nazi-experiment en zijn handlangerster May-Day, heerlijk boosaardig gespeeld door Grace Jones. ");

        Film K3 = new Film();
        K3.setId("FILMK3");
        K3.setTitle("K3");
        K3.setSummary("K3 wordt uitgenodigd in een sprookjesland om daar te gaan zingen voor een prinses.");

        Film TZ = new Film();
        TZ.setId("FILMTZ");
        TZ.setTitle("Tarzan");
        TZ.setSummary("De film vertelt het verhaal van John Clayton. Hij wordt geboren in de jungle aan de westkust van Afrika. Zijn ouders, John en Alice Clayton, zijn kort voor zijn geboorte achtergelaten in de jungle door een groep muiters die hun schip hadden overgenomen.");

        filmArrayList_.add(JB);
        filmArrayList_.add(K3);
        filmArrayList_.add(TZ);
    }

    public Film getFilm(String id) {
        Film foundFilm = null;

        for (Film f : filmArrayList_) {
            if (f.getId().equalsIgnoreCase(id)) {
                foundFilm = f;
                break;
            }
        }

        return foundFilm;
    }

    //Hashset??
    public ArrayList<Film> getFilms() {
        return filmArrayList_;
    }

}
package nl.cerios.scoop;

import java.util.ArrayList;

/**
 * Created by dwhelan on 08/02/2018.
 */
public class FilmDB {

    ArrayList<Film> filmArrayList;

    public FilmDB()
    {
        filmArrayList = new ArrayList<Film>();

        Film JB = new Film("FILMJB","A View to a Kill", "Agent 007 (Roger Moore) moet het opnemen tegen twee van de dodelijkste schurken: de superinteligente Max Zorin (Christopher Walken), product van een genetisch Nazi-experiment en zijn handlangerster May-Day, heerlijk boosaardig gespeeld door Grace Jones. ");
        Film K3 = new Film("FILMK3","K3","K3 wordt uitgenodigd in een sprookjesland om daar te gaan zingen voor een prinses.");
        Film TZ = new Film("FILMTZ","Tarzan","De film vertelt het verhaal van John Clayton. Hij wordt geboren in de jungle aan de westkust van Afrika. Zijn ouders, John en Alice Clayton, zijn kort voor zijn geboorte achtergelaten in de jungle door een groep muiters die hun schip hadden overgenomen.");

        filmArrayList.add(JB);
        filmArrayList.add(K3);
        filmArrayList.add(TZ);
    }

    public Film getFilm(String id)
    {
        Film found = null;

        for (Film f : filmArrayList)
        {
            if (f.getId().equals(id)){
                found = f;
            }
        }

        return found;
    }

    public ArrayList<Film> getFilms() {
        return filmArrayList;
    }

}

package nl.cerios.scoop.domain;

/**
 * Created by dwhelan on 13/02/2018.
 */
public class FilmFactory {

    public Film createFilm(String id, String title, String summary) {
        Film f = new Film();

        f.setId(id);
        f.setTitle(title);
        f.setSummary(summary);

        if (validateFilm(f)) {
            return f;
        }

        else return null;
    }

    public static boolean validateFilm(Film f)
    {
        boolean validFilm = false;

        if (f.getId() == null &&
            !f.getId().equalsIgnoreCase("") &&
            f.getTitle() != null &&
            f.getSummary() != null) {
            validFilm = true;
        }

        return validFilm;
    }
}

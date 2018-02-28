package nl.cerios.scoop.service;

import com.sun.org.apache.xalan.internal.xsltc.dom.ArrayNodeListIterator;
import nl.cerios.scoop.domain.Film;
import nl.cerios.scoop.domain.Hall;
import nl.cerios.scoop.domain.Show;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dwhelan on 15/02/2018.
 */
@Component
@Configuration
public class ShowService {

    //TODO: Consolidate Services
    ArrayList<Show> showArrayList_;

    public ShowService() {
        showArrayList_ = new ArrayList<Show>();
        initTestShows();
    }

    private void initTestShows() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);

        //TODO: How to not instantiate with Spring Magic?
        FilmService fs = new FilmService();
        HallService hs = new HallService();

        //Film JB = fs.getFilm("FILMJB");
        //Film K3 = fs.getFilm("FILMK3");
        //Film TZ = fs.getFilm("FILMTZ");
        //Hall GZ = hs.getHall("GZ");
        //Hall RZ = hs.getHall("RZ");

        //Show info should come from services as above but for now from here
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

        Hall GZ = new Hall();
        GZ.setId("GZ");
        GZ.setName("Grote Zaal");
        GZ.setSeats(300);
        Hall RZ = new Hall();
        RZ.setId("RZ");
        RZ.setName("Rode Zaal");
        RZ.setSeats(60);
        //End service spoofing

        Show show1 = new Show();
        show1.setId("S1");
        show1.setFilm(JB);
        show1.setHall(GZ);
        show1.setSeats(0);
        show1.setTime(LocalDateTime.of(today, LocalTime.of(22, 00)));

        Show show2 = new Show();
        show2.setId("S2");
        show2.setFilm(K3);
        show2.setHall(GZ);
        show2.setSeats(0);
        show2.setTime(LocalDateTime.of(today, LocalTime.of(14, 00)));

        Show show3 = new Show();
        show3.setId("S3");
        show3.setFilm(K3);
        show3.setHall(GZ);
        show3.setSeats(0);
        show3.setTime(LocalDateTime.of(today, LocalTime.of(17, 00)));

        Show show4 = new Show();
        show4.setId("S4");
        show4.setFilm(TZ);
        show4.setHall(RZ);
        show4.setSeats(0);
        show4.setTime(LocalDateTime.of(today, LocalTime.of(20, 00)));

        Show show5 = new Show();
        show5.setId("S5");
        show5.setFilm(TZ);
        show5.setHall(RZ);
        show5.setSeats(0);
        show5.setTime(LocalDateTime.of(today, LocalTime.of(22, 00)));

        Show show6 = new Show();
        show6.setId("S6");
        show6.setFilm(JB);
        show6.setHall(GZ);
        show6.setSeats(0);
        show6.setTime(LocalDateTime.of(tomorrow, LocalTime.of(22, 00)));

        Show show7 = new Show();
        show7.setId("S7");
        show7.setFilm(K3);
        show7.setHall(GZ);
        show7.setSeats(0);
        show7.setTime(LocalDateTime.of(tomorrow, LocalTime.of(14, 00)));

        showArrayList_.add(show1);
        showArrayList_.add(show2);
        showArrayList_.add(show3);
        showArrayList_.add(show4);
        showArrayList_.add(show5);
        showArrayList_.add(show6);
        showArrayList_.add(show7);
    }

    public Show getShow(String id) {
        Show foundShow = null;

        for (Show s : showArrayList_) {
            if (s.getId().equalsIgnoreCase(id)) {
                foundShow = s;
                break;
            }
        }

        return foundShow;
    }

    public void getShowsByHall(LocalDate date, Hall hall) {

    }

    public ArrayList<Show> getShowsByDate(LocalDate date) {
        ArrayList foundShows = new ArrayList<Show>();

        for (Show s : showArrayList_) {
            LocalDateTime showTime = s.getTime();
            if (showTime.getYear() == date.getYear() &&
                    showTime.getDayOfMonth() == date.getDayOfMonth())
            {
                foundShows.add(s);
            }
        }

        return foundShows;
    }

    public ArrayList<Show> getShowsToday() {
        LocalDate today = LocalDate.now();

        return getShowsByDate(today);
    }

    public ArrayList<Show> sortShowsByTime(ArrayList<Show> shows) {
        ArrayList<Show> sortedShows =  shows;

        Collections.sort(sortedShows, new Comparator<Show> () {
            public int compare(Show s1, Show s2) {
                LocalDateTime a = s1.getTime();
                LocalDateTime b = s2.getTime();
                if (a.isBefore(b)) return -1;
                else if (a.isEqual(b)) return 0;
                else return 1;
            }
        });

        return sortedShows;
    }


}

package nl.cerios.scoop.service;

import nl.cerios.scoop.domain.Hall;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by dwhelan on 15/02/2018.
 */
@Component
@Configuration
public class HallService {

    ArrayList<Hall> hallArrayList_;

    public HallService() {
        hallArrayList_ = new ArrayList<Hall>();
        initTestHalls();
    }

    private void initTestHalls() {
        Hall GZ = new Hall();
        GZ.setId("GZ");
        GZ.setName("Grote Zaal");
        GZ.setSeats(300);

        Hall RZ = new Hall();
        RZ.setId("RZ");
        RZ.setName("Rode Zaal");
        RZ.setSeats(60);

        hallArrayList_.add(GZ);
        hallArrayList_.add(RZ);
    }

    public Hall getHall(String id) {
        Hall foundHall = null;

        for (Hall h : hallArrayList_) {
            if (h.getId().equalsIgnoreCase(id)) {
                foundHall = h;
                break;
            }
        }

        return foundHall;
    }

    public ArrayList<Hall> getHalls() {
        return hallArrayList_;
    }
}

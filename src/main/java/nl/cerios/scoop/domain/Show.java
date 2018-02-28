package nl.cerios.scoop.domain;

import java.time.LocalDateTime;

/**
 * Created by dwhelan on 13/02/2018.
 */
public class Show {
    protected String id_;
    protected Film film_;
    protected Hall hall_;

    protected int seats_;
    protected LocalDateTime time_;

    public void setId(String id) { id_ = id; }
    public void setFilm(Film film) { film_ = film; }
    public void setHall(Hall hall) { hall_ = hall; }
    public void setSeats(int seats) { seats_ = seats; }
    public void setTime(LocalDateTime time) { time_ = time; }

    public String getId() { return id_;}
    public Film getFilm() { return film_; }
    public Hall getHall() { return hall_; }
    public int getSeats() { return seats_; }
    public LocalDateTime getTime() { return time_; }
}
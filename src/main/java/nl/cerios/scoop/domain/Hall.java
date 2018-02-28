package nl.cerios.scoop.domain;

/**
 * Created by dwhelan on 14/02/2018.
 */
public class Hall {
    protected String id_;
    protected String name_;
    protected int seats_;

    public Hall() {}

    public void setId(String id) { id_ = id; }
    public void setName(String name) { name_ = name; }
    public void setSeats(int seats) { seats_ = seats; }

    public String getId() { return id_; }
    public String getName() { return name_; }
    public int getSeats() { return seats_; }
}

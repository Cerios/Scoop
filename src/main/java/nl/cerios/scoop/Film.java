package nl.cerios.scoop;

/**
 * Created by dwhelan on 08/02/2018.
 */
public class Film {
    protected String id_;
    protected String title_;
    protected String desc_;

    public Film(String id, String title, String desc) {
        id_ = id;
        title_ = title;
        desc_ = desc;
    }

    public String getId(){ return id_ ;}
    public String getTitle() { return title_; }
    public String getDesc() { return desc_; }
}

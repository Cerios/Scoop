package nl.cerios.scoop.domain;

import org.springframework.stereotype.Component;

/**
 * Created by dwhelan on 08/02/2018.
 */

@Component
public class Film  {
    protected String id_;
    private String title_;
    private String summary_;

    public Film() {}

    public void setId(String id) { id_ = id; }
    public void setTitle(String title) { title_ = title; }
    public void setSummary(String summary) { summary_ = summary; }

    public String getId(){ return id_ ;}
    public String getTitle() { return title_; }
    public String getSummary() { return summary_; }
}

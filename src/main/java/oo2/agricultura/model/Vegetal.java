package oo2.agricultura.model;

import javax.persistence.*;

@Entity
public class Vegetal extends Ingredient {

    @Column(name = "properties", nullable = false)
    private String  properties;

    @Column(name = "link_To_Wikipedia", nullable = false)
    private String linkToWikipedia;

    public Vegetal(String name, String properties, String linkToWikipedia) {
        super(name);
        this.linkToWikipedia = linkToWikipedia;
        this.properties = properties;
    }

    public Vegetal() {
    }

    public String getLinkToWikipedia() {
        return linkToWikipedia;
    }

    public void setLinkToWikipedia(String linkToWikipedia) {
        this.linkToWikipedia = linkToWikipedia;
    }


    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
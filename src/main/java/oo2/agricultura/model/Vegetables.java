package oo2.agricultura.model;

import javax.persistence.*;

@Table(name = "vegetables")
@Entity
public class Vegetables extends Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "properties", nullable = false)
    private String  properties;

    @Column(name = "link_to_wikipedia", nullable = false)
    private String linkToWikipedia;

    public Vegetables(String name, String properties, String linkToWikipedia) {
        super(name);
        this.linkToWikipedia = linkToWikipedia;
        this.properties = properties;
    }

    public Vegetables() {

    }

    public String getLinkToWikipedia() {
        return linkToWikipedia;
    }

    public void setLinkToWikipedia(String linkToWikipedia) {
        this.linkToWikipedia = linkToWikipedia;
    }

    public Vegetables(String s) {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
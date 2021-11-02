package oo2.agricultura.model;

import javax.persistence.*;

@Table(name = "vegetables")
@Entity
public class Vegetal extends Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "properties", nullable = false)
    private String  properties;

    @Column(name = "linkToWikipedia", nullable = false)
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
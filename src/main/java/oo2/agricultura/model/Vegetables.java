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

    public Vegetables(String name, String properties) {
        super(name);
        this.properties = properties;
    }

    public Vegetables() {

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
package de.htw.webtech.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String frontInformation;
    private String backInformation;

    public Card() {}


    public Card(String frontInformation, String backInformation) {
        this.frontInformation = frontInformation;
        this.backInformation = backInformation;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrontInformation() {
        return frontInformation;
    }

    public String getBackInformation() {
        return backInformation;
    }

    public void setFrontInformation(String frontInformation) {
        this.frontInformation = frontInformation;
    }

    public void setBackInformation(String backInformation) {
        this.backInformation = backInformation;
    }

}

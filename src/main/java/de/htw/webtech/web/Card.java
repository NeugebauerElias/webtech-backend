package de.htw.webtech.web;

import javax.persistence.*;

@Entity
public class Card {
//Karteikarte
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String frontInformation;

    @Column(nullable = false)
    private String backInformation;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Album album;

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

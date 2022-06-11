package de.htw.webtech.web;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Card> cards;

    public Album(String name) {
        this.name = name;
    }
    public Album() {}

    public Long getAlbumId() {
        return albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}

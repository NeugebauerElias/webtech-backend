package de.htw.webtech.web;

import java.util.ArrayList;
import java.util.List;

public class Album {

    int albumID;
    String albumName;
    List<Card> cardList;

    public Album(String albumName) {
        this.albumName = albumName;
        cardList = new ArrayList<>();
    }
}

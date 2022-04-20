package de.htw.webtech.web;

public class Card {

    private int id;
    private String frontInformation;
    private String backInformation;

    public Card(String frontInformation, String backInformation) {
        this.frontInformation = frontInformation;
        this.backInformation = backInformation;
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

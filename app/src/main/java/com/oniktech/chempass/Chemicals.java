package com.oniktech.chempass;

/**
 * Created by KinoDe on 12/4/2016.
 */

public class Chemicals {

    private int id;
    private String chemical;

    //Constructor
    public Chemicals(String chemical, int id) {
        this.chemical = chemical;
        this.id = id;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChemical() {
        return chemical;
    }

    public void setChemical(String chemical) {
        this.chemical = chemical;
    }
}

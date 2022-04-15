package com.example.alchemillafx;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Profile implements Serializable {

    private String name;
    private LinkedList<Plant> plants;
    private Calendar startDate;

    public Profile(String name, Calendar startDate) {
        name = name;
        plants = new LinkedList<>();
        startDate = startDate;
    }
    public Profile(String name, LinkedList<Plant> plants, Calendar startDate) {
        this.name = name;
        this.plants = plants;
        this.startDate = startDate;
    }
    public Profile(String name, LinkedList<Plant> plants) {
        this.name = name;
        this.plants = plants;
        this.startDate = new GregorianCalendar();
    }
    public Profile(String name){
        this.name = name;
        this.plants = new LinkedList<Plant>();
        this.startDate = new GregorianCalendar(); //initialized to today's date
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(LinkedList<Plant> plants) {
        this.plants = plants;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void addPlant(Plant plant){
        plants.add(plant);
    }


}

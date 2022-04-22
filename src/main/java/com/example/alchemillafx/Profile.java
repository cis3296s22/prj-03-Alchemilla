package com.example.alchemillafx;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Class for holding Profile information. Implements Serializable for convenient storage. Contains list of Plant objects
 */
public class Profile implements Serializable {
    private String name; //Name of Profile
    private LinkedList<Plant> plants; //List of Plant objects
    private Calendar startDate; //When to start schedule, used to calculate schedule

    /**
     * Constructor with empty plant list
     * @param name name of the Profile
     * @param startDate when to start schedule
     */
    public Profile(String name, Calendar startDate) {
        this.name = name;
        this.plants = new LinkedList<>();
        this.startDate = startDate;
    }

    /**
     * Full constructor
     * @param name name of Profile
     * @param plants List of plants to add initially
     * @param startDate when to start schedule
     */
    public Profile(String name, LinkedList<Plant> plants, Calendar startDate) {
        this.name = name;
        this.plants = plants;
        this.startDate = startDate;
    }

    /**
     * Constructor with only name
     * @param name name of Profile
     */
    public Profile(String name){
        this.name = name;
        this.plants = new LinkedList<Plant>();
        this.startDate = new GregorianCalendar(); //initialized to today's date
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * change profile name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get list of plants
     * @return LinkedList<Plant>
     */
    public LinkedList<Plant> getPlants() {
        return plants;
    }

    /**
     * Replace list of plants with another list of plants
     * @param plants LinkedList<Plant>
     */
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

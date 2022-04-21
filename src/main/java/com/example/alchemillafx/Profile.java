package com.example.alchemillafx;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Class for holding Profile information. Implements Serializable for convenient storage. Contains list of Plant objects
 */
public class Profile implements Serializable {
    /**Name of Profile*/
    private String name;
    /**List of Plant objects*/
    private LinkedList<Plant> plants;
    /**When to start schedule, used to calculate schedule*/
    private Calendar startDate;

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
     * @return name current profile name
     */
    public String getName() {
        return name;
    }

    /**
     * change profile name
     * @param name Set the name of the Profile (user wants to change their name)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get list of plants
     * @return LinkedList with nodes of type Plant
     */
    public LinkedList<Plant> getPlants() {
        return plants;
    }

    /**
     * Replace list of plants with another list of plants
     * @param plants LinkedList with nodes of type Plant
     */
    public void setPlants(LinkedList<Plant> plants) {
        this.plants = plants;
    }

    /**
     * When does this user want to start their schedule
     * @return Basic Calendar object
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * If user wants to change his schedule start date
     * @param startDate Must be a simple Calendar object
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * Add a plant object reference to this profile
     * @param plant must be a completed plant
     */
    public void addPlant(Plant plant){
        plants.add(plant);
    }


}

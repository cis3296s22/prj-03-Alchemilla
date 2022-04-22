/**
 * Integration Test Write-UP
 * How To Set Up:
 *  -check package import (might need to change name to conform to your directory structure)
 *  -run main in scratch. This will generate a Profile saved to a file
 *  -place this profile in root folder of your directory structure
 *  -there should be two jpg files in the ~/resources/plantPictures/ folder, azalea.jpg and pothos.jpg
 *  -add jpg files here to use as pictures if you wish, or reuse the same photos
 * Testing Steps:
 *  -launch program - you should see the ListView object populated with Azalea and Pothos
 *  -click each, you should see the other panels populate
 *  -you can use this script to add new plant objects and test different profile configurations
 * Tested:
 *  -one plant
 *  -two plant
 *  -three plant
 *  -dynamically populating gui with info from many plant objects
 *  -change picture displayed based on plant selected
 *  -change order of plants
 *  -arbitrarily large text in description panel
 *  -over and undersized photos in the plantImage panel
 *  -copy and paste text produced into scene
 *  -close scene with [x] button
 *  -launch multiple instances of the program simultaneously
 *  -alter profile information and repopulate scene
 */

package com.example.alchemillafx;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

class Scratch {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Profile joe = new Profile("Joe Schmoe",Calendar.getInstance());

        Plant azalea = new Plant("/plantPictures/azalea.jpg","Azalea",2,2,"food","Water lightly every two days. This plant prefers a lot of sunlight and is preferably an outdoor plant","Azalea flowers are funnel-shaped, somewhat two-lipped, and often fragrant. Flowers of rhododendrons, on the other hand, are more often bell-shaped. Azalea flowers typically have only 5 projecting stamens, as compared with 10 (or more) in rhododendrons.");
        Plant pathos = new Plant("/plantPictures/pothos.jpg","Pothos",3,2,"food","Water lightly every two days. This plant prefers a lot of sunlight and is preferably an outdoor plant","Pothos is an evergreen plant with thick, waxy, green, heart-shaped leaves with splashes of yellow. As a houseplant, it is commonly grown as a hanging plant. Pothos can climb by means of aerial roots, and wild or cultivated plants grown outdoors can reach enormous heights using tall trees as support.");

        System.out.println(azalea.getPlantName());
        System.out.println(pathos);

        joe.addPlant(azalea);
        joe.addPlant(pathos);

        File f = new File("joe");
        f.createNewFile();

        SerializeClassData sc = new SerializeClassData();
        sc.storeProfile("./joe",joe);

        Profile anotherJoe = sc.getProfile("./joe");

        LinkedList<Plant> p = anotherJoe.getPlants();
        Iterator i = p.iterator();
        while(i.hasNext()){
            Plant plant = (Plant) i.next();
            System.out.println(plant.getDescription());
        }
    }
}
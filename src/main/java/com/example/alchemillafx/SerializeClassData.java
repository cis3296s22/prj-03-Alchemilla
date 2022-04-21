package com.example.alchemillafx;

import java.io.*;

/**
 *  Wrapper for Java Standard Lib object storage classes.
 *  Currently, wraps for Profile and Plant classes.
 */
public class SerializeClassData {
/**
    Here is an example of a path to send.

    String plantPath = "src/main/resources/plantPictures/plant.ext";

**/
    /**
     * Adapter for retrieving a previously stored Plant. Handles casting back to profile for convenience
     * @param path Where Plant is located (relative path, should just be name of Plant object)
     * @return The Plant object, properly cast and ready to use.
     * @throws IOException can't access file
     * @throws ClassNotFoundException can't find class in file requested
     */
    public Plant getPlant(String path) throws IOException, ClassNotFoundException {

        return (Plant)retrieveObject(path);
    }

    /**
     * Adapter for storing a Profile as a generic object, using adapter method for ObjectOutputStream below
     * @param path relative path to store profile. Should just be profile object name
     * @param p The profile to be stored
     * @return true on successful write
     */
    public boolean storeProfile(String path, Profile p){
        return storeObject(path, p);
    }

    /**
     * Adapter for retrieving a previously stored profile. Handles casting back to profile for convenience
     * @param path Where profile is located (relative path, should just be name of profile object)
     * @return The Profile object, properly cast and ready to use.
     * @throws IOException can't access file
     * @throws ClassNotFoundException can't find class in file requested
     */
    public Profile getProfile(String path) throws IOException, ClassNotFoundException {

        return (Profile)retrieveObject(path);
    }

    /**
     * adapter to store plant objects without needing to cast
     * @param path where to store plant
     * @param plant Plant object to be stored
     * @return true on success
     */
    public boolean storePlant(String path, Plant plant){
        return storeObject(path, plant);
    }


    /**
     * Generalized adapter method for the ObjectInputStream class. Use to retrieve stored Object data
     * @param path Where the object is located, relative path
     * @return A general Object to be cast to the actual Object
     * @throws IOException If file not found
     * @throws ClassNotFoundException If file is not a true class file
     */
    private Object retrieveObject(String path) throws IOException, ClassNotFoundException {
        FileInputStream fs = new FileInputStream(path);
        ObjectInputStream is = new ObjectInputStream(fs);
        return is.readObject();
    }

    /**
     * Generalized adapter method for the ObjectOutputStream class. Use to store Object data
     * @param path Where to store the object, relative path
     * @param ob Object to be stored
     * @return true on successful write
     */
    private boolean storeObject(String path, Object ob){

        try {
            File f = new File(path);
            f.createNewFile();
            FileOutputStream fs = new FileOutputStream(path);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(ob);

        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}

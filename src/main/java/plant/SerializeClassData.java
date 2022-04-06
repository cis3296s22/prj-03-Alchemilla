package plant;

import java.io.*;

/**
 *  Wrapper for Java Standard Lib object storage classes.
 *  Currently, wraps for Profile and Plant classes.
 */
public class SerializeClassData {
/**
    Here is an example of a path to send.

    String plantPath = "src/main/resources/data/plant.txt";

**/
    //TODO add exception handling
    public Plant getPlant(String path) throws IOException, ClassNotFoundException {

        return (Plant)retrieveObject(path);
    }


    public boolean storeProfile(String path, Plant plant){
        return storeObject(path, plant);
    }
    //TODO add exception handling
    public Profile getProfile(String path) throws IOException, ClassNotFoundException {

        return (Profile)retrieveObject(path);
    }


    public boolean storePlant(String path, Plant plant){
        return storeObject(path, plant);
    }



    private Object retrieveObject(String path) throws IOException, ClassNotFoundException {
        FileInputStream fs = new FileInputStream(path);
        ObjectInputStream is = new ObjectInputStream(fs);
        return is.readObject();
    }

    private boolean storeObject(String path, Object ob){

        try {

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

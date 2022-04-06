package plant;


import org.junit.jupiter.api.Test;

import java.io.*;

public class TestClass {



    @Test
    public void openFileTest() throws IOException, ClassNotFoundException {
/**
        Plant test = new Plant(null, "test plant",2,2,"calcium","this is only a test","this test plant has strong bones");
        SerializeClassData.writeToFile(new File("src/main/resources/data/plant.txt"),test);
        Plant another = (Plant) SerializeClassData.readFromFile(new File("src/main/resources/data/plant.txt"));
        System.out.println(another.getDescription());


 **/
        Plant test = new Plant(null, "test plant",2,2,"calcium","this is only a test","this test plant has strong bones");

        String plantPath = "src/main/resources/data/plant.txt";
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(plantPath));

        os.writeObject(test);

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(plantPath));

        Plant another = (Plant) is.readObject();
        System.out.println(another);
        System.out.println(another.getDescription());
        System.out.println(another.getInstructions());
    }




}

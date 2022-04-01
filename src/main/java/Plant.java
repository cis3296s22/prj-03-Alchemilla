import java.awt.image.BufferedImage;

public class Plant {
    private BufferedImage plantImage;
    private String plantName;
    private Integer waterDelta;
    private Integer foodDelta;
    private String food;
    private String instructions;
    private String description;


    public Plant(
            BufferedImage plantImage,
            String plantName,
            Integer waterDelta,
            Integer foodDelta,
            String food,
            String instructions,
            String description) {
        this.plantImage = plantImage;
        this.plantName = plantName;
        this.waterDelta = waterDelta;
        this.foodDelta = foodDelta;
        this.food = food;
        this.instructions = instructions;
        this.description = description;
    }


    public String getInstructions() {
        return instructions;
    }

    public String getDescription() {
        return description;
    }

    public BufferedImage getPlantImage() {
        return plantImage;
    }

    public String getPlantName() {
        return plantName;
    }

    public Integer getWaterDelta() {
        return waterDelta;
    }

    public Integer getFoodDelta() {
        return foodDelta;
    }

    public String getFood() {
        return food;
    }
}

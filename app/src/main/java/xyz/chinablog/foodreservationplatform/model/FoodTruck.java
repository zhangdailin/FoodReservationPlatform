package xyz.chinablog.foodreservationplatform.model;

/**
 * Created by Administrator on 2018/2/21.
 */

public class FoodTruck {

    private String id = "";
    private String name="";
    private String foodType="";
    private Double avgCost=0.0;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFoodType() {
        return foodType;
    }

    public Double getAvgCost() {
        return avgCost;
    }



    public FoodTruck(String id, String name, String foodType, Double avgCost) {
        this.id = id;
        this.name = name;
        this.foodType = foodType;
        this.avgCost = avgCost;
    }
}

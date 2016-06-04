package entity;

/**
 * Created by marutsingh on 5/22/16.
 */
public class Car {

    private String color;
    private String brand;
    private String model;
    private float cost;

    public Car(){}

    public Car(String color,String brand,float cost){
        this.color = color;
        this.brand = brand;
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }


    public void print(){
        System.out.println(this);
    }
}

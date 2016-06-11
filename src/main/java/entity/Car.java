package entity;

/**
 * Created by marutsingh on 5/22/16.
 */
public class Car implements Comparable<Car> {

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

    public boolean isSameBrand(String brand) {
        return brand.equals(this.brand);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (!brand.equals(car.brand)) return false;
        if (!color.equals(car.color)) return false;
        if (!model.equals(car.model)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }

    public void print(){
        System.out.println(this);
    }

    @Override
    public int compareTo(Car o) {
        return o.getBrand().compareTo(this.getBrand());
    }
}

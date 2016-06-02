package class1.filtering;

import entity.Car;

import java.util.List;

/**
 * Created by marutsingh on 5/22/16.
 */
public class NormalFiltering {

    public static void filterByBrand(List<Car> carList,String brand){
        for (Car car : carList){
            if (car.getBrand().equals(brand)){
                System.out.println(car);
            }
        }
    }

    public static void filterByColor(List<Car> carList,String color){
        for (Car car : carList){
            if (car.getColor().equals(color)){
                System.out.println(car);
            }
        }
    }
}

package class1.filtering;

import entity.Car;

import java.util.List;

/**
 * Created by marutsingh on 5/22/16.
 */
public class StreamFiltering2 {
    public static void filterByBrand(List<Car> carList,String brand){
        carList.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .forEach(car -> car.print());
    }

    public static void filterByColor(List<Car> carList,String color){
        carList.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .forEach(car -> car.print());
    }
}

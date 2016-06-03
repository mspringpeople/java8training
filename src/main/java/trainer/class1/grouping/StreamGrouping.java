package trainer.class1.grouping;

import entity.Car;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by marutsingh on 5/23/16.
 */
public class StreamGrouping {

    public static Map<String,List<Car>> getCarListGroupedByBrand(List<Car> carList){
        return  carList.stream()
                .collect(Collectors.groupingBy(Car::getBrand));
    }

    public static Map<String,Double> calculateCostByBrand(List<Car> carList){
        return  carList.stream()
                .collect(Collectors.groupingBy(Car::getBrand, Collectors.summingDouble(Car::getCost)));
    }
}

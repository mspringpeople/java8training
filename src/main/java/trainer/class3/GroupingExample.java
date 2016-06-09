package trainer.class3;

import entity.Car;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by marutsingh on 6/6/16.
 */
public class GroupingExample {

    public Map<String,List<Car>> groupCarsByBrand(List<Car> carList){
       return carList.stream().collect(Collectors.groupingBy(Car::getBrand));
    }

    public Map<String,Map<String,List<Car>>> groupCarsByBrandAndColor(List<Car> carList){
        return carList.stream().collect(Collectors.groupingBy(Car::getBrand,Collectors.groupingBy(Car::getColor)));
    }
}

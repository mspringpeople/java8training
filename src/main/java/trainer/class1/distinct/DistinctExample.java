package trainer.class1.distinct;

import entity.Car;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by marutsingh on 6/2/16.
 */
public class DistinctExample {

    public static List<String> getDistinctBrands(List<Car> carList){
       return carList.stream().map(c -> c.getBrand()).distinct().collect(Collectors.toList());
    }
}

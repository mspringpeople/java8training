package trainer.class2.core.optional;

import entity.Car;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by marutsingh on 6/2/16.
 */
public class OptionalExample {

    public Optional<Car> findCar(List<Car> carList, String brand){

        List<Car> findCarList = carList.stream().filter(c -> c.getBrand().equals(brand))
                .collect(Collectors.toList());

        return findCarList.isEmpty() ? Optional.empty() : Optional.of(findCarList.get(0));
    }

    public static Float getSumOfCost(List<Car> carList){
        Optional<Float> totalCost = carList.stream().map(Car::getCost).reduce((i,j) -> i+j);
        return totalCost.get();
    }
}

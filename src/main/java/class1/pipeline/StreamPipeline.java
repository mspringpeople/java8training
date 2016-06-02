package class1.pipeline;

import entity.Car;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by marutsingh on 5/23/16.
 */
public class StreamPipeline {

    public static List<Car> getSortedCarList(List<Car> carList){
        return carList.stream()
                //Sort by Brand
                .sorted(new Comparator<Car>() {
                    @Override
                    public int compare(Car o1, Car o2) {
                        return o1.getBrand().compareTo(o2.getBrand());
                    }
                })
                .collect(Collectors.toList());
    }

    public static List<Car> getCarListByColorAndBrand(List<Car> carList,String color,String brand){
        return carList.stream()
                //Filter By Color
                .filter(car -> car.getColor().equals(color))
                 //Filter by Brand
                .filter(car -> car.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    public static List<Car> getSortedCarListForSpecificColor(List<Car> carList,String color){
        return carList.stream()
                //Filter By Color
                .filter(car -> car.getColor().equals(color))
                        //Group by Brand
                .sorted(new Comparator<Car>() {
                    @Override
                    public int compare(Car o1, Car o2) {
                        return o1.getBrand().compareTo(o2.getBrand());
                    }
                }).collect(Collectors.toList());
    }


    public static Float getSumOfCost(List<Car> carList,String brand){
        Optional<Float> totalCost = carList.stream()
                .filter(car -> car.getBrand().equals(brand))
                .map(car -> car.getCost())
                .reduce((i,j) -> i+j);
        return totalCost.get();
    }
}

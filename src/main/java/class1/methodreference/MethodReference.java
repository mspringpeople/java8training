package class1.methodreference;

import entity.Car;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by marutsingh on 5/23/16.
 */
public class MethodReference {

    public static void callByReference1(List<Car> carList){
        carList.stream()
                .map(Car::getBrand).forEach(System.out::println);
    }

    public static void callByReference2(List<Car> carList){
        carList.stream()
                .forEach(Car::getBrand);
    }


    /**
     * Sort by method reference
     * @param carList
     * @return
     */
    public static Map<String,List<Car>> getCarListSortedByBrand(List<Car> carList){
        return  carList.stream()
                //Sort by Brand
                .sorted(Comparator.comparing(Car::getBrand)) //Method Reference
                .collect(Collectors.groupingBy(Car::getBrand));
    }
}

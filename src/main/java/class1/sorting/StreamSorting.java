package class1.sorting;

import entity.Car;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by marutsingh on 5/24/16.
 */
public class StreamSorting {

    public static List<Car> getCarListSortedByBrand(List<Car> carList){
        return  carList.stream()
                //Sort by Brand
                .sorted((c1,c2) -> {
                        return c1.getBrand().compareTo(c2.getBrand());
                }).collect(Collectors.toList());
    }

    public static void sortInts(){
        new Random().ints().limit(10).sorted().forEach(rand -> System.out.println(rand));
    }
}

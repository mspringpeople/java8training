package trainer.class1.filtering;

import entity.Car;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by marutsingh on 5/22/16.
 */
public class StreamFiltering1 {

    public static void filterByBrand(List<Car> carList,String brand){
        filterCars(carList,EmployeePredicates.colorFilter(brand));
    }

    public static void filterByColor(List<Car> carList,String color){
        filterCars(carList,EmployeePredicates.colorFilter(color));
    }

    public static void filterCars(List<Car> carList,Predicate<Car> predicate) {
        carList.stream()
                .filter(predicate)
                .forEach(car -> car.print());
    }

    public static class EmployeePredicates
    {
        public static Predicate<Car> barFilter(String brand) {
            return car -> car.getBrand().equals(brand);
        }

        public static Predicate<Car> colorFilter(String brand) {
            return car -> car.getColor().equals(brand);
        }
    }
}

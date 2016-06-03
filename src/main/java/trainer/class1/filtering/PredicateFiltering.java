package trainer.class1.filtering;

import entity.Car;

import java.util.List;

/**
 * Created by marutsingh on 5/22/16.
 */
public class PredicateFiltering {

    public static void filter(List<Car> carList,CarFilterStrategy carFilterStrategy,String param){
        for (Car car : carList){
            if (carFilterStrategy.filter(car,param)){
                car.print();
            }
        }
    }

    public static void filterByBrand(List<Car> carList,String brand){
        filter(carList, new BrandFilterStrategy(),brand);
    }

//    public static void filterByBrand(List<Car> carList,String brand){
//        filter(carList, new CarFilterStrategy() {
//            @Override
//            public boolean filter(Car car, String param) {
//                return car.getBrand().equals(brand);
//            }
//        }, brand);
//    }

    public static void filterByColor(List<Car> carList,String color){
        filter(carList, new ColorFilterStrategy(),color);
    }

    public static interface CarFilterStrategy{
        boolean filter(Car car,String param);
    }

    /**
     * Encapsulates the logic to filter by brand
     */
    public static class BrandFilterStrategy implements CarFilterStrategy{

        @Override
        public boolean filter(Car car, String param) {
            return car.getBrand().equals(param);
        }
    }

    public static class ColorFilterStrategy implements CarFilterStrategy{

        @Override
        public boolean filter(Car car, String param) {
            return car.getColor().equals(param);
        }
    }
}

package trainer.class1.filtering;

import entity.Car;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by marutsingh on 5/22/16.
 */
public class StreamFiltering2 {
    /**
     * Filter all cars for a particular brand
     * @param carList
     * @param brand
     */
    public static void filterByBrand(List<Car> carList,String brand){
        List<Car> newCarList = new ArrayList<>();
        newCarList.add(new Car());

        Stream<Car> originalStream = carList.stream();

        Stream<Car> filteredStream = originalStream
                .filter(car -> {
                    newCarList.add(car); //WARNING: Don't do this ..against functional programming principles
                    Boolean isSameBrand = car.getBrand().equals(brand);
                    return isSameBrand;
                });


        filteredStream
                .forEach(car -> {
                    System.out.println(car.toString());
                    System.out.print("New Line");
                });

        //WARNING: This is not allowed...Stream has already been operated upon
        filteredStream
                .forEach(car -> {
                    System.out.println(car.toString());
                    System.out.print("New Line");
                 });


    }

    public static void  main(String[] args){
        List<Car> carList = new ArrayList<>();

        Optional<Car> findMyCar = findCarByBrand(carList,"BMW");
        if (findMyCar.isPresent()){
            Car findCar = findMyCar.get();
        }

        carList.add(createCar("BMW"));
        carList.add(createCar("Jaguar"));
        carList.add(createCar("Fiat"));
        carList.add(createCar("GM"));
        carList.add(createCar("BMW"));
        carList.forEach(c -> c.print());
        System.out.println("*********Sorted List**********");

        List<String> upperCaseBrandsList = new ArrayList<>();
        for (Car car : carList){
            if (true){
                upperCaseBrandsList.add(car.getBrand().toUpperCase());
            }
        }

        carList.stream().sorted((o1,o2) -> o1.getBrand().compareTo(o2.getBrand())).forEach(c -> c.print());

        Map<String,Car> brandsCarMap = new HashMap<>();
        brandsCarMap.put("BMW", carList.get(0));


        brandsCarMap.forEach((brand,car) -> car.print());

        filterByBrand(carList,"BMW");
    }

    public static Car createCar(String brand){
        Car newCar = new Car();
        newCar.setBrand(brand);
        return newCar;
    }

    /**
     * Paginates the given list
     * @param start
     * @param numberOfElementsPerPage
     * @return
     */
    public static List<Car> paginate(int start, int numberOfElementsPerPage){
        List<Car> carList = new ArrayList<>();
        //
        return carList.stream()
                .skip(start)
                .limit(numberOfElementsPerPage)
                .collect(Collectors.toList());
    }

    public static Map<String,List<Car>> getCarListGroupedByBrand(List<Car> carList){
        return  carList.stream() //Get the original stream
                .collect(Collectors.groupingBy(Car::getBrand));
    }

    public static Map<String,Map<String,List<Car>>> getCarListGroupedByBrandAndColor(List<Car> carList){

        Map<String,List<Car>> carByBrand;

        Map<String,Map<String,List<Car>>> groupByBrandAndColor;

        groupByBrandAndColor =
                carList.stream().collect(Collectors.groupingBy(Car::getBrand,Collectors.groupingBy(Car::getColor)));

        return groupByBrandAndColor;
    }

    /**
     * Returns a car whose brand name is equal to brand
     * May return null
     * @param carList
     * @param brand
     * @return
     */
    public static Optional<Car> findCarByBrand(List<Car> carList,String brand){
        Optional<Car> findCar = Optional.empty();
        for (Car car : carList){
            if (car.equals(brand)){
                findCar =  Optional.of(car);
                break;
            }
        }
        return  findCar;
    }

    public static Optional<Car> filterByColor(List<Car> carList,String color){
        return carList.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .findFirst();
    }

//    static class MyThread implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println("My Thread is running");
//        }
//    }
}

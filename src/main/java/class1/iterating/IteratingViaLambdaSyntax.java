package class1.iterating;

import entity.Car;

import java.util.List;
import java.util.Random;

/**
 * Created by marutsingh on 5/22/16.
 */
public class IteratingViaLambdaSyntax {

    public static void printCars(List<Car> carList){
        //carList.forEach((Car car) -> car.print());
        carList.forEach(car -> {
            car.print();
        });
    }

    public static void printInts(){
        new Random().ints().limit(10).forEach(rand -> System.out.println(rand));
    }

}

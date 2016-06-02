package class1;

import class1.iterating.IteratingViaLambdaSyntax;
import entity.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by marutsingh on 5/31/16.
 */
public class Java8Training {
    public static void main(String[] args){
        List<Car> carList = new ArrayList<>();
        IteratingViaLambdaSyntax.printInts();
    }

    static List<Car> getDummyData(){

        String[] colors = {"Black","White","Blue","Red","Green"};
        String[] brands = {"Maruti","Nissan","Skoda","Mahindra","Volkswagen"};

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < 100 ; i++){
            Car car = new Car();
            Random random = new Random();
            car.setBrand(brands[random.nextInt(4)]);
            car.setColor(colors[random.nextInt(4)]);
            carList.add(car);
        }

        return carList;
    }
}

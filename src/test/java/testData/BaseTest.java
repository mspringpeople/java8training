package testData;

import entity.Car;
import org.junit.Before;

import java.util.*;

/**
 * Created by marutsingh on 5/23/16.
 */
public class BaseTest {

    protected List<Car> carList = new ArrayList<>();
    protected String[] colors = {"Black","White","Blue","Red","Green"};
    protected String[] brands = {"Maruti","Nissan","Skoda","Mahindra","Volkswagen"};
    protected Map<String,String> brandModelMap = new HashMap<>();

    protected List<Car> userList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        for (int i = 0; i < 100 ; i++){
            Car car = new Car();
            Random random = new Random();
            car.setBrand(brands[random.nextInt(4)]);
            car.setColor(colors[random.nextInt(4)]);
            carList.add(car);
        }


    }

    public void setUp2() throws Exception {
        for (int i = 0; i < 100 ; i++){
            Car car = new Car();
            Random random = new Random();
            car.setBrand(brands[random.nextInt(4)]);
            car.setColor(colors[random.nextInt(4)]);
            carList.add(car);
        }
    }
}

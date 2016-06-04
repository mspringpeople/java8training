package testData;

import entity.Car;
import entity.User;
import org.junit.Before;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by marutsingh on 5/23/16.
 */
public class BaseTest {

    protected List<Car> carList = new ArrayList<>();
    protected List<User> usersList = new ArrayList<>();
    protected String[] colors = {"Black","White","Blue","Red","Green"};
    protected String[] brands = {"Maruti","Nissan","Skoda","Mahindra","Volkswagen"};
    protected Integer[] phones = {121,122,123,124,125,221,222,223,224,225};
    protected Map<String,String> brandModelMap = new HashMap<>();

    protected List<Car> userList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        carList = IntStream.range(0, brands.length)
                .mapToObj(i -> {
                    Car car = new Car(colors[i],brands[i],1000f);
                    car.setBrand(brands[i]);
                    car.setColor(colors[i]);
                    return car;
                })
                .collect(Collectors.toList());

        usersList = IntStream.range(1, 10).mapToObj(i -> {
            User user = new User();
            user.setName("User" + Integer.toString(i));
            user.setPhone(phones[i]);
            return user;
        }).collect(Collectors.toList());
    }
}

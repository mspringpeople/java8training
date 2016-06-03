package testData;

import entity.Car;
import entity.User;
import org.junit.Before;

import java.util.*;

/**
 * Created by marutsingh on 5/23/16.
 */
public class BaseTest {

    protected List<Car> carList = new ArrayList<>();
    protected String[] colors = {"Black","White","Blue","Red","Green"};
    protected String[] brands = {"Maruti","Nissan","Skoda","Mahindra","Volkswagen"};
    protected Integer[] phones = {121,122,123,124,125,221,222,223,224,225};
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
        Random randomGenerator = new Random();
        //Functional way
        Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().map(i -> {
            User user = new User();
            user.setName("User" + Integer.toString(i));
            user.setPhone(phones[i]);
            return user;
        });
    }
}

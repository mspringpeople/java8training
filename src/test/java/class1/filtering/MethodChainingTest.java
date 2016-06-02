package class1.filtering;

import class1.chaining.MethodChaining;
import org.junit.Before;
import org.junit.Test;
import testData.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class MethodChainingTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
       super.setUp();
    }


    @Test
    public void testMethodChaining1() throws Exception {
        List<String> carNames = new ArrayList<>();
        carNames.add(" Maruti 800 ");
        carNames.add(" Nissan Terrano ");
        MethodChaining.methodChaining1(carNames);
    }
}
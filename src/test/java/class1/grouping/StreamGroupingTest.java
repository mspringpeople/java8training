package class1.grouping;

import entity.Car;
import org.junit.Test;
import testData.BaseTest;

import static org.junit.Assert.*;

public class StreamGroupingTest extends BaseTest{

    @Test
    public void testGetCarListGroupedByBrand() throws Exception {
        StreamGrouping.calculateCostByBrand(carList);
    }

    @Test
    public void testCalculateCostByBrand() throws Exception {
        StreamGrouping.calculateCostByBrand(carList).forEach((key, value) ->
                System.out.println(String.format("%s[%d]", key, value)));
    }
}
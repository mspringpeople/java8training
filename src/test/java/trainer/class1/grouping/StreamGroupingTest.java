package trainer.class1.grouping;

import org.junit.Test;
import testData.BaseTest;

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
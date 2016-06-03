package trainer.class1.pipeline;

import entity.Car;
import org.junit.Test;
import testData.BaseTest;

import java.util.List;

public class StreamPipelineTest extends BaseTest {

    @Test
    public void testGetSortedCarListForSpecificColor() throws Exception {
       List<Car> sortedFilteredSet = StreamPipeline.getSortedCarListForSpecificColor(carList,"Black");
       sortedFilteredSet.stream().forEach(c -> c.print());
        assert true;
    }

    @Test
    public void testGetSortedCarList() throws Exception {
        List<Car> sortedFilteredSet = StreamPipeline.getSortedCarList(carList);
        sortedFilteredSet.stream().forEach(c -> c.print());
        assert true;
    }
}
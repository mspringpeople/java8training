package trainer.class1.filtering;

import trainer.class1.methodreference.MethodReference;
import org.junit.Test;
import testData.BaseTest;

public class MethodReferenceTest extends BaseTest {

    @Test
    public void testCallByReference1() throws Exception {
        MethodReference.callByReference1(carList);
        assert true;
    }

    @Test
    public void testCallByReference2() throws Exception {
        MethodReference.callByReference2(carList);
        assert true;
    }
}
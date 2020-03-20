package utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.idealista.infrastructure.utils.ClosedInterval;

@RunWith(Parameterized.class)
public class ClosedIntervalParametrizedWithoutConstructorTest {

    @Parameter(0) public Integer OUTMin;
    @Parameter(1) public Integer OUTMax;

    @Parameter(2) public Integer value;

    @Parameter(3) public boolean expectedIncludedValue;

    @Parameters(name="{index}: [{0}, {1}] includes {2} : {3}")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { 0, 100, -1, false},
                        { 0, 100, 0, true},
                        { 0, 100, 100, true} });
    }

    private ClosedInterval OUTClosedInterval;

    @Before
    public void before() {
        OUTClosedInterval = new ClosedInterval(OUTMin, OUTMax);
    }

    @Test
    public void testIncludesValue() {
        boolean resultIncludedValue = OUTClosedInterval.includes(value);
        assertEquals(expectedIncludedValue, resultIncludedValue);
    }

}

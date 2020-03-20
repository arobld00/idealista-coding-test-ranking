package utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import com.idealista.infrastructure.utils.WordCounter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WordCounterParametrizedWithoutConstructorTest {

    @Parameter(0) public String OUTText;

    @Parameter(1) public Integer expectedCountValue;

    @Parameters(name="{index}: {0} expected: {1}")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { "Este piso", 2},
                        { "COMPRA!!!!!", 1},
                        { "Reformado, parece nuevo", 3},
                        { "", 0}});
    }

    private WordCounter OUTWordCounter;

    @Before
    public void before() {
        OUTWordCounter = new WordCounter(OUTText);
    }

    @Test
    public void testGetCount() {
        Integer resultGetCount = OUTWordCounter.getCount();
        assertEquals(expectedCountValue, resultGetCount);
    }

}

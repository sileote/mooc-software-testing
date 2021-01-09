package tudelft.chocolate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.roman.RomanNumeralTS;

import java.util.Formatter;

public class ChocolateBagsTestTS {
    private ChocolateBagsTS cb;

    @BeforeEach
    public void initialize() {
        this.cb = new ChocolateBagsTS();
    }

    @ParameterizedTest
    @CsvSource({"10,3,1,-1", "10,4,1,-1","10,5,1,5","10,6,1,5","10,3,1,-1","9,3,1,-1","8,3,1,3","7,3,1,2"} )
    public void notEnoughToFill(int size, int small, int big, int expected) {
        int actual = cb.smallBarCount(size, small, big);
        Assertions.assertEquals(expected, actual,
                String.format("Expected value of %d does not equal actual value of %d for %d,%d,%d", expected, actual, size, small, big));
    }

    @ParameterizedTest
    @CsvSource({"10,3,0,-1","10,3,1,-1","10,3,2,0","10,3,3,0","12,3,2,2","11,3,2,1","10,3,2,0","9,3,2,-1","8,3,2,3"} )
    public void bigEvenlyFill(int size, int small, int big, int expected) {
        int actual = cb.smallBarCount(size, small, big);
        Assertions.assertEquals(expected, actual,
                String.format("Expected value of %d does not equal actual value of %d for %d,%d,%d", expected, actual, size, small, big));
    }

    @ParameterizedTest(name = "Big And Small: size={0}, small={1}, big={2}, expected={3}")
    @CsvSource({"10,3,1,-1","9,3,1,-1","8,3,1,3","7,3,1,2", "14,3,2,-1","13,3,2,3","12,3,2,2"} )
    public void bigAndSmall(int size, int small, int big, int expected) {
        int actual = cb.smallBarCount(size, small, big);
        Assertions.assertEquals(expected, actual,
                String.format("Expected value of %d does not equal actual value of %d for %d,%d,%d", expected, actual, size, small, big));
    }

    @ParameterizedTest
    @CsvSource({"5,4,0,-1","5,5,0,5","5,6,0,5","6,4,0,-1","4,4,0,4","3,4,0,3"} )
    public void onlySmall(int size, int small, int big, int expected) {
        int actual = cb.smallBarCount(size, small, big);
        Assertions.assertEquals(expected, actual,
                String.format("Expected value of %d does not equal actual value of %d for %d,%d,%d", expected, actual, size, small, big));
    }
}

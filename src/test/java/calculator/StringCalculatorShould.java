import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class StringCalculatorTest {

    private StringCalculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        calculator = new StringCalculator();
    }

    @Test
    public void empty_String_Should_Return_0() {
        assertEquals(calculator.add(""), 0);
    }

    @Test
     void string_with_single_number_should_return_number_as_int()() {
        assertEquals(calculator.add("1"), 1);
        assertEquals(calculator.add("5"), 5);
    }

    @Test
    public void numbers_Comma_Delimited_Should_BeSummed() {
        assertEquals(calculator.add("1,2"), 3);
        assertEquals(25, calculator.add("10,15"));
    }

    @Test
    public void numbers_Newline_Delimited_Should_Be_Summed() {
        assertEquals(calculator.add("1\n2"), 3);
        assertEquals(calculator.add("11\n13"), 24);
    }

    @Test
    public void three_Numbers_Delimited_Anyway_Should_Be_Summed() {
        assertEquals(calculator.add("1,2,3"), 6);
        assertEquals(calculator.add("5\n2\n3"), 10);
    }

    @Test
    public void negative_Input_Returns_Exception() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negative input!");
        calculator.add("-1");
        calculator.add("-5,10\n-15");
    }

    @Test
    public void numbers_Greater_Than_1000_Are_Ignored() {
        assertEquals(calculator.add("5,12,1001"), 17);
        assertEquals(calculator.add("14124,22\n4,1214"), 26);
    }
}

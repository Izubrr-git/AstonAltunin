import lesson12_testng.Factorial;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        Factorial factorial = new Factorial();
        assertEquals(factorial.calculate(0), 1, "Factorial of 0 should be 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Factorial factorial = new Factorial();
        assertEquals(factorial.calculate(5), 120, "Factorial of 5 should be 120");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Number must be non-negative.")
    public void testFactorialOfNegativeNumber() {
        Factorial factorial = new Factorial();
        factorial.calculate(-1);
    }
}




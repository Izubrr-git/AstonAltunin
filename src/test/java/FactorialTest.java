import lesson12_junit_5.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        Factorial factorial = new Factorial();
        assertEquals(1, factorial.calculate(0), "Factorial of 0 should be 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Factorial factorial = new Factorial();
        assertEquals(120, factorial.calculate(5), "Factorial of 5 should be 120");
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Factorial factorial = new Factorial();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> factorial.calculate(-1));
        assertEquals("Number must be non-negative.", exception.getMessage());
    }
}


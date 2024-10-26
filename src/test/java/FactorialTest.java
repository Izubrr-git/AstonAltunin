import lesson12_junit_5.Factorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    Factorial factorial;
    @BeforeEach
    public void setUp() {
        factorial = new Factorial();
    }

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, factorial.calculate(0), "Factorial of 0 should be 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, factorial.calculate(5), "Factorial of 5 should be 120");
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> factorial.calculate(-1));
        assertEquals("Number must be non-negative.", exception.getMessage());
    }
}


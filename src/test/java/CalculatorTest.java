import org.example.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Execution(ExecutionMode.SAME_THREAD)
@ExtendWith(CalculatorTestExtension.class)
public class CalculatorTest {

    @RegisterExtension
    TestWatcherExtension watcher = new TestWatcherExtension();

    static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        System.out.println("Before All Tests");
    }

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }
    @ParameterizedTest()
    @CsvSource({"1,2,3","4,3,7"})
    public void add(int a,int b,int expected) {
        int res=calculator.add(a, b);
        assertEquals(expected,res,"Addition Failed");
    }
    @Test
    public void subtract() {
        int res=calculator.subtract(4, 2);
        assertEquals(2,res,"Subtraction Failed");
    }
    @Test
    public void multiply() {
        int res=calculator.multiply(4, 2);
        assertEquals(8,res,"Multiplication Failed");
    }
    @ParameterizedTest()
    @MethodSource("divisionProvider")
    public void divide(int a, int b, int expected) {
        int res=calculator.divide(a, b);
        assertEquals(expected,res,"Division Failed");
    }

    static Stream<Arguments> divisionProvider() {
        return Stream.of(
                Arguments.of(10, 2, 5),
                Arguments.of(9, 3, 3),
                Arguments.of(100, 10, 10)
        );
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After Each Tests");
    }
    @AfterAll
    public static void tearDown() {
        System.out.println("After All Tests");
    }
}

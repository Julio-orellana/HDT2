package uvg.hdt2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class PostfixCalculatorTest {
    private PostfixCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new PostfixCalculator();
    }

    @Test
    void testEvaluateSimpleExpression() {
        assertEquals(5, calculator.evaluateExpression("2 3 +"));
    }

    @Test
    void testEvaluateComplexExpression() {
        assertEquals(15, calculator.evaluateExpression("1 2 + 4 * 3 +"));
    }

    @Test
    void testEvaluateWithMultiplicationAndDivision() {
        assertEquals(4, calculator.evaluateExpression("8 4 / 2 *"));
    }

    @Test
    void testEvaluateWithModulo() {
        assertEquals(1, calculator.evaluateExpression("10 3 %"));
    }

    @Test
    void testEvaluateInvalidExpression() {
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluateExpression("2 +"));
    }

    @Test
    void testEvaluateDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluateExpression("10 0 /"));
    }

    @Test
    void testReadFromFile() {
        try {
            calculator.readFromFile("test_data.txt"); // Asegúrate de que el archivo existe
            assertNotNull(calculator.getResult());
            System.out.println("Resultado leído del archivo: " + calculator.getResult());
        } catch (IOException e) {
            fail("Error al leer el archivo: " + e.getMessage());
        }
    }
}

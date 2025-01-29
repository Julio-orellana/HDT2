package uvg.hdt2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostfixCalculatorTest {
    private PostfixCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new PostfixCalculator();
    }

    @Test
    void testEvaluateSimpleExpression() {
        calculator.expression = "2 3 +";  // Simulando lectura de archivo
        assertEquals(5, calculator.evaluateExpression());
    }

    @Test
    void testEvaluateComplexExpression() {
        calculator.expression = "1 2 + 4 * 3 +";  // ((1+2)*4)+3 = 15
        assertEquals(15, calculator.evaluateExpression());
    }

    @Test
    void testEvaluateWithMultiplicationAndDivision() {
        calculator.expression = "8 4 / 2 *";  // (8/4)*2 = 4
        assertEquals(4, calculator.evaluateExpression());
    }

    @Test
    void testEvaluateInvalidExpression() {
        calculator.expression = "2 +";  // Falta un operando
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluateExpression());
    }

    @Test
    void testEvaluateWithModulo() {
        calculator.expression = "10 3 %";  // 10 % 3 = 1
        assertEquals(1, calculator.evaluateExpression());
    }
}

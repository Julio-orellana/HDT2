package uvg.hdt2.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Julio Orellana
 * Class that evaluates postfix expressions and returns the result of the expression.
 * The class implements the IPostfixCalculator interface.
 * @see IPostfixCalculator
 * The class uses a stack to evaluate the expressions and throws an exception if the expression is invalid.
 * @see IStack
 * The class also can read a file with postfix expressions and evaluate them.
 */
public class PostfixEvaluator implements IPostfixCalculator {

    private IStack<Double> stack;
    private String result;

    public PostfixEvaluator() {
        this.stack = new Stack<>();
    }

    /**
     * Reads a file with postfix expressions and evaluates them.
     * @param filePath The path to the file.
     * @throws IOException If an error occurs while reading the file.
     */
    @Override
    public void readFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    double result = evaluateExpression(line);
                    this.result = "Expresión: " + line + " = " + result;
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Error en la expresión: " + line);
                }
            }
        }
    }

    /**
     * Evaluates a postfix expression.
     * @param expression The postfix expression to evaluate.
     * @return The result of the expression.
     * @throws IllegalArgumentException If the expression is invalid.
     */
    @Override
    public double evaluateExpression(String expression) throws IllegalArgumentException {
        return 0;
    }

    /**
     * Validate if a string is a number or not using a regular expression.
     * @param str
     * @return True if the string is a number, false otherwise.
     */
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    /**
     * Applies an operator to two numbers and returns the result.
     * @param a
     * @param b
     * @param operator
     * @return The result of the operation.
     */
    private double applyOperator(double a, double b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new IllegalArgumentException("División por cero");
                return a / b;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator);
        }
    }

    public String getResult() {
        return result;
    }

}
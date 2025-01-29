package uvg.hdt2.model;

import java.io.IOException;

public interface IPostfixCalculator {

    void readFromFile(String path) throws IOException;
    double evaluateExpression(String expression) throws IllegalArgumentException;

}

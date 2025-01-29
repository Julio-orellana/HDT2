package uvg.hdt2;

import uvg.hdt2.model.PostfixCalculator;

public class Main {
    public static void main(String[] args) {
        PostfixCalculator calculator = new PostfixCalculator();
        try {
             calculator.readFromFile("src/main/resources/data.txt");
             String rs = calculator.getResult();
                System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
    }
} }
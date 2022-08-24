package stringcalculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculator {

    private static final List<Character> OPERATOR_SUPPORT = Arrays.asList('+', '-', '*', '/');

    private final List<Integer> numbers = new LinkedList<>();
    private final List<Character> operators = new LinkedList<>();
    private final String formula;

    public Calculator(String formula) {
        if (formula == null || formula.isEmpty()) {
            throw new IllegalArgumentException("null 또는 빈 값이 들어오면 예외가 발생한다.");
        }
        if (!Character.isDigit(formula.charAt(0))) {
            throw new IllegalArgumentException("숫자로 시작하지 않아 예외가 발생했다");
        }
        if (!Character.isDigit(formula.charAt(formula.length() - 1))) {
            throw new IllegalArgumentException("숫자로 끝나지 않아 예외가 발생했다");
        }

        String[] strings = formula.split(" ");

        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            putNumberAndOperator(string, i % 2 == 0);
        }

        this.formula = formula;
    }

    public void putNumberAndOperator(String string, boolean isNumber) {
        if (isNumber) {
            numbers.add(toInt(string));
            return;
        }
        validationOperator(string);
        operators.add(string.charAt(0));
    }

    private void validationOperator(String operator) {
        if (operator.length() > 1) {
            throw new IllegalArgumentException("공백으로 구분이 되지 않았습니다.");
        }
        if (!OPERATOR_SUPPORT.contains(operator.charAt(0))) {
            throw new IllegalArgumentException("지원하지 않는 연산자 입니다");
        }
    }

    private int toInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("공백으로 구분이 되지 않았습니다.");
        }
    }

    public int calculator() {
        int sum = numbers.remove(0);

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            char operator = operators.get(i);

            sum = calculate(sum, number, operator);
        }
        return sum;
    }

    private int calculate(int sum, int number, char operator) {
        if (operator == '+') {
            return plus(sum, number);
        }
        if (operator == '-') {
            return minus(sum, number);
        }
        if (operator == '*') {
            return multiply(sum, number);
        }
        return divide(sum, number);
    }

    private int plus(int x, int y) {
        return x + y;
    }

    private int minus(int x, int y) {
        return x - y;
    }

    private int multiply(int x, int y) {
        return x * y;
    }

    private int divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return x / y;
    }
}

import java.util.Stack;

public class InfixEvaluator {
    public static double evaluateInfix(double a, double b, double c, double d) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Double> valueStack = new Stack<>();

        for (char ch : ExpressionEvaluator.INFIX_EXPRESSION.toCharArray()) {
            if (ch == 'a')
                valueStack.push(a);
            else if (ch == 'b')
                valueStack.push(b);
            else if (ch == 'c')
                valueStack.push(c);
            else if (ch == 'd')
                valueStack.push(d);
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                double val2 = valueStack.pop();
                double val1 = valueStack.pop();
                char op = operatorStack.pop();
                double result = applyOperator(val1, val2, op);
                valueStack.push(result);
                operatorStack.pop();
            }
            
        }
        double lastVal1 = valueStack.pop();
        double lastVal2 = valueStack.pop();
        char lastOp = operatorStack.pop();
        double lastResult = applyOperator(lastVal1, lastVal2, lastOp);
        valueStack.push(lastResult);

        return valueStack.pop();
    }

    private static double applyOperator(double val1, double val2, char op) {
        switch (op) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                return val1 / val2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}
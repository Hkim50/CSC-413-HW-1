import java.util.Stack;

public class PostFixEvaluator {
    public static double evaluatePostfix(double a, double b, double c, double d) {
        Stack<Double> stack = new Stack<>();

        for (char ch : ExpressionEvaluator.POSTFIX_EXPRESSION.toCharArray()) {
            if (ch == 'a')
                stack.push(a);
            else if (ch == 'b')
                stack.push(b);
            else if (ch == 'c')
                stack.push(c);
            else if (ch == 'd')
                stack.push(d);
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'|| ch == '^') {
                double val2 = stack.pop();
                double val1 = stack.pop();
                stack.push(applyOperator(val1, val2, ch));
            }
        }

        return stack.pop();
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
            case '^':
                return Math.pow(val1,val2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}

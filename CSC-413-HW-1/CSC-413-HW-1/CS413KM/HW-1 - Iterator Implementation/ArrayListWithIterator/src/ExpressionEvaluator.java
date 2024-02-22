import java.util.Scanner;
// import java.util.Stack;
// import java.lang.Math;

public class ExpressionEvaluator {
    protected static final String INFIX_EXPRESSION = "(a+b)*(c+d)";
    protected static final String POSTFIX_EXPRESSION = "ac-b^d+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to compute expressions? (yes/no)");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("no")) {
                System.out.println("Program ended.");
                break;
            } else if (!input.equals("yes")) {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                continue;
            }

            System.out.println("Enter value for identifier 'a':");
            double a = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter value for identifier 'b':");
            double b = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter value for identifier 'c':");
            double c = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter value for identifier 'd':");
            double d = Double.parseDouble(scanner.nextLine());

            double infixResult = InfixEvaluator.evaluateInfix(a, b, c, d);
            double postfixResult = PostFixEvaluator.evaluatePostfix(a, b, c, d);

            System.out.println("Value of infix string " + INFIX_EXPRESSION +
                    " with a = " + a + ", b = " + b + ", c = " + c + ", d = " + d + " is " + infixResult);
            System.out.println("Value of postfix string " + POSTFIX_EXPRESSION +
                    " with a = " + a + ", b = " + b + ", c = " + c + ", d = " + d + " is " + postfixResult);
        }

        scanner.close();
    }
}
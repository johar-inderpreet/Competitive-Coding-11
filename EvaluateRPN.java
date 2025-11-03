import java.util.Stack;

public class EvaluateRPN {

    public int evalRPN(String[] tokens) {
        final Stack<Integer> stack = new Stack<>();

        for (final String token : tokens) {
            switch (token) {
                case "+", "-", "*", "/":
                    int right = stack.pop(), left = stack.pop();
                    int eval = eval(left, right, token);
                    stack.push(eval);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }

    private int eval(int left, int right, String token) {
        return switch (token) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "/" -> left / right;
            default -> left * right;
        };
    }
}

import java.util.Stack;

public class RemoveKDigits {

    public String removeKDigits(String num, int k) {
        if (k == num.length()) return "0";

        final Stack<Integer> stack = new Stack<>();

        for (char ch : num.toCharArray()) {
            int number = ch - '0';

            while (!stack.isEmpty() && stack.peek() > number && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(number);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        final StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }

        int i = 0;
        for (; i < builder.length(); i++) {
            if (builder.charAt(i) != '0') {
                break;
            }
        }

        final String output = builder.substring(i);

        if (output.isEmpty()) return "0";
        return output;
    }
}

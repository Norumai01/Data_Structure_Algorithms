import java.util.Stack;

public class ValidParentheses {
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // Push opening bracket.
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            // Matches closing bracket
            else {
                if (stack.isEmpty()) return false;
                char ch = stack.peek();
                if ((ch == '(' && s.charAt(i) != ')') ||
                    (ch == '{' && s.charAt(i) != '}') ||
                    (ch == '[' && s.charAt(i) != ']')) {
                    return false;
                }
                // Pop each matching bracket.
                stack.pop();
            }
        }
        // If empty, return true.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        /*
        URL: https://leetcode.com/problems/valid-parentheses
        */

        String input = "()";
        System.out.println(isValid(input));

        input = "()[]{}";
        System.out.println(isValid(input));

        input = "(]";
        System.out.println(isValid(input));

        input = "({})";
        System.out.println(isValid(input));
    }
}

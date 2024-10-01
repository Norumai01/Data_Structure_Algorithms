import java.util.Stack;

public class BaseBallStack {
    static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    int valueOne = stack.get(stack.size() - 2);
                    int valueTwo = stack.peek();
                    stack.push(valueOne + valueTwo);
                }
                case "C" -> stack.pop();
                case "D" -> stack.push(stack.peek() * 2);
                default -> stack.push(Integer.parseInt(operation));
            }
        }
        if (stack.isEmpty()) return 0;
        return stack.stream().mapToInt(x -> x).sum();
    }

    public static void main(String[] args) {
        // URL: https://leetcode.com/problems/baseball-game/

        String[] ops = {"5","2","C","D","+"};
        System.out.println("Total Points: " + calPoints(ops));

        ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("Total Points: " + calPoints(ops));

        ops = new String[]{"1","C"};
        System.out.println("Total Points: " + calPoints(ops));
    }
}


import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static Map<String, String> parenthesesMap = Map.of("(", ")", "{", "}", "[", "]");

    public static boolean isValid(String s) {

        Stack<String> stack = new Stack<>();
        String[] brackets = s.split("");
        for (String bracket : brackets) {
            if (parenthesesMap.containsKey(bracket))
                stack.push(bracket);
            else if (stack.size() > 0 && bracket.equals("]") && stack.peek().equals("["))
                stack.pop();
            else if (stack.size() > 0 && bracket.equals(")") && stack.peek().equals("("))
                stack.pop();
            else if (stack.size() > 0 && bracket.equals("}") && stack.peek().equals("{"))
                stack.pop();
            else
                return false;
        }

        if (stack.isEmpty())
            return true;
        else
            return false;


    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}



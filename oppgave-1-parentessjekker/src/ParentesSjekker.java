public class ParentesSjekker {
    boolean sjekkParenteser(String s) {
        char[] chars = s.toCharArray();
        LenketStabel<Character> stack = new LenketStabel<>();

        for (char c : chars) {
            if (isParenthesesStart(c)) { stack.push(c); }
            if (isParenthesesEnd(c)) {
                if (stack.isEmpty() || !isParenthesesPar(stack.pop(),c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    boolean isParenthesesPar(char start, char end) {
        if (start == '(' && end == ')') return true;
        if (start == '[' && end == ']') return true;
        if (start == '{' && end == '}') return true;
        return false;
    }

    boolean isParenthesesStart(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    boolean isParenthesesEnd(char c) {
        return c == ')' || c == ']' || c == '}';
    }
}

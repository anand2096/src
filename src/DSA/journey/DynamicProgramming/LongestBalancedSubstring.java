package DSA.journey.DynamicProgramming;
import java.util.*;

public class LongestBalancedSubstring {

    public static void main(String[] args) {
        String s="{])]}([]]()()){[([[)[}]{({))}]({(]}][)(]]]}[]{[)(]{)[[]{([]]][}[]{]]][}{]{}([){}[[([";
        System.out.println(new LongestBalancedSubstring().LBSlength(s));
    }
    public int LBSlength(final String A) {

        return longestValidParentheses(A);
    }

    public int longestValidParentheses(String s) {
        Map<Character,Character>map=new HashMap<>();
        map.put(')','('); map.put('}','{');map.put(']','[');
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        int lastInvalidIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(s.charAt(i))) {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    lastInvalidIndex = i;
                } else {
                    Character c=s.charAt(stack.peek());
                    stack.pop();
                    if(map.get(s.charAt(i)) ==c){
                        if (stack.isEmpty()) {
                            maxLength = Math.max(maxLength, i - lastInvalidIndex);
                        } else {
                            maxLength = Math.max(maxLength, i - stack.peek());
                        }
                    }

                    else
                    { lastInvalidIndex=i;
                    stack.push(i);}
                }
            }
        }

        return maxLength;
    }
}

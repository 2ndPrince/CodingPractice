/* 20. Valid Parentheses - EASY
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Time: O(N)
Space: O(N)

*/

class Solution {
    public boolean isValid(String s) {
        
        if(s.isEmpty()) return true;
        
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');
        
        Stack<Character> stack = new Stack<>();
        
        char[] chars = s.toCharArray();
        for(int i=0; i< chars.length; i++) {
            if(charMap.containsKey(chars[i])) {
                stack.add(chars[i]);
            } else {
                if(stack.isEmpty()) return false;
                char curChar = stack.pop();
                char correctChar = charMap.get(curChar);
                if(correctChar != chars[i]) {
                    return false;
                } 
            }
        }
        
        return stack.isEmpty();
    }
}

// () [] {}
// () ][ }{
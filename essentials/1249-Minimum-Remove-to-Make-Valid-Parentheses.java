// Question  : 1249. Minimum Remove to Make Valid Parentheses 
// Link      : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// Author    : Youngseok Lee
// Meta Info : Medium, Stack, String to Array to handle easier, StringBuilder, String's character removal

// Time Complexity  : O(N) - Traversing charList, other util operations O(4N)?
// Space Complexity : O(N) - List and Stack O(2N)

/*************************************************************************************** 

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

****************************************************************************************/
/*************************************************************************************** 

    Instructor's logical thinking
    1) we need to traverse a string
    2) traversing left to right? right to left? or two pointers?
    3) two pointers are usually for dynamic optimization on range
    4) between left to right or right to left; the only difference is ) being opening from starting on right
    4) let's go for 'left to right' traversing because it's familiar
    5) when traversing left to right, there are three possible types of characters
    6) they are "(", a-z, or ")"
    7) for lowercase alphabetical character, they don't affect to our solution, so ignore
    8) between "(" and ")", lets examine what to do with each
    9) when traversing and meeting '(', store in stack
    10) when meeting ')' and stack isn't empty, pop stack and proceed
    11) when meeting ')' and stack empty, remove(remember its indexes)
    12) if stack has leftover (only ')'s), remove them as well
    
****************************************************************************************/


class Solution {
    public String minRemoveToMakeValid(String s) {
        // String to char[] to List
        char[] charList = s.toCharArray();
        List<Character> charListNew = new ArrayList();
        for(char each: charList) {
            charListNew.add(each);
        }
        
        // 1) when ), if stack has element, pop and proceed without removal
        // 2) when ), if stack is empty, remove current
        // 3) when (, store index in stack
        // 4) after, if stack has elements, remove their positions
        
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<charListNew.size(); i++) {
            if(charListNew.get(i) == '(' ) {
                stack.add(i);
            }
            if(charListNew.get(i) == ')' ) {
                if(stack.isEmpty()) {
                    // charListNew.remove(i);
                    charListNew.set(i, ' ');
                } else {
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()) {
            int lastIndex = stack.pop();
            // charListNew.remove(lastIndex);
            charListNew.set(lastIndex, ' ');
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(Character c: charListNew) {
            if(c != ' ') sb.append(c);
        }
        System.out.println("sb: " + sb);
        
        return sb.toString();
    }
}

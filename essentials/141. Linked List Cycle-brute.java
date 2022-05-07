/*
141. Linked List Cycle - EASY

Brutal force solution
- Time: O(N) 
-- Set's add or contains method: O(1) extremely optimized

- Space: O(N)
-- Set is a scaling structure; worst case we end up saving all node elements


*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // edge case validation
        if(head == null) return false;
        
        ListNode currentNode = head;
        Set<ListNode> nodeSet = new HashSet<>();
        
        while(!nodeSet.contains(currentNode)) {
            if(currentNode.next == null) {
                return false;
            }
            nodeSet.add(currentNode);
            currentNode = currentNode.next;
        }
        return true;
    }
}
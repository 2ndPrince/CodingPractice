/* 141. Linked List Cycle - EASY

Optimal solution: Floyd's(프로이드) tortoise and hare
- algorithm for cycle detection

Time: O(N); slower pointer(toroise) won't complete a cycle
Space: O(1)

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
        // Edge case
        if(head == null) return false;
        
        // start at the same location
        ListNode hare = head;
        ListNode tortoise = head;
        while(true) {
            hare = hare.next;
            tortoise = tortoise.next;
            if(hare == null || hare.next == null) {
                return false;
            } else {
                hare = hare.next;    
            }
            
            if(hare.equals(tortoise)) {
                break;
            }
        }
        
        ListNode p1 = head, p2 = tortoise;
        
        while(p1!=p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // return p1; // the joint Node
        return true;
        
    }
}

// My solution after watching the theory video
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         // Edge case
//         if(head == null) return false;
        
//         ListNode current = head;

//         // start at the same location
//         ListNode hare = current;
//         ListNode tortoise = current;
//         while(hare!= null && hare.next != null && hare.next.next != null) {
//             hare = hare.next.next;
//             tortoise = tortoise.next;
//             if(hare.equals(tortoise)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
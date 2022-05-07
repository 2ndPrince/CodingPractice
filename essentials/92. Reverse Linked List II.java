// 92. Reverse Linked List II - MEDIUM
// https://leetcode.com/problems/reverse-linked-list-ii/

// [Example 1]
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

// [Example 2]
// Input: head = [5], left = 1, right = 1
// Output: [5]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int currentPosition = 1;
        ListNode currentNode = head;
        ListNode start = head;
        
        while (currentPosition < left) {
            start = currentNode;
            currentNode = currentNode.next;
            currentPosition ++;
        }
        
        ListNode newList = null;
        ListNode tail = currentNode;
        
        while (currentPosition >= left && currentPosition <= right) {
            ListNode next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
            currentPosition ++;
        }
        
        start.next = newList;
        tail.next = currentNode;
        
        if(left > 1) {
            return head;
        } else {
            return newList;
        }
        
    }
}
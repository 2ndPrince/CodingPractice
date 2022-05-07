// 430. Flatten a Multilevel Doubly Linked List - MEDIUM
/*
You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
*/

/*
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

INPUT: [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
OUTPUT: [1,2,3,7,8,11,12,9,10,4,5,6]
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node current = head;
        while(current.next != null) {
            if(current.child == null) {
                current = current.next;
            } else { 
                Node tailNode = current.child;
                while (tailNode.next != null) {
                    tailNode = tailNode.next;
                }
                
                tailNode.next = current.next;
                if (tailNode.next != null) {
                    tailNode.next.prev = tailNode;
                }
                
                current.next = current.child;
                current.next.prev = current;
                current.child = null;
            }
        }
        return head;
    }
}
package mahdi.davoodi;

import java.util.*;

/*
 * (Solved by me.)
 * 30 Days of code - HackerRank - Day 24: More Linked Lists
 * Link ---> https://www.hackerrank.com/challenges/30-linked-list-deletion/problem
 * */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}

class Solution {

    public static Node removeDuplicates(Node head) {
        List<Integer> list = new ArrayList<>();
        if (head == null)
            return null;
        else {
            list.add(head.data);
            Node prev = head;
            Node node = head.next;
            while (node != null) {
                if (list.contains(node.data))
                    prev.next = node.next;
                else {
                    list.add(node.data);
                    prev = node;
                }
                node = node.next;
            }
            return head;
        }
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);

    }
}
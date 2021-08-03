package mahdi.davoodi;

import java.util.Scanner;

/*
 * (Solved by myself.)
 * Website does not have sample code for Java 15!
 * Link --->  https://www.hackerrank.com/challenges/30-linked-list/problem
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

    public static Node insert(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node insert = head;
            while (insert.next != null) {
                insert = insert.next;
            }
            Node newNode = new Node(data);
            insert.next = newNode;

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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }
}
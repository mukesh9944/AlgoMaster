package com.mukesh.algorithm.twopointer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Function;

public class MiddleOfLinkedList {
    private static class Node<T> {
        public T val;
        public Node<T> next;
        public Node(T val, Node<T> next){
            this.val = val;
            this.next = next;
        }
    }
    private static int middleOfLinkedList(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow != null ? slow.val : -1;
    }
    private static <T> Node<T> buildList(Iterator<String> iterator, Function<String, T> f){
        if(!iterator.hasNext()) return null;
        String val = iterator.next();
        Node<T> next = buildList(iterator, f);
        return new Node<>(f.apply(val), next);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> integerNode = buildList(Arrays.stream(scanner.nextLine().split(" ")).iterator(), Integer::parseInt);
        System.out.println(middleOfLinkedList(integerNode));
    }

}

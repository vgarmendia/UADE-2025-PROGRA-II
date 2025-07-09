package implementation.dynamic;

import definition.SetADT;
import exception.EmptyADTException;

import java.util.Random;

public class DynamicSetADT implements SetADT {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private int size;
    private Random rand;

    public DynamicSetADT() {
        head = null;
        size = 0;
        rand = new Random();
    }

    @Override
    public boolean exist(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            throw new EmptyADTException("El conjunto está vacío.");
        }
        int index = rand.nextInt(size);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void add(int value) {
        if (exist(value)) return;

        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void remove(int element) {
        if (isEmpty()) return;

        if (head.value == element) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == element) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

package implementation.dynamic;

import definition.PriorityQueueADT;
import exception.EmptyADTException;

public class DynamicPriorityQueueADT implements PriorityQueueADT {

    private static class Node {
        int value;
        int priority;
        Node next;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
            this.next = null;
        }
    }

    private Node head;

    public DynamicPriorityQueueADT() {
        head = null;
    }

    @Override
    public int getElement() {
        if (isEmpty()) {
            throw new EmptyADTException("La cola con prioridad está vacía.");
        }
        return head.value;
    }

    @Override
    public int getPriority() {
        if (isEmpty()) {
            throw new EmptyADTException("La cola con prioridad está vacía.");
        }
        return head.priority;
    }

    @Override
    public void add(int value, int priority) {
        Node newNode = new Node(value, priority);

        // Insertar en la posición correcta según la prioridad (menor valor = mayor prioridad)
        if (head == null || priority < head.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.priority <= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyADTException("La cola con prioridad está vacía.");
        }
        head = head.next;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}

package implementation.dynamic;

import definition.MultipleDictionaryADT;
import definition.SetADT;
import exception.ElementNotFoundADTException;

public class DynamicMultipleDictionaryADT implements MultipleDictionaryADT {

    private class KeyNode {
        int key;
        int[] values;
        int valueCount;
        KeyNode next;

        public KeyNode(int key, int initialValue) {
            this.key = key;
            this.values = new int[2];
            this.values[0] = initialValue;
            this.valueCount = 1;
            this.next = null;
        }

        void addValue(int value) {
            if (!valueExists(value)) {
                if (valueCount == values.length) {
                    resizeValuesArray();
                }
                values[valueCount++] = value;
            }
        }

        void removeValue(int value) {
            int index = indexOf(value);
            if (index != -1) {
                for (int i = index; i < valueCount - 1; i++) {
                    values[i] = values[i + 1];
                }
                valueCount--;
            }
        }

        boolean valueExists(int value) {
            return indexOf(value) != -1;
        }

        int indexOf(int value) {
            for (int i = 0; i < valueCount; i++) {
                if (values[i] == value) return i;
            }
            return -1;
        }

        void resizeValuesArray() {
            int[] newArray = new int[values.length * 2];
            System.arraycopy(values, 0, newArray, 0, values.length);
            values = newArray;
        }
    }

    private KeyNode head;

    public DynamicMultipleDictionaryADT() {
        head = null;
    }

    @Override
    public void add(int key, int value) {
        KeyNode node = findKeyNode(key);
        if (node == null) {
            KeyNode newNode = new KeyNode(key, value);
            newNode.next = head;
            head = newNode;
        } else {
            node.addValue(value);
        }
    }

    @Override
    public void remove(int key) {
        KeyNode current = head;
        KeyNode previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    @Override
    public void remove(int key, int value) {
        KeyNode node = findKeyNode(key);
        if (node == null) return;

        node.removeValue(value);

        if (node.valueCount == 0) {
            remove(key);
        }
    }

    @Override
    public int[] get(int key) {
        KeyNode node = findKeyNode(key);
        if (node == null || node.valueCount == 0) {
            throw new ElementNotFoundADTException("Clave inexistente o sin valores.");
        }

        int[] result = new int[node.valueCount];
        System.arraycopy(node.values, 0, result, 0, node.valueCount);
        return result;
    }

    @Override
    public SetADT getKeys() {
        DynamicSetADT keySet = new DynamicSetADT();
        KeyNode current = head;
        while (current != null) {
            keySet.add(current.key);
            current = current.next;
        }
        return keySet;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    // Helpers
    private KeyNode findKeyNode(int key) {
        KeyNode current = head;
        while (current != null) {
            if (current.key == key) return current;
            current = current.next;
        }
        return null;
    }
}
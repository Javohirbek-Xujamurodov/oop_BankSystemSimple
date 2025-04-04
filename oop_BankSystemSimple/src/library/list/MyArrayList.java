package library.list;

import BankServices.Account;

import java.util.StringJoiner;

public class MyArrayList implements MyList{
    private Object[] elements;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    @Override
    public Object add(Object element) {
        if (size >= elements.length) {
            Object[] temp = new Object[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = element;
        return element;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            System.err.println("Index out bound");
            return null;
        }
        return elements[index];
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(Account acc) {

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(elements[i].toString());
        }
        return joiner.toString();
    }
}

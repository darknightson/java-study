package effectivejava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {

    private T[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = (T) e;
    }

    public Object pop() {
        if ( size == 0 ) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if ( elements.length == size ) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println("stack.size = " + stack.size);

        System.out.println(stack.pop());

        System.out.println("stack.size = " + stack.size);


    }
}

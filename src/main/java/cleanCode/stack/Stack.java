package cleanCode.stack;

import java.util.LinkedList;
import java.util.List;

public class Stack {

    private int topOfStack = 0;
    List<Integer> elements = new LinkedList<Integer>();

    public int size() {
        return topOfStack;
    }

    public void push ( int element) {
        elements.add(element);
        topOfStack++;
    }

    public int pop() {
        if (topOfStack == 0) {
            throw new IllegalStateException("Cannot pop an empty stack");
        }
        Integer integer = elements.get(--topOfStack);
        elements.remove(--topOfStack);
        return integer;
    }
}

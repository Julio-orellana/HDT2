package uvg.hdt2.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stack<T> implements IStack<T> {

    private LinkedList<T> stack;
    private List<Stack<T>> stackList;

    public Stack() {
        this.stack = new LinkedList<>();
        this.stackList = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        stack.addFirst(element);
    }

    @Override
    public T pop() {
        return stack.isEmpty() ? null : stack.removeLast();
    }

    @Override
    public T peek() {
        return stack.isEmpty() ? null : stack.getFirst();
    }

    @Override
    public boolean isEmpty() {
       return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    //Method to add a new pill to the vector
    public void addStack(Stack<T> newStack) {
        stackList.add(newStack);
    }

    //Method to get a specific pill of the vector
    public Stack<T> getStack(int index) {
        return (index >= 0 && index < stackList.size()) ? stackList.get(index) : null;
    }

    //Method to get the number of pills on the vector
    public int getStackSize() {
        return stackList.size();
    }
}

package uvg.hdt2.model;

public interface Istack<T> {

    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
}

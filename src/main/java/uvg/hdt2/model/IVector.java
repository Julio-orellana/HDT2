package uvg.hdt2.model;

public interface IVector<T> {

    void add(T element);
    T removeLast();
    T getLast();
    int size();
    boolean isEmpty();
    void clear();

}

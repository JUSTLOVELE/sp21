package deque;

/**
 * @author yangzl 2023/10/13
 * @version 1.00.00
 * @Description:
 * @history:
 */
public interface Deque<T> {

    public void addFirst(T item);

    public void addLast(T item);

    public default boolean isEmpty() {
        return size() == 0;
    };


    public int size();

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);
}

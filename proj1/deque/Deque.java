package deque;

import java.util.Iterator;

/**
 * @author yangzl 2023/10/13
 * @version 1.00.00
 * @Description:
 * @history:
 */
public interface Deque<T> {

    void addFirst(T item);

    void addLast(T item);

    default boolean isEmpty() {
        return size() == 0;
    };

    int size();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int index);
}

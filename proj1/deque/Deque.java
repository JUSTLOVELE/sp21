package deque;

/**
 * @author yangzl 2023/10/13
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2023 THINK WIN BIG DATA All Rights Reserved
 * @Company: 福建星云大数据应用服务有限公司
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

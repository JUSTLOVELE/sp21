package deque;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author yangzl 2023/10/12
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class MaxArrayDeque<T> implements Iterable<T> {

    private int size = 0;

    private int nextFirst;

    private int nextLast;

    private int item = 0;

    private T[] arrays;

    private Comparator<T> comparator;

    private T maxValue = null;

    public MaxArrayDeque(Comparator<T> c) {

        comparator = c;
        initMaxArrayDeque();
    }

    public T max() {
        return maxValue;
    }

    public T max(Comparator<T> c) {

        if (isEmpty()) {
            return  null;
        }



        boolean flag = true;
        int first = this.nextFirst + 1;
        int last = this.nextLast;
        T max = null;

        while (flag) {

            T v = this.arrays[first];

            if (max == null) {
                max = v;
            } else {
                if (c.compare(max, v) < 0) {
                    max = v;
                }
            }

            first++;

            if (first > this.arrays.length - 1) {
                first = 0;
            }

            if (first == last) {
                flag = false;
            }
        }

        return max;
    }

    private void comparatorMaxValue(T value) {

        if (this.comparator == null) {
            return;
        }

        if (maxValue == null) {

            maxValue = value;
            return;
        }

        if (comparator.compare(maxValue, value) < 0) {
            maxValue = value;
        }

    }

    /**
     * Creates an empty linked list deque.
     */
    public MaxArrayDeque() {

        arrays = (T[]) new Object[8];
        initMaxArrayDeque();
    }

    private void initMaxArrayDeque() {

        arrays = (T[]) new Object[8];
        //初始化nextFirst、nextLast
        this.nextFirst = item + 1;
        this.nextLast = item + 2;
    }

    /**
     * Adds an item of type T to the front of the deque
     * @param t
     */
    public void addFirst(T t) {
        //要考虑nextFirst-1和nextLast重合,然后就要resize数组
        //注意nextFirst和nextLast都是空位
        //两个相邻的情况和first在头,last在尾的情况都是要扩展的
        if (this.size == this.arrays.length - 2) {
            //重新规划数组
            resizeWithIncrease();
        }
        //要考虑nextFrist-1数组越界要插入到数组边界
        this.arrays[this.nextFirst] = t;

        if (this.nextFirst == 0) {
            this.nextFirst = this.arrays.length - 1;
        } else {
            this.nextFirst--;
        }

        size++;
        comparatorMaxValue(t);
    }

    /**
     * Adds an item of type T to the back of the deque
     * @param t
     */
    public void addLast(T t) {
        //要考虑nextFirst和nextLast+1重合,然后就要resize数组
        //注意nextFirst和nextLast都是空位
        //两个相邻的情况和first在头,last在尾的情况都是要扩展的
        if (this.size == this.arrays.length - 2) {
            //重新规划数组
            resizeWithIncrease();
        }
        //要考虑nextLast+1数组越界要插入到数组边界
        this.arrays[this.nextLast] = t;

        if (this.nextLast == this.arrays.length - 1) {
            this.nextLast = 0;
        } else {
            this.nextLast++;
        }

        size++;
        comparatorMaxValue(t);
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
    public boolean isEmpty() {

        if (size == 0) {
            return true;
        }

        return false;
    }

    /**
     * Returns the number of items in the deque.
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {

        boolean flag = true;
        int first = this.nextFirst + 1;
        int last = this.nextLast;

        while (flag) {

            if (first > this.arrays.length - 1) {
                first = 0;
            }

            System.out.print(this.arrays[first]);
            first++;

            if (first == last) {
                flag = false;
            }
        }

        System.out.println();
    }


    private void resizeWithIncrease() {
        //从nextFirst->nextLast
        T[] newArray = (T[]) new Object[this.arrays.length * 2];
        boolean flag = true;
        int index = 0;

        while (flag) {
            //节点相邻
            if (this.nextFirst != this.nextLast) {
                //这里还有个特殊情况,就是nextFirst在尾部节点,
                if (this.nextFirst == this.arrays.length - 1) {
                    //如果nextFirst走到了数组右边的边界,就置于0,置于0就相当于+1,所以这里就不加一了
                    this.nextFirst = 0;
                } else {
                    //因为nextFirst是空位,所以要+1才有值的
                    this.nextFirst++;
                }
                //先+1是因为0位留给nextFirst,因为nextFirst要是空位
                if (this.arrays[this.nextFirst] != null) {
                    index++; //从1开始把0留给nextFirst
                    newArray[index] = this.arrays[this.nextFirst];
                }
            } else {
                flag = false;
            }
        }

        this.nextFirst = 0;
        this.nextLast = index + 1; //最后再加一是因为nextLast要是空的
        this.arrays = newArray;
    }

    private void resizeIDecrease() {

        if (this.arrays.length < 16) {
            return;
        }

        if (size * 2 > this.arrays.length) {
            return;
        }
        //空置率至少一半,缩小25%
        int length = Double.valueOf(this.arrays.length * 0.75).intValue();
        T[] newArray = (T[]) new Object[length];

        boolean flag = true;
        int index = 0;

        while (flag) {
            //为什么加一呢?因为nextFirst和nextLast是空的,加一如果相等意味着不能再往前了
            if (this.nextFirst != this.nextLast) {

                if (this.nextFirst >= this.arrays.length - 1) {
                    //如果nextFirst走到了数组右边的边界,就置于0
                    this.nextFirst = 0;
                } else {
                    this.nextFirst++;
                }
                //先+1是因为0位留给nextFirst,因为nextFirst要是空位
                if (this.arrays[this.nextFirst] != null) {
                    index++;
                    newArray[index] = this.arrays[this.nextFirst];
                }
            } else {
                flag = false;
            }
        }

        this.nextFirst = 0;
        this.nextLast = index + 1; //最后再加一是因为nextLast要是空的
        this.arrays = newArray;

    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        if (this.nextFirst == this.arrays.length - 1) {
            this.nextFirst = 0;
        } else {
            this.nextFirst++;
        }

        T t = this.arrays[this.nextFirst];
        this.arrays[this.nextFirst] = null;
        size--;
        resizeIDecrease();

        return t;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        if (this.nextLast == 0) {
            this.nextLast = this.arrays.length - 1;
        } else {
            this.nextLast--;
        }

        T t = this.arrays[this.nextLast];
        this.arrays[this.nextLast] = null;
        size--;
        resizeIDecrease();

        return t;
    }

    /**
     *  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    public T get(int index) {

        if (index < 0 || index > size - 1) {
            return null;
        }

        int n = this.nextFirst + 1 + index; //加1是因为nextFirst是为空,所以正式取值要+1

        if (n < this.arrays.length) {
            return this.arrays[n];
        } else {
            return this.arrays[n - this.arrays.length];
        }
    }


    public Iterator<T> iterator() {

        boolean flag = true;
        int first = this.nextFirst + 1;
        int last = this.nextLast;
        T[] objects = (T[]) new Object[this.size];
        int index = 0;

        while (flag) {

            if (first > this.arrays.length - 1) {
                first = 0;
            }

            objects[index] = this.arrays[first];
            first++;
            index++;

            if (first == last) {
                flag = false;
            }
        }

        return Arrays.stream(objects).iterator();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof MaxArrayDeque)) {
            return false;
        }

        MaxArrayDeque<T> deque = (MaxArrayDeque<T>) obj;
        Iterator<T> iterator = deque.iterator();
        Iterator<T> arrayIterator = this.iterator();

        if (!iterator.hasNext() || !iterator.hasNext()) {
            return false;
        }

        while (iterator.hasNext() || arrayIterator.hasNext()) {

            try {
                T next = iterator.next();
                T arrayNext = arrayIterator.next();

                if (!arrayNext.equals(next)) {
                    return false;
                }
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        return true;
    }
}

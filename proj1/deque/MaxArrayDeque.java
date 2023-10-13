package deque;

import java.util.Comparator;

/**
 * @author yangzl 2023/10/12
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class MaxArrayDeque<T> {

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

        if(isEmpty()) {
            return  null;
        }



        boolean flag = true;
        int first = this.nextFirst + 1;
        int last = this.nextLast;
        T max = null;

        while (flag) {

            T v = this.arrays[first];

            if(max == null) {
                max = v;
            }else {
                if(c.compare(max, v)<0) {
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

        if(this.comparator == null) {
            return ;
        }

        if(maxValue == null) {

            maxValue = value;
            return;
        }

        if(comparator.compare(maxValue, value) < 0) {
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
        if (this.size == this.arrays.length - 2) {
            resizeWithIncrease();
        }
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
        if (this.size == this.arrays.length - 2) {
            //重新规划数组
            resizeWithIncrease();
        }
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

            System.out.print(this.arrays[first]);
            first++;

            if (first > this.arrays.length - 1) {
                first = 0;
            }

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
            if (this.nextFirst != this.nextLast) {
                if (this.nextFirst == this.arrays.length - 1) {
                    this.nextFirst = 0;
                } else {
                    this.nextFirst++;
                }
                if (this.arrays[this.nextFirst] != null) {
                    index++;
                    newArray[index] = this.arrays[this.nextFirst];
                }
            } else {
                flag = false;
            }
        }

        this.nextFirst = 0;
        this.nextLast = index + 1;
        this.arrays = newArray;
    }

    private void resizeIDecrease() {

        if (this.arrays.length < 16) {
            return;
        }

        if (size * 2 > this.arrays.length) {
            return;
        }
        int length = Double.valueOf(this.arrays.length * 0.75).intValue();
        T[] newArray = (T[]) new Object[length];

        boolean flag = true;
        int index = 0;

        while (flag) {
            if (this.nextFirst != this.nextLast) {

                if (this.nextFirst >= this.arrays.length - 1) {
                    this.nextFirst = 0;
                } else {
                    this.nextFirst++;
                }
                if (this.arrays[this.nextFirst] != null) {
                    index++;
                    newArray[index] = this.arrays[this.nextFirst];
                }
            } else {
                flag = false;
            }
        }

        this.nextFirst = 0;
        this.nextLast = index + 1;
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

        int n = this.nextFirst + 1 + index;

        if (n < this.arrays.length) {
            return this.arrays[n];
        } else {
            return this.arrays[n - this.arrays.length];
        }
    }
}

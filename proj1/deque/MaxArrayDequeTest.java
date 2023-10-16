package deque;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author yangzl 2023/10/13
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class MaxArrayDequeTest {

    @Test
    public void iteratorTest() {

        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(3);
        array.add(4);
        Iterator<Integer> iterator = array.iterator();

        while(iterator.hasNext()) {
            iterator.next();
        }

        System.out.println(iterator.next());
    }

    @Test
    public void mTest() {

        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>();
        maxArrayDeque.addFirst(3);
        maxArrayDeque.addFirst(5);
        maxArrayDeque.addFirst(6);
        int v = maxArrayDeque.max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(o1 == o2) {
                    return 0;
                }else if(o1 > o2) {
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        System.out.println(v);
    }
}

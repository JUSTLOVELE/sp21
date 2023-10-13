package deque;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author yangzl 2023/10/13
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2023 THINK WIN BIG DATA All Rights Reserved
 * @Company: 福建星云大数据应用服务有限公司
 * @history:
 */
public class MaxArrayDequeTest {

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

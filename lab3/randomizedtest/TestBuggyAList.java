package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct  = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();
        int N = 5000;

        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = correct.size();
                System.out.println("size: " + size);
            } else if(operationNumber == 2) {

                if(correct.size() > 0) {
                    Integer last = correct.getLast();
                    Integer last1 = broken.getLast();
                    System.out.println("correct:" + last + ";broken:" + last1);

                    if(!Objects.equals(last, last1)) {
                        throw new RuntimeException("not equals");
                    }
                }
            }else if(operationNumber == 3) {

                if(correct.size() > 0) {
                    Integer last = correct.removeLast();
                    Integer last1 = broken.removeLast();
                    System.out.println("correct:" + last + ";broken:" + last1);

                    if(!Objects.equals(last, last1)) {
                        throw new RuntimeException("removeLast not equals");
                    }
                }
            }
        }
    }
}

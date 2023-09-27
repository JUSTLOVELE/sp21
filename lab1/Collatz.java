/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {
    //如果 n 为偶数，则下一个数字为 n/2。如果 n 为奇数，则下一个数字为 3n + 1。如果 n 为 1，则序列结束。
    /** Buggy implementation of nextNumber! */
    public static int nextNumber(int n) {

        if(n == 1) {
            return 1;
        } else if(n%2 == 0) {
            return n/2;
        }else if(n % 2 != 0) {
            return 3*n + 1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}


package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        test(Ns, times, opCounts, 1000);
        test(Ns, times, opCounts, 2000);
        test(Ns, times, opCounts, 4000);
        test(Ns, times, opCounts, 8000);
        test(Ns, times, opCounts, 16000);
        test(Ns, times, opCounts, 32000);
        test(Ns, times, opCounts, 64000);
        test(Ns, times, opCounts, 128000);

        printTimingTable(Ns, times, opCounts);
    }

    private static void test(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts, int size) {

        SLList slList = new SLList();

        for(int i=0; i<size; i++) {
            slList.addLast(i);
        }

        long startTime = System.currentTimeMillis();

        for(int i=0; i<10000; i++) {
            slList.getLast();
        }

        long endTime = System.currentTimeMillis();

        Ns.addLast(size);
        opCounts.addLast(size);
        double time = Double.valueOf(endTime-startTime)/1000;
        times.addLast(time);

    }

}

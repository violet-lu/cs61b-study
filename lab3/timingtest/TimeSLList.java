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
        AList SllResultList = new AList<Integer>();
        AList timeList = new AList<Integer>();
        AList opCountsList = new AList<Integer>();
        for(int i = 0; i < 8; i++) {
            int count = ((int) Math.pow(2, i) * 1000);
            SllResultList.addLast(count);
            SLList  operSllist = new SLList();
            while (count > 0) {
                operSllist.addLast(1);
                count--;
            }
            Stopwatch sw = new Stopwatch();
            count = 10000;
            int getCallTimes = 0;
            while (count > 0) {
                operSllist.getLast();
                getCallTimes++;
                count--;
            }
            double timeInSeconds = sw.elapsedTime();
            timeList.addLast(timeInSeconds);
            opCountsList.addLast(getCallTimes);
        }
        printTimingTable(SllResultList, timeList, opCountsList);
    }

}

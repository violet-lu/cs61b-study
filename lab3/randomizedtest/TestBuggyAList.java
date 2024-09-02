package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing aList = new AListNoResizing<Integer>();
        BuggyAList buggyAList = new BuggyAList<Integer>();
        aList.addLast(4);
        buggyAList.addLast(4);
        aList.addLast(5);
        buggyAList.addLast(5);
        aList.addLast(6);
        buggyAList.addLast(6);
        int aLast = (int) aList.removeLast();
        int buggyLast = (int) buggyAList.removeLast();
        assertEquals(aLast, buggyLast);
        aLast = (int) aList.removeLast();
        buggyLast = (int) buggyAList.removeLast();
        assertEquals(aLast, buggyLast);
        aLast = (int) aList.removeLast();
        buggyLast = (int) buggyAList.removeLast();
        assertEquals(aLast, buggyLast);
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
            } else if (operationNumber == 2) {
                int sizeL = L.size();
                int sizeB = L.size();
                if (sizeL > 0 && sizeB > 0) {
                    assertEquals(L.removeLast(), B.removeLast());
                }
            }
        }
    }
}

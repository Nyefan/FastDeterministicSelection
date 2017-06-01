package com.nyefan.fds;

import java.util.Comparator;

/**
 * @author nyefan
 */
public class Partitions<T> {

    public int hoarePartition(View<T> A, Comparator<T> comparator) {
        if (A.length <= 0) { throw new IllegalArgumentException(); }

        int a = 1;
        int b = A.length - 1;

        loop:
        while (true) {
            while (true) {
                if (a > b) { break loop; }
                if (comparator.compare(A.get(a), A.get(0)) >= 0) { break; }
                a++;
            }
            while (comparator.compare(A.get(a), A.get(b)) < 0) {
                b--;
            }
            if (a >= b) { break; }
            A.swap(a, b);
            a++;
            b--;
        }
        A.swap(0, a - 1);
        return a - 1;
    }
}

package com.nyefan.fds;

import static com.nyefan.fds.RoteRoutines.median5;

/**
 * @author nyefan
 */
public class Partitions {

    public interface Partition<T> {
        public int apply(View<T> A, int p);
    }

    public static class BFPRTBaseline<T> implements Partition<T> {
        @Override
        public int apply(View<T> A, int p) {
            if (A.length < 5) { return new Partitions.HoarePartition<T>().apply(A, A.length / 2); }
            int i = 0;
            int j = 0;

            while (i + 4 < A.length) {
                median5(A, i, i + 1, i + 2, i + 3, i + 4);
                A.swap(i + 2, j);
                i += 5;
                j += 1;
            }
            quickSelect(new BFPRTBaseline<>(), A.range(0, j), j / 2);
            return new HoarePartition<T>().apply(A, A.length / 2);
        }
    }

    public static class HoarePartition<T> implements Partition<T> {
        @Override
        public int apply(final View<T> A, int p) {
            if (A.length <= 0) { throw new IllegalArgumentException(); }
            if (p < 0 || p >= A.length) { throw new IllegalArgumentException(); }

            A.swap(0, p);
            int a = 1;
            int b = A.length - 1;

            loop:
            while (true) {
                while (true) {
                    if (a > b) { break loop; }
                    if (A.compare(a, 0) >= 0) { break; }
                    a++;
                }
                while (A.compare(0, b) < 0) {
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

    private static <T> void quickSelect(Partition<T> partition, View<T> A, int k) {
        if (k >= A.length || k < 0) { return; }
        while (true) {
            int p = partition.apply(A, A.length / 2);
            //RETURN
            if (p == k) { return; }
            if (p > k) {
                A = A.range(0, p);
            } else {
                k = k - p - 1;
                A = A.range(p + 1, A.length);
            }
        }
    }
}

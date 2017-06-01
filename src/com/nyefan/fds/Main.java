package com.nyefan.fds;

import java.util.Comparator;

import static com.nyefan.fds.Partitions.Partition;
import static com.nyefan.fds.Partitions.HoarePartition;

/**
 * FAST DETERMINISTIC SELECTION
 * This is a Java implementation of the algorithm described in the research paper published
 * at http://erdani.com/research/sea2017.pdf
 */
public class Main {


    public static void main(String[] args) {

    }

    public static <T> void quickSelect(T[] Array, int k, Comparator<T> comparator) {
        View<T>       A         = new View<>(Array, 0, Array.length);
        Partition partition = new HoarePartition<T>();

        if (k >= A.length || k < 0) { return; }
        while (true) {
            int p = partition.apply(A, comparator);
            //RETURN
            if (p == k) { return; }
            if (p > k) {
                A.range(0, p);
            } else {
                k = k - p - 1;
                A.range(p + 1, Array.length);
            }
        }
    }
}

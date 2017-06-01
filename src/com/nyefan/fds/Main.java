package com.nyefan.fds;

import java.util.Comparator;

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
        Partitions<T> partition = new Partitions<>();

        if (k >= A.length || k < 0) { return; }
        while (true) {
            int p = partition.hoarePartition(A, comparator);
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

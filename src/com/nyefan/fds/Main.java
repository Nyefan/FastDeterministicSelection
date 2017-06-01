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

    public static <T> void quickSelect(T[] A, int k, Comparator<T> comparator) {
        View<T> B = new View<>(A, 0, A.length);

        if (k >= B.length || k < 0) { return; }
        while (true) {
            int p = partition(A);
            //RETURN
            if (p == k) { return; }
            if (p > k) {
                B = new View<>(A, 0, p);
            } else {
                k = k-p-1;
                B = new View<>(A, p+1, A.length);
            }
        }
    }

    public static <T> int partition(T[] A) {
        //TODO: implement this
        return A.length / 2;
    }

}

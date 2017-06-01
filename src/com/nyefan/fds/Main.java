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
        if (k >= A.length || k < 0) { return; }
        while (true) {
            int p = partition(A);
        }
    }

    public static <T> int partition(T[] A) {
        //TODO: implement this
        return A.length / 2;
    }

    public class View<T> {
        T[] A;
        int i;
        int j;

        public View(T[] A, int i, int j) {
            this.A = A;
            this.i = i;
            this.j = j;
        }

        public T get(int k) {
            if (k >= j - i || k < j - i) { throw new ArrayIndexOutOfBoundsException(); }
            return A[k + i];
        }

        public void swap(int k, int l) {
            if (k >= j - i || k < j - i || l >= j - i || l < j - i) { throw new ArrayIndexOutOfBoundsException(); }
            T swap = A[k + i];
            A[k + i] = A[l + i];
            A[l + i] = swap;
        }
    }
}

package com.nyefan.fds;

import java.util.Comparator;

/**
 * @author nyefan
 */
public class View<T> {
    T[] A;
    int i;
    int j;

    public final Comparator<T> comparator;
    public final int           length;

    public View(T[] A, Comparator<T> comparator) {
        this(A, 0, A.length, comparator);
    }

    public View(T[] A, int i, int j, Comparator<T> comparator) {
        //This is intentional to allow the original array to continue being modified
        //noinspection AssignmentToCollectionOrArrayFieldFromParameter
        this.A = A;
        this.i = i;
        this.j = j;
        this.length = j-i;
        this.comparator = comparator;
    }

    public int compare(int a, int b) {
        return comparator.compare(A[a], A[b]);
    }

    public T get(int k) {
        if (k >= j - i || k < 0) { throw new ArrayIndexOutOfBoundsException(); }
        return A[k + i];
    }

    public void sort(int k, int l) {
        if (k >= j - i || k < 0 || l >= j - i || l < 0) { throw new ArrayIndexOutOfBoundsException(); }
        if (comparator.compare(A[k], A[l]) > 0) { swap(k, l); }
    }

    public void swap(int k, int l) {
        if (k >= j - i || k < 0 || l >= j - i || l < 0) { throw new ArrayIndexOutOfBoundsException(); }
        T swap = A[k + i];
        A[k + i] = A[l + i];
        A[l + i] = swap;
    }

    public View<T> range(int k, int l) {
        if (k >= j - i || k < 0 || l > j - i || l < 0 || l < k) { throw new ArrayIndexOutOfBoundsException(); }
        return new View<>(A, i + k, i + l, comparator);
    }
}

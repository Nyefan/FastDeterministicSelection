package com.nyefan.fds;

/**
 * @author nyefan
 */
public class View<T> {
    T[] A;
    int i;
    int j;

    public final int length;

    public View(T[] A, int i, int j) {
        this.A = A;
        this.i = i;
        this.j = j;
        this.length = A.length;
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

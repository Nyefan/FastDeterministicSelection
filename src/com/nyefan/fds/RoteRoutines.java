package com.nyefan.fds;

/**
 * @author nyefan
 */
public class RoteRoutines {
    /**
     * swaps the median of A[a], ..., A[e] into A[c] with the guarantee that A[a], A[b] <= c and A[d], A[e] >= c
     */
    public static <T> void median5(View<T> A, int a, int b, int c, int d, int e) {
//        A.sort(a, b);
//        A.sort(d, e);
//        A.sort(b, d);
//        A.sort(c, e);
//        A.sort(a, c);
//        A.sort(b, c);
//        A.sort(c, e);
//        A.sort(c, d);

        A.sort(d, e);
        A.sort(a, b);

        //if A[a]>A[d]
        if (A.compare(a, d) > 0) {
            A.swap(a, d);
            A.swap(b, e);
        }

        // At this point, the following are true
        // A[a]<A[b]
        // A[a]<A[d]<A[e]
        assert A.compare(a, b) <= 0 && A.compare(a, d) <= 0 && A.compare(d, e) <= 0;

        //if A[b]>A[c]
        if (A.compare(b, c) > 0) {
            //if A[c]>A[d]
            if (A.compare(c, d) > 0) {
                A.sort(c, e);
                //Guarantee that the view pivots around c
                A.swap(b, d);
                //if A[c]<=A[d]
            } else {
                //if A[b]>A[d]
                if (A.compare(b, d) > 0) {
                    A.swap(c, d);
                    A.swap(b, d);
                    //if A[b]<=A[d]
                } else {
                    A.swap(b, c);
                }
            }
            //if A[b]<=A[c]
        } else {
            //if A[b]<A[d]
            if (A.compare(b, d) < 0) {
                A.sort(c, d);
                //if A[b]>=A[d]
            } else {
                //if A[b]>A[e]
                if (A.compare(b, e) > 0) {
                    A.swap(c, e);
                    //Guarantee that the view pivots around c
                    A.swap(d, b);
                    //if A[b]<=A[e]
                } else {
                    A.swap(b, c);
                    //Guarantee that the view pivots around c
                    A.swap(b, d);
                }
            }
        }

        // At this point, the following are true
        // A[a]<=A[c], A[b]<=A[c], A[c]<=A[d], A[c]<=A[e]
        assert A.compare(a, c) <= 0 && A.compare(b, c) <= 0 && A.compare(c, d) <= 0 && A.compare(c, e) <= 0;
    }
}

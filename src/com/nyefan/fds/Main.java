package com.nyefan.fds;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FAST DETERMINISTIC SELECTION
 * This is a Java implementation of the algorithm described in the research paper published
 * at http://erdani.com/research/sea2017.pdf
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            Integer[]     Array = new Random().ints(5, 1, 101).boxed().toArray(Integer[]::new);
            View<Integer> A     = new View<>(Array, Comparator.naturalOrder());
            System.out.println(Stream.of(Array).map(String::valueOf).collect(Collectors.joining(",")));
            RoteRoutines.median5(A, 0, 1, 2, 3, 4);
            A.swap(0, 2);
            if (!(Array[0] >= Array[1] && Array[0] >= Array[2] && Array[0] <= Array[3] && Array[0] <= Array[4])) {
                System.out.println("failed");
                System.out.println(Stream.of(Array).map(String::valueOf).collect(Collectors.joining(",")));
                return;
            }
        }
        System.out.println("success");
    }
}

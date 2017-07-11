package com.nyefan.fds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FAST DETERMINISTIC SELECTION
 * This is a Java implementation of the algorithm described in the research paper published
 * at http://erdani.com/research/sea2017.pdf
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 120; i++) {
//            Integer[]     Array = new Random().ints(5, 1, 101).boxed().toArray(Integer[]::new);
            Integer[]     Array = permute5(i);
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

    private static Integer[] permute5(int index) {
        if (index < 0 || index >= 120) { throw new IndexOutOfBoundsException(); }

        int one = index / 24;
        index %= 24;
        int two = index / 6;
        index %= 6;
        int three = index / 2;
        index %= 2;
        int four = index;
        int five = 0;

        LinkedList<Integer> list  = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4));
        Integer[]           array = new Integer[5];
        array[list.get(one)] = 1;
        list.remove(one);
        array[list.get(two)] = 2;
        list.remove(two);
        array[list.get(three)] = 3;
        list.remove(three);
        array[list.get(four)] = 4;
        list.remove(four);
        array[list.get(five)] = 5;

        return array;
    }
}

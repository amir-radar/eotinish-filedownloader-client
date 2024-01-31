package gtrokingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchingAlgorithms {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(5, 4, 6, 2, 10);
        System.out.println(selectionSort(ints).toString());
    }

    public static List<Integer> selectionSort(List<Integer> ints){
        List<Integer> newInts = new ArrayList<>();

        int size = ints.size();

        for (int i = 0; i < size; i++) {
            int smallestIndex = findSmallest(ints);
            newInts.add(ints.get(smallestIndex));
            ints.remove(smallestIndex);
        }
        return newInts;
    }

    private static int findSmallest(List<Integer> ints){
        int smallest = ints.get(0);
        int smallestIndex = 0;
        for (int i = 0; i < ints.size(); i++) {
            if (smallest > ints.get(i)){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    private static List<Integer> selectionSort2(List<Integer> arr) {
        List<Integer> newArr = new ArrayList<>(arr.size());

        int size = arr.size();

        for (int i = 0; i < size; i++) {
            int smallest = findSmallest2(arr);
            newArr.add(arr.get(smallest));

            arr.remove(smallest);
        }

        return newArr;
    }

    private static int findSmallest2(List<Integer> arr) {
        int smallest = arr.get(0);
        int smallestIndex = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < smallest) {
                smallest = arr.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void main2(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(selectionSort2(arr)); //[2, 3, 5, 6, 10]
    }
}

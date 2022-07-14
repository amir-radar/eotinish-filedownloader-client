package road.tothedream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSeparator {

    public static void main(String[] args) {
        ListSeparator listSeparator = new ListSeparator();
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        List<List<Integer>> result = listSeparator.separate(intList, 3);
        System.out.println(result.toString());
    }

    private List<List<Integer>> separate(List<Integer> list, int partCount){
        int partSize = (int)(Math.ceil((double) list.size() / (double) partCount));
        int counter = 0;
        List<List<Integer>> listOfList = new ArrayList<>();
        List<Integer> newInts = new ArrayList<>();
        for (int x = 0; x < list.size(); x++){
            counter++;
            newInts.add(list.get(x));
            if (counter == partSize || x == list.size() - 1){
                listOfList.add(newInts);
                counter = 0;
                newInts = new ArrayList<>();
            }
        }
        return listOfList;
    }

    private List<List<Integer>> separate2(List<Integer> list, int partCount){
        int partSize = (int)(Math.ceil((double) list.size() / (double) partCount));
        return null;
    }
}

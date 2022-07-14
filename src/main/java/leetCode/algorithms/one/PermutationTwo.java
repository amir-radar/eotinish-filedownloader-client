package leetCode.algorithms.one;

import java.util.ArrayList;
import java.util.List;

public class PermutationTwo {

    public static void main (String args[]){
        int[] nums = {0, 0, 5, 0, 9};
        List<List<Integer>> lists = new ArrayList<>();
        for ( int i = 0; i < nums.length;i++){
            if (i == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                lists.add(list);
            } else {
                PermutationTwo.getPermutation(lists, nums[i], i);
                for (int j = lists.size() - 1; j >= 0; j--) {
                    if (lists.get(j).size() == i){
                        lists.remove(j);
                    }
                }
            }
        }
        for( List<Integer> list : lists){
            System.out.println(list);
        }
    }

    public static void getPermutation(List<List<Integer>> lists, int number, int counter){
        List<List<Integer>> newLists = new ArrayList<>();
        newLists.addAll(lists);
        for(int j = 0; j < lists.size(); j++){
            List<Integer> list = lists.get(j);
            for ( int i = 0; i <= list.size(); i++){
                if(i == 0){
                    List<Integer> newList = new ArrayList<>();
                    newList.add(number);
                    for( int x : list){
                        newList.add(x);
                    }
                    newLists.add(newList);
                } else if ( i == list.size()) {
                    List<Integer> newList = new ArrayList<>();
                    for ( int x = 0; x < list.size(); x++){
                        newList.add(list.get(x));
                    }
                    newList.add(number);
                    newLists.set(j, newList);
                } else {
                    List<Integer> newList = new ArrayList<>();
                    for ( int x = 0; x <= list.size();x++){
                        if(x < i){
                            newList.add(list.get(x));
                        } else if ( x==i) {
                            newList.add(number);
                        } else {
                            newList.add(list.get(x - 1));
                        }
                    }
                    newLists.add(newList);
                }
            }
        }

        for (List<Integer> newList : newLists) {
            if (!lists.contains(newList)){
                lists.add(newList);
            }
        }
    }
}

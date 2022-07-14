package leetCode.algorithms.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayPossibles {

        public static void main (String args[]){
            //ArrayPossibles permutationTwo = new ArrayPossibles();
            int[] nums = {1, 2, 3};
            List<List<Integer>> lists = new ArrayList<>();
            for ( int i = 0; i < nums.length;i++){
                if (i == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    lists.add(list);
                } else {
                    ArrayPossibles.getPermitation(lists, nums[i]);
                }
            }
            for( List<Integer> list : lists){
                System.out.println(list);
            }
        }

        public static void getPermitation(List<List<Integer>> lists, int number){
            for(int j = 0; j < lists.size(); j++){
                List<Integer> list = lists.get(j);
                for ( int i = 0; i <= list.size(); i++){
                    if(i == 0){
                        List<Integer> newList = new ArrayList<>();
                        newList.add(number);
                        for( int x : list){
                            newList.add(x);
                        }
                        System.out.println(newList);
                        lists.add(newList);
                    } else if ( i == list.size()) {
                        List<Integer> newList = new ArrayList<>();
                        for ( int x = 0; x < list.size(); x++){
                            newList.add(list.get(x));
                        }
                        newList.add(number);
                        System.out.println(newList);
                        lists.set(j, newList);
                    } else {
                        List<Integer> newList = new ArrayList<>();
                        for ( int x = 0; x <= list.size();x++){
                            if(x < i){
                                newList.add(list.get(x));
                            } else if ( x==i) {
                                newList.add(number);
                            } else{
                                newList.add(list.get(x - 1));
                            }
                        }
                        System.out.println(newList);
                        lists.add(newList);
                    }
                }
            }
        }
}

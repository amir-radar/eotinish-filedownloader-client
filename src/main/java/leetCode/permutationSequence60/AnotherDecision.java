package leetCode.permutationSequence60;

import java.util.ArrayList;
import java.util.List;

public class AnotherDecision {

    public static void main(String[] args) {
        AnotherDecision anotherDecision = new AnotherDecision();
        System.out.println(anotherDecision.getPermutation(5,66));
    }

    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> numbers=new ArrayList();
        for(int i=1;i<n;i++){
            fact=fact*i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder ans=new StringBuilder();
        k=k-1;
        while(true){
            ans.append(numbers.get(k/fact));
            numbers.remove(k/fact);
            if(numbers.size()==0)
                break;
            k=k%fact;
            fact=fact/numbers.size();

        }
        return ans.toString();
    }

}

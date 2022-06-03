package leetCode.permutationSequence60;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence60 {

    public static void main(String[] args) {

        PermutationSequence60 ps60 = new PermutationSequence60();
        System.out.println(ps60.getPermutation(5,66));
    }

    public String getPermutation(int n, int k) {
        int[] ints = getAllN(n);
        String result = "";
        int newK = k;
        for (int y = n; y >= 2; y--){
            int factXMinusOne = getFactorial(y - 1);
            int t = getNumber(y, factXMinusOne, newK);
            newK = newK - (t-1) * factXMinusOne;
            result = result + ints[t-1];
            int z = ints[t-1];
            ints = delNFromMassive(z, ints);
        }
        result = result + ints[0];
        return result;
    }

    private int[] delNFromMassive(int t, int[] ints){
        List result = new LinkedList();
        for (int x : ints){
            if (t != x){
                result.add(x);
            }
        }
        int[] newInts = new int[ints.length - 1];
        for (int x = 0; x < ints.length - 1; x++){
            newInts[x] = (int)result.get(x);
        }
        return newInts;
    }

    private int[] getAllN(int n){
        int[] ints = new int[n];
        for (int x = 1; x <= n; x ++){
            ints[x-1] = x;
        }
        return ints;
    }

    private int getNumber(int n, int factNMinusOne, int k){
        double d = (double)k/(double)factNMinusOne;
        d = Math.ceil(d);
        int z = (int) d;
        return z;
    }

    private int getFactorial(int x){
        int factorial = 1;
        for (int y = 1; y <= x; y++){
            factorial = factorial * y;
        }
        return factorial;
    }
}

package leetCode.algorithms.one;

public class TwoSumII {

    public static void main(String[] args) {
        int[] ints = new int[]{0, 0, 3, 4};
        int n = 0;
        TwoSumII twoSumII = new TwoSumII();
        int[] newInts = twoSumII.findNumbersAdditionEqualN(ints, n);
        System.out.println("newInts[0] = " + newInts[0]);
        System.out.println("newInts[1] = " + newInts[1]);
        System.out.println("[" + newInts[0] + "," + newInts[1] + "]");

    }

    public int[] findNumbersAdditionEqualN(int[] numbers, int target){
        int[] newInts = new int[2];
//        for(int x = 0; x < numbers.length; x++){
//            for(int y = 0; y < numbers.length; y++){
//                if (x != y){
//                    if (numbers[x] + numbers[y] == target){
//                        newInts[0] = y + 1;
//                        newInts[1] = x + 1;
//                    }
//                }
//            }
//        }
        for (int x = 0; x < numbers.length; x++){
            int t = target - numbers[x];

            int firstIndex = 0;
            int lastIndex = numbers.length - 1;

            int a = 1;
            int b = 1;
            while(firstIndex <= lastIndex){
                int middleIndex = (firstIndex + lastIndex) /  2;
                if (middleIndex == x){
                    break;
                }
                if (numbers[middleIndex] == t){
                    a = a + middleIndex;
                    b = b + x;
                    if (a > b){
                        newInts[0] = b;
                        newInts[1] = a;
                    } else {
                        newInts[0] = a;
                        newInts[1] = b;
                    }
                    break;
                } else if (numbers[middleIndex] < t){
                    firstIndex = middleIndex + 1;
                } else if (numbers[middleIndex] > t){
                    lastIndex = middleIndex - 1;
                }
            }
        }
        return newInts;
    }

//    private boolean isAdditionResultIsN(int a, int b, int x){
//        if (a + b == x){
//            return true;
//        }
//        return false;
//    }
}

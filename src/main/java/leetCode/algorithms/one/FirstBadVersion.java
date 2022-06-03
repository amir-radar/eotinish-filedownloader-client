package leetCode.algorithms.one;

public class FirstBadVersion {

    private static final int badVersion = 4;

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.findFirstBadVersion(100000));
        //System.out.println(firstBadVersion.isBadVersion(500000));
    }

    public int findFirstBadVersion(int n) {
        int t = 0;

        int firstIndex = 1;
        int lastIndex = n;

        while (firstIndex <= lastIndex){
            int middleIndex = (lastIndex + firstIndex) / 2;
            if (!isBadVersion(middleIndex)){
                firstIndex = middleIndex + 1;
            } else {
//                if (isBadVersion(middleIndex - 1)){
//                    lastIndex = middleIndex - 1;
//                } else {
//                    t = middleIndex;
//                    break;
//                }

            }
        }
        return t;
    }

    private boolean isBadVersion(int n){
        return n >= badVersion;
    }
//Time Limit Exceeded
//    public int findFirstBadVersion(int n) {
//        int t = 0;
//
//        int firstIndex = 1;
//        int lastIndex = n;
//
//        while (firstIndex <= lastIndex){
//            int middleIndex = (lastIndex + firstIndex) / 2;
//            if (!isBadVersion(middleIndex)){
//                firstIndex = middleIndex + 1;
//            } else {
//                if (isBadVersion(middleIndex - 1)){
//                    lastIndex = middleIndex - 1;
//                } else {
//                    t = middleIndex;
//                    break;
//                }
//            }
//        }
//        return t;
//    }
}


package testAnyMethods;

import java.security.SecureRandom;

public class RandomArray {
    private static final int VALUES_LENGTH = 10001;

    public static void main(String[] args) {
        int[] randomInts = new int[VALUES_LENGTH];
        for (int i = 0; i < randomInts.length; i++) {
            randomInts[i] = i+1;
        }



    }

    private static int generateRandom(int n){
        SecureRandom random = new SecureRandom();
        byte[] bytes = random.generateSeed(200);
        random.nextBytes(bytes);
        return random.nextInt(n + 1);
    }
}

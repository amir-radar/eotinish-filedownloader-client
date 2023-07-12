package workWithZipFile;

import java.io.*;

public class Tester {

    public static void main(String[] args) throws IOException {
        CleanZipFile tester = new CleanZipFile();
        System.out.println(tester.modifyTextFileInZip());
    }
}
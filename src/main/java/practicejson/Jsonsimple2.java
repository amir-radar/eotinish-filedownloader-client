package practicejson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Jsonsimple2 {
    private final String fileWithData = "C:\\Users\\w2\\Downloads\\text_for_parse.txt";

    public String parseFile() throws IOException {
        FileReader input = new FileReader(fileWithData);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(input)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
//        System.out.println(builder.toString());
        String str = builder.toString();
        return str;
    }

    public List<String>[] partition(List<String> list){
        int size = list.size();
        int m = size / 8;
        if (size % 8 != 0) {
            m++;
        }
        List<String>[] partition = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            partition[i] = new ArrayList();
        }


        for (int i = 0; i < size; i++)
        {
            int index = i / 8;
            partition[index].add(list.get(i));
        }


        return partition;
    }





    public String substringFirstSymbolInString(String str) {
        int length = str.length();
        return str.substring(1, length);
    }

    public String substringEndSymbolInString(String str) {
        int length = str.length();
        return str.substring(0, length - 1);
    }

}


    /*public List<String> fromArrayToList(String[] strs) {
        List<String> newStrs = new ArrayList<>();
        for (String str : strs) {
            newStrs.add(str);
        }
        return newStrs;
    }*/













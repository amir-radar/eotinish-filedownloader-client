package other;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocxDocumentCleaner {
    public static final String DOCX_FILE_PATH = "C:\\Users\\Amirzhan\\Desktop\\test.xml";

    public static void main(String[] args) throws IOException {
        String fileString = readFileToString(DOCX_FILE_PATH);
        System.out.println(fileString.replaceAll("(</w:t>)([.\\S\\s]{50,150})(<w:t>)", ""));
    }

    public static String readFileToString(String filePath) throws IOException {
        FileReader input = new FileReader(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(input)){
            String line = null;
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }
}

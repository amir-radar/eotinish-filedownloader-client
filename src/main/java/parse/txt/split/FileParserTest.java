package parse.txt.split;

import com.fasterxml.jackson.databind.ObjectMapper;
import compareJsons.dto.JsonFileDto;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileParserTest {

    public static void main(String[] args) throws IOException {
        String jsonString = "{\"number\": \"0\",\"id\": \"361\",\"repCode\": \"REP_TEST\",\"repName\": \"Тестовый отчет\",\"repType\": \"JASPER\",\"repFileName\": \"REP_TEST.jrxml\",\"repFileType\": \"application/octet-stream\",\"updated\": \"11.01.2015 22:02:11\"}";
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(jsonString, ReportInfo.class));
    }

    public String parseFile(String pathToFile){ //на вход задается один параметр в виде строки, и это путь к файлу на компе
        String parsedString = null;
        //some code ...
        return parsedString;
    }
}
package compareJsons.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import compareJsons.dto.JsonFileDto;
import jdk.nashorn.internal.parser.JSONParser;
import parse.txt.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {
    public final String devArticleFile = "D:\\repo\\torelik\\dev\\court-main\\court-app\\app\\dictionary\\criminal\\newArticle.json";
    public final String masterArticleFile = "D:\\repo\\torelik\\prod\\court-main\\court-app\\app\\dictionary\\criminal\\newArticle.json";

    public List<JsonFileDto> parseJson(String path) throws IOException {
        List<JsonFileDto> fileDtoList = new ArrayList<>();
        FileReader input = new FileReader(path);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(input)){
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(builder.toString(), JsonFileDto[].class));
    }
}

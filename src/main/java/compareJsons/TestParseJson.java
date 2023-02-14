package compareJsons;

import compareJsons.dto.JsonFileDto;
import compareJsons.entity.JsonFile;
import compareJsons.parser.FileParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestParseJson {
    public static void main(String[] args) {
        FileParser parser = new FileParser();
        List<JsonFileDto> devJsonDtoList = new ArrayList<>();
        List<JsonFileDto> masterJsonDtoList = new ArrayList<>();
        try {
            devJsonDtoList = parser.parseJson(parser.devArticleFile);
        } catch (IOException e) {
            System.out.println("Error in read dev file");
            e.printStackTrace();
        }
        try {
            masterJsonDtoList = parser.parseJson(parser.masterArticleFile);
        } catch (IOException e) {
            System.out.println("Error in read master file");
            e.printStackTrace();
        }

        List<JsonFile> devJsonFileList = new ArrayList<>();
        List<JsonFile> masterJsonFileList = new ArrayList<>();

        for (JsonFileDto fileDto : devJsonDtoList) {
            devJsonFileList.add(new JsonFile(fileDto));
        }
        for (JsonFileDto fileDto : masterJsonDtoList) {
            devJsonFileList.remove(new JsonFile(fileDto));
        }

        for (JsonFile jsonFile : devJsonFileList) {
            System.out.println(jsonFile);
        }
    }
}

package parse.txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TxtParser {
    private static final String FILE_PATH = "C:\\Users\\Amirzhan\\Downloads\\Telegram Desktop\\p25-65 (1)\\p25-65.txt";

    public static void main(String[] args) throws IOException {
        FileReader input = new FileReader(FILE_PATH);
        PersonDao personDao = new PersonDaoImpl();
        try (BufferedReader reader = new BufferedReader(input)){
            String line = null;
            for (int i = 0; i < 10; i++) {
                line = reader.readLine();
                if (i > 0 && line != null){
                    String[] anyPersonsInfo = line.split("\\|");
                    Person newPerson = new Person(anyPersonsInfo[0], anyPersonsInfo[1], anyPersonsInfo[2], anyPersonsInfo[3], parseDateFromString(anyPersonsInfo[4]));
                    System.out.println(newPerson);
                    personDao.savePerson(newPerson);
                }
            }
        }
    }

    private static Date parseDateFromString(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd:HH:mm:ss aaa");
        Date date = new Date();
        try {
            date = formatter.parse(dateStr);
        } catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
}

package eotinish.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;

public class Tester {

    private static final String SHEP_DATE_TIME_FORMAT_STR = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static void main(String[] args) throws ParseException {
        String strDateTime = "2022-02-22T03:00:00.000Z";
        Tester tester = new Tester();
        //Date SDFormat = tester.formatFromShepToDateTime(strDateTime);
        Date SDFormat = tester.formatFromStrToDate(strDateTime);
        System.out.println(SDFormat);
    }

    private Date formatFromShepToDateTime(String value) throws ParseException {
        return new SimpleDateFormat(SHEP_DATE_TIME_FORMAT_STR).parse(value);
    }

    private Date formatFromStrToDate(String str){
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(str);
        return new Date(offsetDateTime.toInstant().toEpochMilli());
    }
}
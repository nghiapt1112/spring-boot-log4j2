package com.example.tut.testcsv;

import com.example.tut.csv.CSVReader;
import com.example.tut.csv.object.CSVResponse;
import com.example.tut.csv.UserCSV;
import com.example.tut.csv.utils.DateTimeUtils;
import org.junit.Test;

import java.util.Date;

public class CSVTest {

    private static final String DIR_PATH = "/src/test/resources/";

    @Test
    public void readCSV() {
        CSVReader csvReader = CSVReader.getInstance().withTyped(UserCSV.class);
        CSVResponse csvResponse = csvReader.readFile(DIR_PATH + "csv_data/user.csv");
        System.out.println(csvResponse.getResponse());
        System.out.println(csvResponse.getErrors());
        System.out.println();
    }

    @Test
    public void parseDate(){
        Date dateVal = DateTimeUtils.valueOf("yyyy/MM/dd","1993/12/11");
        String dateString = DateTimeUtils.toString("yyyy/MM/dd", dateVal);
        System.out.println(dateVal);
    }


//    @Test
//    public void testParse() {
//        CSVReader.getInstance().parseObject("emailString".split(","), UserCSV.class.getDeclaredFields());
//    }
}

package com.example.log4j2demo.testcsv;

import com.example.log4j2demo.csv.CSVReader;
import com.example.log4j2demo.csv.UserCSV;
import org.junit.Test;

import java.util.List;

public class CSVTest {

    private static final String DIR_PATH = "/src/test/resources/";

    @Test
    public void readCSV() {
        CSVReader csvReader = CSVReader.getInstance();
        List<UserCSV> lines = csvReader.readFile(DIR_PATH + "csv_data/user.csv", UserCSV.class);
        System.out.println(lines);
    }


//    @Test
//    public void testParse() {
//        CSVReader.getInstance().parseObject("emailString".split(","), UserCSV.class.getDeclaredFields());
//    }
}

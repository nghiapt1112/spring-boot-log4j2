package com.example.tut.csv;

import com.example.tut.csv.annotation.CSVField;
import com.example.tut.csv.object.CSVError;
import com.example.tut.csv.object.CSVResponse;
import com.example.tut.csv.parser.DefaultCSVParser;
import com.example.tut.csv.parser.Parser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CSVReader<T> {
    public static final int EOF = -1;
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;
    private static final String DEFAULT_SEPARATE = ",";
    private static final String EMPTY_STRING = "";

    private static CSVReader instance = new CSVReader();
    private Class<T> typed = null;

    public static CSVReader getInstance() {
        return instance;
    }

    public CSVReader withTyped(Class<T> typed) {
        instance.typed = typed;
        return instance;
    }

    public CSVResponse<T> readFile(String fileName) {
        try {
            List<String> lines = Files.lines(Paths.get(new ClassPathResource(fileName).getPath()))
                    .collect(Collectors.toList());

            final LinkedHashMap<String, Integer> csvHeader = getHeader(lines.get(0));

            List<T> response = new ArrayList<>();
            List<CSVError> errors = new ArrayList<>();

            lines.stream().skip(1)
                    .parallel()
                    .map(line -> splitObject(DEFAULT_SEPARATE, line))
                    .forEach(rowValue -> parseObject(csvHeader, rowValue, typed, response, errors)); // map val -> fields

            return new CSVResponse(response, errors);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private LinkedHashMap<String, Integer> getHeader(String firstLine) {
        String[] columnName = splitObject(DEFAULT_SEPARATE, firstLine);
        LinkedHashMap<String, Integer> csvHeader = new LinkedHashMap<>();
        for (int i = 0; i < columnName.length; i++) {
            csvHeader.put(columnName[i].trim(), i);
        }
        return csvHeader;
    }

    /**
     * Split data theo tung line, ngan cach nhau boi dau separate<br>
     *
     * <code>String = val1,val2,val3,val4,val5,val6,val7,val8,val9</code><br>
     * will be parse to:<br>
     * <code>values = ["val1","val2","val3","val4","val5","val6","val7","val8","val9"];</code><br>
     */
    private String[] splitObject(String separate, String val) {
        String[] value = val.split(separate, -1);
        return value;
    }

    /**
     * Parse tung line thanh object
     */
    public void parseObject(LinkedHashMap<String, Integer> csvHeader, String[] rowValue, Class<T> typed, List<T> response, List<CSVError> errors) {
        try {
            T rowObject = typed.newInstance();
            final Field[] fields = typed.getDeclaredFields();
            if (fields.length != rowValue.length) {
                throw new RuntimeException("Data in csv file is not mapped with Bean object.");
            }
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                String columnName = getCSVColumnName(f);
                try {
                    setValueToField(rowObject, f, rowValue[csvHeader.get(columnName)]);
                } catch (Exception e) {
//                    e.printStackTrace();
                    errors.add(CSVError.builder()
                            .line(i)
                            .columnName(columnName)
                            .exception(e)
                            .build());
                }
            }
            response.add(rowObject);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * Return csv-column name
     */
    private String getCSVColumnName(Field f) {
        CSVField csvFieldConfig = f.getAnnotation(CSVField.class);
        if (Objects.nonNull(csvFieldConfig) && StringUtils.isNoneEmpty(csvFieldConfig.name())) {
            return csvFieldConfig.name();
        } else {
            return f.getName();
        }
    }

    /**
     * Parse value cho tung field
     * <p>
     * CSV data => Object 's field data.
     */
    private void setValueToField(T instance, Field f, String val) throws IntrospectionException,
            IllegalAccessException, InvocationTargetException {
        PropertyDescriptor pd = new PropertyDescriptor(f.getName(), instance.getClass());

        Parser parser = new DefaultCSVParser(f).getParser();
        pd.getWriteMethod().invoke(instance, parser.parse(val));
    }

    public void func(Consumer consumer) {

    }

    public File[] readDir(String dirPath) {
        try {
            File[] files = new File(ClassLoader.getSystemResource(dirPath).getFile()).listFiles();
            if (Objects.isNull(files)) {
//                LOGGER.error("Folder is empty");
                return null;
            }

            for (File file : files) {
                try (FileInputStream fIs = new FileInputStream(file)) {
                    this.executeFile(fIs);
                } catch (FileNotFoundException e) {

                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeFile(InputStream is) {

    }

}

package com.example.log4j2demo.csv;

import com.example.log4j2demo.csv.annotation.CSVField;
import com.example.log4j2demo.csv.parser.DefaultCSVParser;
import com.example.log4j2demo.csv.parser.Parser;
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

    public void executeFile(InputStream is) {

    }

    public List<T> readFile(String fileName) {
        try {
            List<String> lines = Files.lines(Paths.get(new ClassPathResource(fileName).getPath()))
                    .collect(Collectors.toList());


            String[] input = splitObject(DEFAULT_SEPARATE, lines.get(0));
            LinkedHashMap<String, Integer> csvHeader = new LinkedHashMap<>();
            for (int i = 0; i < input.length; i++) {
                csvHeader.put(input[i].trim(), i);
            }

            return lines.stream().skip(1)
                    .map(el -> splitObject(DEFAULT_SEPARATE, el))
                    .map(el -> parseObject(csvHeader, el, typed.getDeclaredFields(), typed)) // map val -> fields
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
    public T parseObject(LinkedHashMap<String, Integer> csvHeader, String[] vals, Field[] fields, Class<T> typed) {
        try {
            T instance = typed.newInstance();
            if (fields.length != vals.length) {
                throw new RuntimeException("Data in csv file is not mapped with Bean object.");
            }
            for (int i=0; i< fields.length; i++) {
                Field f = fields[i];
                String columnName = getCSVColumnName(f);
                try {
                    setValueToField(instance, f, vals[csvHeader.get(columnName)]);
                } catch (Exception e) {
                    e.printStackTrace();
//                    CSVError csvError = CSVError.builder()
//                            .line(i)
//                            .columnName(columnName)
//                            .description("Message loi o day")
//                            .build();
                }
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
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
     *
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
}

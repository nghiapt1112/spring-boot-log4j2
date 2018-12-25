package com.example.log4j2demo.csv;

import com.example.log4j2demo.csv.annotation.CSVField;
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
import java.util.stream.Collectors;

public class CSVReader {
    public static final int EOF = -1;
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;
    private static final String DEFAULT_SEPARATE = ",";

    private static CSVReader instance = new CSVReader();

    public static CSVReader getInstance() {
        return instance;
    }

    public void executeFile(InputStream is) {

    }

    public <T> List<T> readFile(String fileName, Class<T> typed) {
        try {
            List<String> lines = Files.lines(Paths.get(new ClassPathResource(fileName).getPath()))
                    .collect(Collectors.toList());
            ;

            String[] input = splitObject(DEFAULT_SEPARATE, lines.get(0));
            LinkedHashMap<String, Integer> csvHeader = new LinkedHashMap<>();
            for (int i = 0; i < input.length; i++) {
                csvHeader.put(input[i].trim(), i);
            }

            return lines.stream().skip(1)
                    .map(el -> splitObject(DEFAULT_SEPARATE, el)) // line => list of val
                    .map(el -> parseObject(csvHeader, el, typed.getDeclaredFields(), typed)) // map val -> fields
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String[] splitObject(String seperate, String val) {
        return val.split(seperate);
    }

    public <T> T parseObject(LinkedHashMap<String, Integer> csvHeader, String[] vals, Field[] fields, Class<T> typed) {
        try {
            T instance = typed.newInstance();

            for (Field f : fields) {
                String columnName = getCSVColumnName(f);
                setValueToField(instance, f, vals[csvHeader.get(columnName)]);
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

    private <T> void setValueToField(T instance, Field f, String val) {
        try {

            PropertyDescriptor pd = new PropertyDescriptor(f.getName(), instance.getClass());

            if (f.getType() == Integer.class) {
                pd.getWriteMethod().invoke(instance, Integer.valueOf(val));
            } else {
                pd.getWriteMethod().invoke(instance, val);
            }

        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            // cast loi, fieldType la : {}, expected type la:
            Class<?> fieldType = f.getType();
        }
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
package com.example.log4j2demo;

import com.example.log4j2demo.domain.Org;
import com.nghia.libraries.commons.mss.utils.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
public class Log4j2DemoApplicationTests {
    private ArrayList<Org> orgs = null;
    @Before
    public void initialize() throws IOException {
        InputStream is = new ClassPathResource("/test_data/org.json").getInputStream();
        String fileContent = IOUtils.toString(is, Charset.defaultCharset());
        orgs = JsonUtils.toCollection(fileContent, ArrayList.class, Org.class);
    }
    @Test
    public void org() throws IOException {


//        System.out.println("DONE");
//
//
//        Org build = new Org();
//        Org tree = build.buildTree(orgs);
//
//        System.out.println(JsonUtils.toJson(tree));


        Map<String, List<Org>> groupByLevel = orgs.stream().collect(Collectors.groupingBy(el -> el.getParentIdsAsString()));
        System.out.println();
    }

}

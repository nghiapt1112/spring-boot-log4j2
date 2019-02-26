package com.example.tut;

import com.example.tut.tree.Org;
import com.example.tut.tree.OrgForBuild;
import com.example.tut.tree.OrgMapBuild;
import com.example.tut.utils.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
public class Log4j2DemoApplicationTests {
    StopWatch forWatch;
    StopWatch mapWatch;
    private ArrayList<Org> orgs = null;
    private ArrayList<Org> orgsPrepareFor = null;
    private ArrayList<Org> orgsPrepareMap = null;
    private OrgForBuild orgFor;
    private OrgMapBuild orgMap;

    @Before
    public void initialize() throws IOException {
        InputStream is = new ClassPathResource("/test_data/org.json").getInputStream();
        String fileContent = IOUtils.toString(is, Charset.defaultCharset());
        orgs = JsonUtils.toCollection(fileContent, ArrayList.class, Org.class);

        orgsPrepareFor = new ArrayList<>(orgs);
        orgsPrepareMap = new ArrayList<>(orgs);

        forWatch = new StopWatch();
        mapWatch = new StopWatch();

        orgFor = new OrgForBuild();
        orgMap = new OrgMapBuild();
    }

    @Test
    public void org() throws IOException, InterruptedException {
        System.out.println();


        forBuild();
        mapBuild();


//       Assert.assertEquals(JsonUtils.toJson(forTree), JsonUtils.toJson(mapTree));
    }

    private void forBuild() {
        forWatch.start();
        Org forTree = orgFor.buildTree(orgsPrepareFor);
        System.out.println(forWatch.getNanoTime());
    }

    private void mapBuild() {
        mapWatch.start();
        Org mapTree = orgMap.buildTreeV2(orgsPrepareMap);
        System.out.println(mapWatch.getNanoTime());
    }


    @Test
    public void groupWithLambda() {
        Map<String, List<Org>> groupByLevel = orgs.stream().collect(Collectors.groupingBy(el -> el.getParentIdsAsString()));
        System.out.println();

    }
}
